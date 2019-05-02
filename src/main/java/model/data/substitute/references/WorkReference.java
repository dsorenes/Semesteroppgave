package model.data.substitute.references;

import model.data.substitute.Substitute;

import java.util.ArrayList;

public class WorkReference {

    private Substitute substitute;
    private int referenceID;
    private String fullName;
    private String phoneNumber;
    private String eMail;
    private String employerName;
    private int substituteID;

    public WorkReference(String fullName, String phoneNumber, String eMail, String employerName) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.employerName = employerName;
    }

    public static ArrayList<WorkReference> WorkReferenceFromCSV(ArrayList<String> attributes) {
        ArrayList<WorkReference> references = new ArrayList<>();
        for (String s : attributes) {
            String[] data = s.split(";");
            if (data.length > 0) {
                references.add(new WorkReference(data[0], data[1], data[2], data[3]));
            }

        }
        return references;
    }

    public void assignSubstitute(Substitute sub) {
        this.substitute = sub;
        this.substituteID = substitute.getID();
    }

    public int getSubstituteID() {
        return substituteID;
    }

    public void setSubstituteID(int id) {
        this.substituteID = id;
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
                substituteID + ";" +
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
