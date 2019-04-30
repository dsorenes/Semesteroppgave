package substitute.register.work;

import employer.Industry;
import employer.Sector;
import substitute.register.Substitute;

import java.time.LocalDate;
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

    public Work(String companyName, String position, Sector sector, Industry industry, LocalDate employedFrom, LocalDate employedTo) {
        this.companyName = companyName;
        this.position = position;
        this.sector = sector;
        this.industry = industry;
        this.employedFrom = employedFrom;
        this.employedTo = employedTo;
    }

    public void assignSubstitute (Substitute substitute) {
        this.substitute = substitute;
    }

    @Override
    public String toString() {
        return 0 + ";" + this.substitute.getID() + ";" + this.companyName + ";" + this.position + ";" + this.sector + ";" + this.industry + ";" + this.employedFrom + ";" + this.employedTo;
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
