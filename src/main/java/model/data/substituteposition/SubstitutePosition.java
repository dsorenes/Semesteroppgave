package model.data.substituteposition;

import model.data.employer.Industry;
import model.data.employer.Sector;
import model.data.employer.Employer;
import model.data.substitute.Substitute;

import java.time.Month;
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
    private String qualificationsNeeded;

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

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
        this.employer.setCompanyName(companyName);
    }

    @Override
    public String toString() {
        return  substitutePositionID + ";" +
                this.getEmployerID() + ";" +
                this.employer.getCompanyName()+ ";" +
                positionTitle + ";" +
                location + ";" +
                description + ";" +
                position + ";" +
                sector + ";" +
                from + ';' +
                to + ";" +
                contactName + ";" +
                contactPhone + ";" +
                contactEMail + ";" +
                qualificationsNeeded + ";" +
                workHours + ";" +
                salaryConditions + ";" +
                employmentConditions;

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

    public void setTo(String to) {
        this.to = to;
        String[] split = to.split(", ");
        this.setToMonth(Month.valueOf(split[0].trim().toUpperCase()));
        this.setToYear(Integer.parseInt(split[1]));
    }

    public void setFrom(String from) {
        this.from = from;
        String[] split = from.split(", ");
        this.setFromMonth(Month.valueOf(split[0].trim().toUpperCase()));
        this.setFromYear(Integer.parseInt(split[1]));
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
        StringBuilder qual = new StringBuilder();
        for (String q : qualifications) {
            qual.append(q);
        }
        this.qualificationsNeeded = qual.toString();
    }

    public void setQualificationsNeeded(String qual) {
        this.qualificationsNeeded = qual;
    }

    public void setEmploymentConditions(String employmentConditions) {
        this.employmentConditions = employmentConditions;
    }

    public void setDescription(String description) {
        this.description = description;
        String[] a =description.split("[\n\r]+");
        StringBuilder desc = new StringBuilder();
        for (String i : a) {
            if (!i.isBlank() || !i.isEmpty()) desc.append(i).append(":");
        }
        int index = desc.lastIndexOf(":");
        desc.deleteCharAt(index);
        this.description = desc.toString();
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public String getDescription() {
        return description;
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

    public String getQualificationsNeeded() {
        return qualificationsNeeded;
    }
}
