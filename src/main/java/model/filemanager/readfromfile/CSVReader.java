package model.filemanager.readfromfile;

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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements FileReader {
    @Override
    public List<?> ReadFromFile(String fileName) {
        Path path = Paths.get(fileName.concat(".csv"));
        String line;
        List<Object> data = new ArrayList<>();
        try (
            var reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1)
            ) {
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    protected static int createIdCSV(String filename) {
        Path path = Paths.get(filename.concat(".csv"));
        int ID = 0;
        String line;
        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1)
        ) {
            while ((line = reader.readLine()) != null) {
                ID++;
            }

            return ID;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    protected static ArrayList<Employer> getEmployersFomCSV() {
        Path path = Paths.get("data/employer/employer.csv");
        String line;
        ArrayList<Employer> employers = new ArrayList<>();
        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1)
                ) {

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length > 0 && (data[0].compareTo("employerID")!= 0)  ) {
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

    protected static ArrayList<WorkReference> getWorkReferenceFromCSV(String filename) {
        Path path = Paths.get(filename.concat(".csv"));
        String line;
        ArrayList<WorkReference> work = new ArrayList<>();

        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1)
        ) {

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > 0 && data[0].compareTo("referenceID") != 0) {
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

        }

        if (work.isEmpty()) return new ArrayList<>();

        return work;
    }

    protected static ArrayList<Education> getEducationFromCSV(String filename) {
        Path path = Paths.get(filename.concat(".csv"));
        String line;
        ArrayList<Education> education = new ArrayList<>();

        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1)
        ) {

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > 0 && data[0].compareTo("educationID") != 0) {
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

        }

        if (education.isEmpty()) return new ArrayList<>();

        return education;
    }

    public static ArrayList<Work> getWorkFromCSV(String filename) {
        Path path = Paths.get(filename.concat(".csv"));
        String line;
        ArrayList<Work> work = new ArrayList<>();

        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1)
                ) {

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > 0 && data[0].compareTo("workID") != 0) {
                    int substituteID = Integer.parseInt(data[1]);
                    String companyName = data[2];
                    String position = data[3];
                    Sector s = Sector.valueOf(data[4].toUpperCase().trim());
                    Industry i = Industry.fromString(data[5]);
                    String from = data[6];
                    String to = data[7];
                    LocalDate f = LocalDate.parse(from, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    LocalDate t = LocalDate.parse(to, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    Work w = new Work(companyName, position, s, i, f, t);
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

    public static ArrayList<SubstitutePosition> substitutePositionFromCSV(String filename) {
        Path path = Paths.get(filename.concat(".csv"));
        String line;
        ArrayList<SubstitutePosition> substitutes = new ArrayList<>();
        ArrayList<Employer> employers = new ArrayList<>(CSVReader.getEmployersFomCSV());

        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
                ) {

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                Employer emp;
                if (data.length > 0 && data[0].compareTo("positionID") != 0) {
                    int ID = Integer.parseInt(data[0]);
                    int employerID = Integer.parseInt(data[1]);
                    for (Employer e : employers) {
                        if (e.getID() == employerID) {
                            emp = e;
                            String[] from = data[7].split(",");
                            String[] to = data[8].split(",");
                            Month fromMonth = Month.valueOf(from[0]);
                            int fromYear = Integer.parseInt(from[1].trim());
                            Month toMonth = Month.valueOf(to[0]);
                            int toYear = Integer.parseInt(from[1].trim());

                            Industry w = Industry.fromString(data[5]);
                            Sector s = Sector.valueOf(data[6]);

                            SubstitutePosition sub = new SubstitutePosition(emp, w, s, fromMonth, fromYear, toMonth, toYear);
                            sub.setID(ID);
                            sub.setPositionTitle(data[3]);
                            substitutes.add(sub);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (substitutes.isEmpty()) return new ArrayList<>();

        return substitutes;
    }

    public static ArrayList<Substitute> getSubstitutesFromCSV() {
        Path path = Paths.get("data/substitute.csv");
        String line;
        ArrayList<Substitute> substitutes = new ArrayList<>();
        ArrayList<Work> work = new ArrayList<>(CSVReader.getWorkFromCSV("data/workExperience"));
        ArrayList<WorkReference> wr = new ArrayList<>(CSVReader.getWorkReferenceFromCSV("data/workReference"));
        ArrayList<Education> edu = new ArrayList<>(CSVReader.getEducationFromCSV("data/education"));

        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
                ) {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length > 0 && (data[0].compareTo("substituteID") != 0)) {
                    int subID = Integer.parseInt(data[0]);
                    String first = data[1];
                    String last = data[2];
                    LocalDate born = LocalDate.parse(data[3]);
                    String address = data[4];
                    String phone = data[5];
                    String eMail = data[6];
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
                    substitutes.add(substitute);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (substitutes.isEmpty()) return new ArrayList<>();

        return substitutes;
    }

     public ArrayList<String> findAttributes(String filename, int id) {
        Path path = Paths.get(filename.concat(".csv"));
        String line;
        String ID = Integer.toString(id);

        ArrayList<String> matches = new ArrayList<>();
        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
                ) {

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > 0) {
                    String substituteID = data[1];
                    if (substituteID.compareTo(ID) == 0) {
                        matches.add(line);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (matches.isEmpty()) {
            return null;
        }

        return matches;
    }

}
