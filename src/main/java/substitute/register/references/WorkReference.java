package substitute.register.references;

import substitute.register.Substitute;

public class WorkReference {

    private Substitute substitute;
    private int referenceID;
    private String fullName;
    private String phoneNumber;
    private String eMail;
    private String employerName;

    public WorkReference() {}

    public WorkReference(String fullName, String phoneNumber, String eMail, String employerName) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.employerName = employerName;
    }

    public void assignSubstitute(Substitute sub) {
        this.substitute = sub;
    }

    public int getID () {
        return this.referenceID;
    }
    public void setID (int ID) {
        this.referenceID = ID;
    }

    public String getEmployerName() {
        return employerName;
    }
    public void setEmployerName(String employerName) { this.employerName = employerName; }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEMail() {
        return eMail;
    }
    public void seteEMail(String eEMail) { this.eMail = eEMail; }

    @Override
    public String toString() {
        return referenceID + ";" +
                substitute.getID() + ";" +
                employerName + ";" +
                fullName + ';' +
                phoneNumber + ';' +
                eMail;
    }

}
