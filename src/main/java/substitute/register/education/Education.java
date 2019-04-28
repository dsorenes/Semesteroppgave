package substitute.register.education;

import java.time.Month;

public class Education {

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

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public Subject getSubject() {
        return subject;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public String getDegree() {
        return degree;
    }

    public Month getFromMonth() {
        return fromMonth;
    }

    public Integer getFromYear() {
        return fromYear;
    }

    public Month getToMonth() {
        return toMonth;
    }

    public Integer getToYear() {
        return toYear;
    }

    public Boolean getIsCurrentlyStudying() {
        return isCurrentlyStudying;
    }


}
