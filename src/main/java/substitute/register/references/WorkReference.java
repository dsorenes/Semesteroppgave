package substitute.register.references;

import substitute.register.Substitute;

public class WorkReference {

    private Substitute substitute;
    private int referenceID;
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

    public void assignSubstitute(Substitute sub) {
        this.substitute = sub;
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

    @Override
    public String toString() {
        return referenceID + ";" +
                substitute.getID() + ";" +
                employerName + ";" +
                fullName + ';' +
                phoneNumber + ';' +
                eMail;
    }

    public void setID (int ID) {
        this.referenceID = ID;
    }

    public int getID () {
        return this.referenceID;
    }
}
