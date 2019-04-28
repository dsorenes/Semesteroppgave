package substitute.register;

import employer.Industry;
import substitute.register.education.Education;
import substitute.register.references.WorkReference;
import substitute.register.work.Work;

import java.time.LocalDate;
import java.util.List;

public class Substitute {

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
                      LocalDate dateOfBirth, List<Work> workExperience, List<Education> education, String salaryDemand,
                      List<Industry> workField, List<WorkReference> references) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.workExperience =workExperience;
        this.education = education;
        this.salaryDemand = salaryDemand;
        this.workField = workField;
        this.references = references;
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName + ", " + eMail + ", " + workExperience.size() + ", " + education.size();
    }

}
