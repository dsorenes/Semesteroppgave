package model.data.substitute.work;

import model.data.employer.Industry;
import model.data.employer.Sector;
import model.data.substitute.Substitute;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Work {

    private Substitute substitute;
    private int substituteID;
    private int workID;

    private String companyName;
    private String position;
    private Sector sector;
    private Industry industry;
    private LocalDate employedFrom;
    private LocalDate employedTo;


    public Work() {}

    public Work(String companyName, String position, Sector sector, Industry industry, LocalDate employedFrom, LocalDate employedTo) {
        this.companyName = companyName;
        this.position = position;
        this.sector = sector;
        this.industry = industry;


        String from = employedFrom.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.employedFrom = LocalDate.parse(from, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String to = employedTo.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.employedTo = LocalDate.parse(to, DateTimeFormatter.ofPattern("dd.MM.yyyy"));


    }

    public void assignSubstitute (Substitute substitute) {
        this.substitute = substitute;
        this.substituteID = this.substitute.getID();
    }

    public int getSubstituteID() {
        return substituteID;
    }
    public void setSubstituteID(int ID) {
        this.substituteID = ID;
    }

    public int getID () { return this.workID; }
    public void setID (int ID) {
        this.workID = ID;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) { this.position = position; }

    public Sector getSector() {
        return sector;
    }
    public void setSector(Sector sector) { this.sector = sector; }

    public Industry getIndustry() {
        return industry;
    }
    public void setIndustry(Industry industry) { this.industry = industry; }

    public LocalDate getEmployedFrom() {
        return employedFrom;
    }
    public void setEmployedFrom(LocalDate employedFrom) { this.employedFrom = employedFrom; }

    public LocalDate getEmployedTo() {
        return employedTo;
    }
    public void setEmployedTo(LocalDate employedTo) { this.employedTo = employedTo; }

    @Override
    public String toString() {
        return this.workID + ";" + substituteID + ";" + this.companyName + ";" + this.position + ";" + this.sector + ";" + this.industry + ";" + this.employedFrom + ";" + this.employedTo;
    }


}
