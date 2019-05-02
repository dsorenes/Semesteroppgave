package model.data.substitute.education;

import model.data.substitute.Substitute;

import java.time.Month;

public class Education {

    private int substituteID;
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

    private Substitute substitute;


    public void assignSubstitute (Substitute sub) {
        this.substitute = sub;
        this.substituteID = substitute.getID();
    }

    public int getSubstituteID() { return substituteID; }
    public void setSubstituteID(int substituteID) { this.substituteID = substituteID; }

    public void setID(int educationID) { this.educationID = educationID; }
    public int getID () { return this.educationID; }

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }

    public EducationLevel getEducationLevel() { return educationLevel; }
    public void setEducationLevel(EducationLevel educationLevel) { this.educationLevel = educationLevel; }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    public Month getFromMonth() { return fromMonth; }
    public void setFromMonth(Month fromMonth) { this.fromMonth = fromMonth; }

    public Integer getFromYear() { return fromYear; }
    public void setFromYear(Integer fromYear) { this.fromYear = fromYear; }

    public Month getToMonth() { return toMonth; }
    public void setToMonth(Month toMonth) { this.toMonth = toMonth; }

    public Integer getToYear() { return toYear; }
    public void setToYear(Integer toYear) { this.toYear = toYear; }

    public Boolean getIsCurrentlyStudying() { return isCurrentlyStudying; }
    public void setIsCurrentlyStudying(Boolean isCurrentlyStudying) { this.isCurrentlyStudying = isCurrentlyStudying; }


    @Override
    public String toString() {
        return this.educationID + ";" +
                substituteID + ";" +
               schoolName + ";" +
                educationLevel + ";" +
                subject + ";" +
                degree + ';' +
               from + ";" +
               to + ";" +
               isCurrentlyStudying;

    }

}
