package employer.register;

import employer.Industry;
import employer.Sector;
import employer.substituteposition.SubstitutePosition;

import java.util.Set;

public class Employer {

    private int employerID;
    private String companyName;
    private String companyAddress;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String eMail;
    private Sector sector;
    private Industry industry;
    Set<SubstitutePosition> availablePositions;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public Employer (String companyName, String companyAddress, String firstName, String lastName,
                     String phoneNumber, String eMail, Industry industry, Sector sector) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.sector = sector;
        this.industry = industry;
    }


    public int getID () {
        return this.employerID;
    }
    public void setID(int id) {
        this.employerID = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEMail() {
        return eMail;
    }
    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public Sector getSector() {
        return sector;
    }
    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Industry getIndustry() {
        return industry;
    }
    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return  employerID + ";" +
                companyName + ";" +
                companyAddress + ";" +
               industry + ";" +
               sector + ";" +
               firstName + ';' +
               lastName + ';' +
               phoneNumber + ';' +
               eMail;
    }
}
