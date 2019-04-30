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

    public void setWorkExperience(List<Work> workExperience) {
        this.workExperience = workExperience;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public void setWorkField(List<Industry> workField) {
        this.workField = workField;
    }

    public void setReferences(List<WorkReference> references) {
        this.references = references;
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
