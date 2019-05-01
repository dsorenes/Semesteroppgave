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

    public Work() {}

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

    public int getID () { return this.workID; }
    public void setID (int ID) {
        this.workID = ID;
    }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) { this.position = position; }

    public Sector getSector() {
        return sector;
    }
    public void setSector(Sector sector) {this.sector = sector; }

    public Industry getIndustry() {
        return industry;
    }
    public void setIndustry(Industry industry) {this.industry = industry; }

    public LocalDate getEmployedFrom() {
        return employedFrom;
    }
    public void setCompanyName(LocalDate employedFrom) {this.employedFrom = employedFrom; }

    public LocalDate getEmployedTo() {
        return employedTo;
    }
    public void setEmployedTo(LocalDate employedTo) {this.employedTo = employedTo; }

    @Override
    public String toString() {
        return this.workID + ";" + this.substitute.getID() + ";" + this.companyName + ";" + this.position + ";" + this.sector + ";" + this.industry + ";" + this.employedFrom + ";" + this.employedTo;
    }

}
