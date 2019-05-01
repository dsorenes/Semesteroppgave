package readfromfile;

import employer.Industry;
import employer.Sector;
import employer.register.Employer;
import employer.substituteposition.SubstitutePosition;
import substitute.register.Substitute;
import substitute.register.work.Work;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReadFromCSV implements ReadFromFile {
    @Override
    public ArrayList<String> ReadFromFile(String fileName) {
        Path path = Paths.get(fileName.concat(".csv"));
        String line;
        ArrayList<String> data = new ArrayList<>();
        try (
            var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
            ) {

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
        int ID = 0;
        String line;
        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
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

    public static ArrayList<Employer> getEmployersFomCSV() {
        Path path = Paths.get("data/employer/employer.csv");
        String line;
        ArrayList<Employer> employers = new ArrayList<>();
        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
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

    public static ArrayList<Work> getWorkFromCSV(String filename) {
        Path path = Paths.get(filename.concat(".csv"));
        String line;
        ArrayList<Work> work = new ArrayList<>();

        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
                ) {

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

            }

        } catch (IOException e) {

        }

        return null;
    }

    public static ArrayList<SubstitutePosition> substitutePositionFromCSV(String filename) {
        Path path = Paths.get(filename.concat(".csv"));
        String line;
        ArrayList<SubstitutePosition> substitutes = new ArrayList<>();
        ArrayList<Employer> employers = new ArrayList<>(ReadFromCSV.getEmployersFomCSV());

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

        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
                ) {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length > 0 && (data[0].compareTo("substituteID") != 0)) {
                    int subID = Integer.parseInt(data[0]);
                    String first = data[1];
                    String last = data[2];
                    LocalDate born = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    String address = data[4];
                    String phone = data[5];
                    String eMail = data[6];
                    Substitute substitute = new Substitute(first, last, born, address, phone, eMail);
                    substitute.setID(subID);

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
                var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
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
