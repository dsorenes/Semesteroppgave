package substitute.register.work;

import employer.Industry;
import employer.Sector;

import java.time.LocalDate;
import java.util.List;

public class Work {

    private String companyName;
    private String position;
    private Sector sector;
    private Industry industry;
    private LocalDate employedFrom;
    private LocalDate employedTo;

    public Work(String companyName, String position, Sector sector, Industry industry, LocalDate employedFrom, LocalDate employedTo) {
        this.companyName = companyName;
        this.position = position;
        this.sector = sector;
        this.industry = industry;
        this.employedFrom = employedFrom;
        this.employedTo = employedTo;
    }

    @Override
    public String toString() {
        return this.companyName + ", " + this.position + ", " + this.sector + ", " + this.industry + ", " + this.employedTo;
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
