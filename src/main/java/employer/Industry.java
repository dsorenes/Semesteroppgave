package employer;

import javafx.collections.ObservableArray;

public enum Industry {
    EDUCATION("Children, school and education"),
    AUTOMOTIVE("Car, vehicle and workshop"),
    RETAIL("Store and retail"),
    CONSTRUCTION("Construction"),
    SCIENCE("Research, education and science"),
    HEALTH("Health and care"),
    PRODUCTION("Industry and production"),
    IT("IT"),
    SOFTWARE("IT - Software"),
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

    public String getDescription() {
        return description;
    }

}
