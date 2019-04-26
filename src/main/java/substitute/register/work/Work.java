package substitute.register.work;

import employer.Industry;
import employer.Sector;

import java.time.LocalDate;
import java.util.List;

public class Work {

    private String companyName;
    private String position;
    private Sector sector;
    private String industryDescription;
    private LocalDate employedFrom;
    private LocalDate employedTo;

    public Work(String companyName, String position, Sector sector, String industry, LocalDate employedFrom, LocalDate employedTo) {
        this.companyName = companyName;
        this.position = position;
        this.sector = sector;
        this.industryDescription = industry;
        this.employedFrom = employedFrom;
        this.employedTo = employedTo;
    }

    @Override
    public String toString() {
        return this.companyName + ", " + this.position + ", " + this.sector + ", " + this.industryDescription + ", " + this.employedTo;
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

    public String getIndustry() {
        return industryDescription;
    }

    public LocalDate getEmployedFrom() {
        return employedFrom;
    }

    public LocalDate getEmployedTo() {
        return employedTo;
    }
}
