package model.data.employer.substituteposition;

import model.data.employer.Position;
import model.data.substitute.register.Substitute;

import java.time.LocalDate;
import java.util.List;

public class SubstitutePosition {

    private boolean isAvailable;
    private String location;
    private Position position;
    private LocalDate positionDuration;
    private String positionType;
    private String qualifications;
    private String employmentConditions;
    private model.data.employer.Employer employer;
    private String description;
    private List<Substitute> applicants;

}
