package model.filemanager.readfromfile;

import javafx.scene.control.Alert;
import model.data.employer.Industry;
import model.data.employer.Sector;
import model.data.employer.Employer;
import model.data.substituteposition.SubstitutePosition;
import model.data.substitute.Substitute;
import model.data.substitute.education.Education;
import model.data.substitute.education.EducationLevel;
import model.data.substitute.education.Subject;
import model.data.substitute.references.WorkReference;
import model.data.substitute.work.Work;
import utils.ErrorPopup;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader implements FileReader {
    private static final Charset encoding = StandardCharsets.ISO_8859_1;

    @Override
    public ArrayList<String> ReadFromFile(String fileName) {
        Path path = Paths.get(fileName.concat(".csv"));
        String line;
        ArrayList<String> data = new ArrayList<>();
        try (var reader = Files.newBufferedReader(path, encoding)) {
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static int createIdCSV(String filename) {
        Path path = Paths.get(filename.concat(".csv"));
        int ID = 1;

        try (var reader = Files.newBufferedReader(path, encoding)) {
            while (reader.readLine() != null) ID++;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ID;
    }

    public static ArrayList<Employer> getEmployersFomCSV() {
        Path path = Paths.get("data/employer/employer.csv");
        String line;
        ArrayList<Employer> employers = new ArrayList<>();
        try (var reader = Files.newBufferedReader(path, encoding)) {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length > 0) {
                    int employerID = Integer.parseInt(data[0]);
                    String companyName = data[1];
                    String cAddress = data[2];
                    Industry industry = Industry.fromString(data[3]);
                    Sector sector = Sector.valueOf(data[4].toUpperCase().trim());
                    String first = data[5];
                    String last = data[6];
                    String phone = data[7];
                    String email = data[8];
                    Employer employer = new Employer(companyName, cAddress, first, last, phone, email, industry, sector);
                    employer.setID(employerID);
                    employers.add(employer);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (employers.isEmpty()) {
            return new ArrayList<>();
        }

        return employers;
    }

    public static ArrayList<WorkReference> parseToWorkReference(String filename) {
        Path path = Paths.get(filename.concat(".csv"));
        String line;
        ArrayList<WorkReference> work = new ArrayList<>();

        try (var reader = Files.newBufferedReader(path, encoding)) {

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > 0) {
                    int referenceID = Integer.parseInt(data[0]);
                    int substituteID = Integer.parseInt(data[1]);
                    String companyName = data[2];
                    String contactName = data[3];
                    String phoneNumber = data[4];
                    String eMail = data[5];

                    WorkReference w = new WorkReference(contactName, phoneNumber, eMail, companyName);
                    w.setID(referenceID);
                    w.setSubstituteID(substituteID);
                    work.add(w);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (work.isEmpty()) return new ArrayList<>();

        return work;
    }

    public static ArrayList<Education> parseToEducation(String filename) throws IOException {
        Path path = Paths.get(filename.concat(".csv"));
        String line;
        ArrayList<Education> education = new ArrayList<>();

        try (var reader = Files.newBufferedReader(path, encoding)) {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > 0) {
                    int educationID = Integer.parseInt(data[0]);
                    int substituteID = Integer.parseInt(data[1]);
                    String schoolname = data[2];
                    EducationLevel level = EducationLevel.fromString(data[3]);
                    Subject subject = Subject.fromString(data[4]);
                    String degree = data[5];
                    String[] from = data[6].split(",");
                    String[] to = data[7].split(",");
                    Month fromMonth = Month.valueOf(from[0]);
                    int fromYear = Integer.parseInt(from[1].trim());
                    Month toMonth = Month.valueOf(to[0]);
                    int toYear = Integer.parseInt(from[1].trim());
                    boolean isStudying = Boolean.parseBoolean(data[8]);

                    Education w = new Education(schoolname, subject, level, degree, fromMonth, fromYear, toMonth, toYear, isStudying);
                    w.setSubstituteID(substituteID);
                    w.setID(educationID);
                    education.add(w);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        if (education.isEmpty()) return new ArrayList<>();

        return education;
    }

    public static ArrayList<Work> parseToWork(String filename) throws IOException {
        Path path = Paths.get(filename.concat(".csv"));
        String line;
        ArrayList<Work> work = new ArrayList<>();

        var reader = Files.newBufferedReader(path, encoding);

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > 0) {
                    int workID = Integer.parseInt(data[0]);
                    int substituteID = Integer.parseInt(data[1]);
                    String companyName = data[2];
                    String position = data[3];
                    Sector sector = Sector.NULL;
                    if (data[4] != null) {
                        sector = Sector.valueOf(data[4].toUpperCase().trim());
                    }
                    Industry i = Industry.fromString(data[5]);
                    String from = data[6];
                    String to = data[7];
                    LocalDate f = LocalDate.parse(from, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    LocalDate t = LocalDate.parse(to, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    Work w = new Work(companyName, position, sector, i, f, t);
                    w.setSubstituteID(substituteID);
                    w.setID(workID);
                    work.add(w);
                }

            }

        if (work.isEmpty()) return new ArrayList<>();

        return work;
    }

    public static ArrayList<SubstitutePosition> parseToSubstitutePosition(String filename) {
        Path path = Paths.get(filename.concat(".csv"));
        String line;
        ArrayList<SubstitutePosition> substitutes = new ArrayList<>();
        ArrayList<Employer> employers = new ArrayList<>(CSVReader.getEmployersFomCSV());

        try (var reader = Files.newBufferedReader(path, encoding)) {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                Employer emp;
                if (data.length > 0) {
                    int ID = Integer.parseInt(data[0]);
                    int employerID = Integer.parseInt(data[1]);
                    for (Employer e : employers) {
                        if (e.getID() == employerID) {
                            emp = e;
                            String positionTitle = data[3];
                            String location = data[4];
                            String description = data[5];
                            Industry w = Industry.fromString(data[6]);
                            Sector s = Sector.valueOf(data[7]);
                            String[] from = data[8].split(",");
                            String[] to = data[9].split(",");
                            Month fromMonth = Month.valueOf(from[0]);
                            int fromYear = Integer.parseInt(from[1].trim());
                            Month toMonth = Month.valueOf(to[0]);
                            int toYear = Integer.parseInt(from[1].trim());
                            String contactName = data[10];
                            String contactPhone = data[11];
                            String contactEmail = data[12];
                            String qualifications = data[13];
                            String workHours = data[14];
                            String salaryConditions = data[15];
                            String employmentConditions = data[16];

                            SubstitutePosition sub = new SubstitutePosition(emp, w, s, fromMonth, fromYear, toMonth, toYear);
                            sub.setID(ID);
                            sub.setPositionTitle(data[3]);
                            sub.setPositionTitle(positionTitle);
                            sub.setLocation(location);
                            sub.setDescription(description);
                            sub.setContactName(contactName);
                            sub.setContactPhone(contactPhone);
                            sub.setContactEMail(contactEmail);
                            sub.setQualifications(Arrays.asList(qualifications.split(", ")));
                            sub.setWorkHours(workHours);
                            sub.setSalaryConditions(salaryConditions);
                            sub.setEmploymentConditions(employmentConditions);
                            substitutes.add(sub);
                        }
                    }
                }
            }
        } catch (IOException e) {
            ErrorPopup.createAlert(Alert.AlertType.ERROR, "Error", e.getLocalizedMessage());
        }

        if (substitutes.isEmpty()) return new ArrayList<>();

        return substitutes;
    }

    public static ArrayList<Substitute> parseSubstitute() {
        Path path = Paths.get("data/substitute.csv");
        String line;

        ArrayList<Substitute> substitutes = new ArrayList<>();
        try (var reader = Files.newBufferedReader(path, encoding)) {
        ArrayList<Work> work = new ArrayList<>(CSVReader.parseToWork("data/workExperience"));
        ArrayList<WorkReference> wr = new ArrayList<>(CSVReader.parseToWorkReference("data/workReference"));
        ArrayList<Education> edu = new ArrayList<>(CSVReader.parseToEducation("data/education"));
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length > 0) {
                    int subID = Integer.parseInt(data[0]);
                    String first = data[1];
                    String last = data[2];
                    LocalDate born = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    String address = data[4];
                    String phone = data[5];
                    String eMail = data[6];
                    String wantedWorkFields = data[7];
                    boolean isEmployed = Boolean.parseBoolean(data[8]);
                    Substitute substitute = new Substitute(first, last, born, address, phone, eMail);
                    substitute.setID(subID);

                    List<Work> subwork = new ArrayList<>();
                    for (Work w : work) {
                        if (w.getSubstituteID() == substitute.getID()) {
                            subwork.add(w);
                        }
                    }

                    List<WorkReference> ref = new ArrayList<>();
                    for (WorkReference r : wr) {
                        if (r.getSubstituteID() == substitute.getID()) {
                            ref.add(r);
                        }
                    }

                    List<Education> education = new ArrayList<>();
                    for (Education e : edu) {
                        if (e.getSubstituteID() == substitute.getID()) {
                            education.add(e);
                        }
                    }

                    substitute.setWorkExperience(subwork);
                    substitute.setReferences(ref);
                    substitute.setEducation(education);
                    substitute.setWantedWorkFields(wantedWorkFields);
                    substitute.setIsEmployed(isEmployed);
                    substitutes.add(substitute);
                }
            }

        } catch (IOException e) {
            ErrorPopup.createAlert(Alert.AlertType.ERROR, "Error", e.getLocalizedMessage());
        }

        if (substitutes.isEmpty()) return new ArrayList<>();

        return substitutes;
    }

     public static String findLine(String filename, int id, int column) {
         Path path = Paths.get(filename.concat(".csv"));
         String line;
         String ID = Integer.toString(id);
         String found = null;
         try (var reader = Files.newBufferedReader(path, encoding)) {
             while ((line = reader.readLine()) != null) {
                 String[] data = line.split(";");
                 if (data.length > 0 && data.length > column) {
                     String fileID = data[column];
                     if (fileID.compareTo(ID) == 0) {
                         found = line;
                         return found;
                     }
                 }
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
         return found;
     }
}
