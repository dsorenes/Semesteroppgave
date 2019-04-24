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
    private List<LocalDate> employmentDuration;

    public Work(String companyName, String position, Sector sector, Industry industry, List<LocalDate> duration) {
        this.companyName = companyName;
        this.position = position;
        this.sector = sector;
        this.industry = industry;
        this.employmentDuration = duration;
    }
}
