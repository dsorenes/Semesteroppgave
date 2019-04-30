package model.data.substitute.register.references;

public class WorkReference {

    private String fullName;
    private String phoneNumber;
    private String eMail;
    private String employerName;

    public WorkReference(String fullName, String phoneNumber, String eMail, String employerName) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.employerName = employerName;
    }

    public String getEmployerName() {
        return employerName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEMail() {
        return eMail;
    }
}
