package employer.substituteposition;

import employer.Employer;
import employer.Position;
import substitute.register.Substitute;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class SubstitutePosition {

    private boolean isAvailable;
    private String location;
    private Position position;
    private LocalDate positionDuration;
    private String positionType;
    private String qualifications;
    private String employmentConditions;
    private employer.Employer employer;
    private String description;
    private List<Substitute> applicants;

}
