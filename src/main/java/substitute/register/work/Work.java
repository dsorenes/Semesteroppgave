package substitute.register.work;

import employer.Industry;
import employer.Sector;
import substitute.register.Substitute;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.IntStream;

public class Work {

    private int workID;
    private String companyName;
    private String position;
    private Sector sector;
    private Industry industry;
    private LocalDate employedFrom;
    private LocalDate employedTo;
    private Substitute substitute;
    private int substituteID;

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

    @Override
    public String toString() {
        return this.workID + ";" + substituteID + ";" + this.companyName + ";" + this.position + ";" + this.sector + ";" + this.industry + ";" + this.employedFrom + ";" + this.employedTo;
    }

    public void setSubstituteID(int ID) {
        this.substituteID = ID;
    }

    public void setID (int ID) {
        this.workID = ID;
    }

    public int getID () {
        return this.workID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPosition() {
        return position;
    }

    public Sector getSector() {
        return sector;
    }

    public Industry getIndustry() {
        return industry;
    }

    public LocalDate getEmployedFrom() {
        return employedFrom;
    }

    public LocalDate getEmployedTo() {
        return employedTo;
    }
}
