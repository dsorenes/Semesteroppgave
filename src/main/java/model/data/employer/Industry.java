package model.data.employer;

public enum Industry {
    EDUCATION("Children, school and education"),
    AUTOMOTIVE("Car, vehicle and workshop"),
    RETAIL("Store and retail"),
    CONSTRUCTION("Construction"),
    SCIENCE("Research, education and science"),
    HEALTH("Health and care"),
    PRODUCTION("Industry and production"),
    ENGINEER("Engineer"),
    IT("IT"),
    CUSTOMERSERVICE("Customer Service"),
    ITSOFTWARE("IT - Software"),
    CONSULTANT("Consultant and advice"),
    ADMINISTRATION("Administration"),
    OILANDGAS("Oil and gas"),
    TRANSPORTATION("Transportation and logistics"),
    FINANCE("Finance and accounting"),
    OTHER("Other");
    private String description;

    Industry(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }

    public static Industry fromString (String description) {
        for (Industry i : Industry.values()) {
            if (i.description.equalsIgnoreCase(description)) return i;
            }
        return null;
        }

}
