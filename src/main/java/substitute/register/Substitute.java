package substitute.register;

import employer.Industry;
import substitute.register.education.Education;
import substitute.register.references.WorkReference;
import substitute.register.work.Work;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Substitute implements Serializable {

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
    private boolean isEmployed;
    private List<WorkReference> references;

    public Substitute() {}

    public Substitute(String firstName, String lastName, LocalDate dateOfBirth, String address, String phoneNumber, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public int getID() { return this.ID; }
    public void setID(int ID) { this.ID = ID; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEMail() { return eMail; }
    public void setEMail(String eMail) { this.eMail = eMail; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String geteSaleryDemand() { return salaryDemand; }
    public void setSalaryDemand(String salaryDemand) { this.salaryDemand = salaryDemand; }

    public boolean getIsEmployed() { return isEmployed; }
    public void settIsEmployed(boolean isEmployed) { this.isEmployed = isEmployed; }

    public List<Work> getWorkExperience() { return workExperience; }
    public void setWorkExperience(List<Work> workExperience, int ID) {
        this.workExperience = workExperience;
        for (Work w : this.workExperience) {
            w.assignSubstitute(this);
            w.setID(ID++);
        }
    }

    public List<Education> getEducation() { return education; }
    public void setEducation(List<Education> education, int ID) {
        this.education = education;
        for (Education e : this.education) {
            e.assignSubstitute(this);
            e.setID(ID++);
        }
    }

    public List<Industry> getWorkField() { return workField; }
    public void setWorkField(List<Industry> workField) {
        this.workField = workField;
    }

    public List<WorkReference> getReferences() { return references; }
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
               eMail;
    }

}
