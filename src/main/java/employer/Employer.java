package employer;

import java.util.Set;

public class Employer {
    private Sector sector;
    private Industry industry;
    private String address;
    Set<String> availablePositions;

    public Employer (Sector sector, Industry industry) {
        this.sector = sector;
        this.industry = industry;
    }

    public Industry getIndustry() {
        return this.industry;
    }

    public Sector getSector() {
        return this.sector;
    }

}
