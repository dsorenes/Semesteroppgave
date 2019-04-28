package employer;

public enum Position {
    HEALTHPROFESSIONAL("Health professional"),
    CRAFTSMAN("Craftsman"),
    ENGINEER("Engineer"),
    ITDEVELOPMENT("IT development"),
    CONSULTANT("Consultant"),
    OFFICEANDADMINISTRATION("Office and administration"),
    CUSTOMERSERVICE("Customer Service"),
    MANAGEMENT("Management"),
    PROJECTMANAGEMENT("Project management"),
    CONSULTING("Consulting"),
    SALE("Sale"),
    NURSE("Nurse"),
    TEACHINGANDPEDAGOGY("Teaching and pedagogy"),
    FINANCEANDACCOUNTING("Finance and accounting"),
    OTHER("Other");
    private String description;

    Position(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
