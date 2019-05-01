package employer.substituteposition;

import employer.Industry;
import employer.Sector;
import employer.register.Employer;
import employer.Position;
import readfromfile.ReadFromCSV;
import substitute.register.Substitute;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class SubstitutePosition {

    private int substitutePositionID;
    private boolean isAvailable = true;
    private String location;
    private Industry position;
    private Month fromMonth;
    private Month toMonth;
    private int fromYear;
    private int toYear;
    private String positionType;
    private List<String> qualifications;
    private String employmentConditions;
    private Employer employer;
    private String description;
    private Substitute substitute;
    private Sector sector;
    private String workHours;
    private String salaryConditions;
    private String positionTitle;
    private String contactName;
    private String contactPhone;
    private String contactEMail;
    private String to;
    private String from;
    private String companyName;

    public SubstitutePosition (Employer employer, Industry position, Sector sector, Month fromMonth, int fromYear, Month toMonth, int toYear) {
        this.employer =employer;
        this.position = position;
        this.sector = sector;
        this.fromMonth = fromMonth;
        this.fromYear = fromYear;
        this.toMonth = toMonth;
        this.toYear = toYear;
        this.companyName = employer.getCompanyName();

        this.from = fromMonth + ", " + fromYear;
        this.to = toMonth + ", " + toYear;
    }

    @Override
    public String toString() {
        return  substitutePositionID + ";" +
                this.getEmployerID() + ";" +
                this.employer.getCompanyName()+ ";" +
                positionTitle + ";" +
                description + ";" +
                position + ";" +
                sector + ";" +
                from + ';' +
                to;
    }

    public static ArrayList<SubstitutePosition> positionFromCSV(ArrayList<String> attributes) {
        ArrayList<SubstitutePosition> substitutes = new ArrayList<>();
        ArrayList<Employer> employers = new ArrayList<>(ReadFromCSV.getEmployers());
        attributes.remove(0);

        for (String i : attributes) {
            String[] data = i.split(";");
            Employer emp = null;
            if (data.length > 0) {
                int ID = Integer.parseInt(data[0]);
                int employerID = Integer.parseInt(data[1]);
                for (Employer e : employers) {
                    if (e.getID() == employerID) emp = e;
                }
                String[] from = data[7].split(",");
                String[] to = data[8].split(",");
                Month fromMonth = Month.valueOf(from[0]);
                int fromYear = Integer.parseInt(from[1].trim());
                Month toMonth = Month.valueOf(to[0]);
                int toYear = Integer.parseInt(from[1].trim());

                Industry e = Industry.fromString(data[5]);
                Sector s = Sector.valueOf(data[6]);

                SubstitutePosition sub = new SubstitutePosition(emp, e, s, fromMonth, fromYear, toMonth, toYear);
                sub.setID(ID);
                sub.setPositionTitle(data[3]);
                substitutes.add(sub);
            }

        }

        if (substitutes.isEmpty()) return new ArrayList<SubstitutePosition>();

        return substitutes;
    }

    public int getEmployerID() {
        return this.employer.getID();
    }

    public String getCompanyName() {
        return this.companyName;
    }


    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setContactEMail(String contactEMail) {
        this.contactEMail = contactEMail;
    }

    public int getSubstitutePositionID() {
        return substitutePositionID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Substitute getSubstitute() {
        return substitute;
    }

    public int getID() {
        return this.substitutePositionID;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPosition(Industry position) {
        this.position = position;
    }

    public void setFromMonth(Month fromMonth) {
        this.fromMonth = fromMonth;
    }

    public void setToMonth(Month toMonth) {
        this.toMonth = toMonth;
    }

    public void setFromYear(int fromYear) {
        this.fromYear = fromYear;
    }

    public void setToYear(int toYear) {
        this.toYear = toYear;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public void setQualifications(List<String> qualifications) {
        this.qualifications = qualifications;
    }

    public void setEmploymentConditions(String employmentConditions) {
        this.employmentConditions = employmentConditions;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public void setSalaryConditions(String salaryConditions) {
        this.salaryConditions = salaryConditions;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public void setID(int ID) {
        this.substitutePositionID = ID;
    }

    public String getTo() {
        return this.to;
    }

    public String getFrom() {
        return this.from;
    }

    public Industry getPosition() {
        return position;
    }

    public String getPositionType() {
        return positionType;
    }

    public Sector getSector() {
        return sector;
    }

    public String getPositionTitle() {
        return positionTitle;
    }
}
