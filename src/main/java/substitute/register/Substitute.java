package substitute.register;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Substitute {

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty eMail;
    private SimpleStringProperty address;
    private SimpleStringProperty phoneNumber;
    private LocalDate dateOfBirth;

    public Substitute(String firstName, String lastName, String eMail, String address, String phoneNumber, LocalDate dateOfBirth) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.eMail = new SimpleStringProperty(eMail);
        this.address = new SimpleStringProperty(address);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return this.firstName.getValue() + ";" + this.lastName.getValue() + ";" + this.eMail.getValue() + ";" + this.address.getValue() + ";" + this.phoneNumber.getValue() + ";" + this.dateOfBirth.toString();
    }
}
