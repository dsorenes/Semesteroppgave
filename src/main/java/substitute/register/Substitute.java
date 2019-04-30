package substitute.register;

import employer.Industry;
import substitute.register.education.Education;
import substitute.register.references.WorkReference;
import substitute.register.work.Work;

import java.time.LocalDate;
import java.util.List;

public class Substitute {

    private int ID;
    private String firstName;
    private String lastName;
    private String eMail;
    private String address;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private List<Work> workExperience;
    private List<Education> education;
    private String salaryDemand;
    private List<Industry> workField;
    private List<WorkReference> references;

    public Substitute(String firstName, String lastName, String eMail, String address, String phoneNumber,
                      LocalDate dateOfBirth, String salaryDemand) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.salaryDemand = salaryDemand;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastNamee() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEMail() { return eMail; }
    public void setEMail(String lastName) { this.eMail = eMail; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String geteMail() { return eMail; }
    public void seteMail(String lastName) { this.eMail = eMail; }


    public void setWorkExperience(List<Work> workExperience, int ID) {
        this.workExperience = workExperience;
        for (Work w : this.workExperience) {
            w.assignSubstitute(this);
            w.setID(ID++);
        }
    }

    public void setEducation(List<Education> education, int ID) {
        this.education = education;
        for (Education e : this.education) {
            e.assignSubstitute(this);
            e.setID(ID++);
        }
    }

    public void setWorkField(List<Industry> workField) {
        this.workField = workField;
    }

    public void setReferences(List<WorkReference> references, int ID) {
        this.references = references;
        for (WorkReference wr : this.references) {
            wr.assignSubstitute(this);
            wr.setID(ID++);
        }
    }

    @Override
    public String toString() {
        return ID + ";" + firstName + ';' +
                lastName + ';' +
               dateOfBirth + ";" +
               address + ';' +
               phoneNumber + ';' +
               eMail + ";" + salaryDemand;
    }

    public List<Work> getWorkExperience() {
        return workExperience;
    }

    public List<Education> getEducation() {
        return education;
    }

    public List<Industry> getWorkField() {
        return workField;
    }

    public List<WorkReference> getReferences() {
        return references;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return this.ID;
    }
}
