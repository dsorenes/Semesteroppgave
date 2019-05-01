package substitute.register.education;

import substitute.register.Substitute;

import java.time.Month;

public class Education {

    private Substitute substitute;
    private int educationID;
    private String schoolName;
    private Subject subject;
    private EducationLevel educationLevel;
    private String degree;
    private Month fromMonth;
    private Integer fromYear;
    private Month toMonth;
    private Integer toYear;
    private Boolean isCurrentlyStudying;
    private String from;
    private String to;

    public Education() {}

    public Education (String schoolName, Subject subject, EducationLevel educationLevel, String degree,
                      Month fromMonth, Integer fromYear, Month toMonth, Integer toYear, Boolean isCurrentlyStudying) {
        this.schoolName = schoolName;
        this.subject = subject;
        this.educationLevel = educationLevel;
        this.degree = degree;
        this.fromMonth = fromMonth;
        this.fromYear = fromYear;
        this.toMonth = toMonth;
        this.toYear = toYear;
        this.isCurrentlyStudying = isCurrentlyStudying;

        this.from = fromMonth + ", " + fromYear;
        this.to = toMonth + ", " + toYear;

        if (isCurrentlyStudying) {
            this.to = "";
        }
    }

    public void assignSubstitute (Substitute sub) {
        this.substitute = sub;
    }

    public int getID () {
        return this.educationID;
    }
    public void setID(int educationID) { this.educationID = educationID;  }

    public String getSchoolName() {
        return schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }
    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getDegree() {
        return degree;
    }
    public void setDegree(String educationID) {
        this.degree = degree;
    }

    public Month getFromMonth() {
        return fromMonth;
    }
    public void setFromMonth(Month month) {
        this.fromMonth = fromMonth;
    }

    public Integer getFromYear() {
        return fromYear;
    }
    public void setFromYear(Integer fromYear) {
        this.fromYear = fromYear;
    }

    public Month getToMonth() { return toMonth; }
    public void setID(Month toMonth) {
        this.toMonth = toMonth;
    }

    public Integer getToYear() {
        return toYear;
    }
    public void setToYear(Integer toYear) {
        this.toYear = toYear;
    }

    public Boolean getIsCurrentlyStudying() {
        return isCurrentlyStudying;
    }
    public void setIsCurrentlyStudying(boolean isCurrentlyStudying) {
        this.isCurrentlyStudying = isCurrentlyStudying;
    }

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.toMonth = toMonth;
    }


    @Override
    public String toString() {
        return this.educationID + ";" +
                substitute.getID() + ";" +
               schoolName + ";" +
                educationLevel + ";" +
                degree + ';' +
               from + ";" +
               to + ";" +
               isCurrentlyStudying;

    }
}
