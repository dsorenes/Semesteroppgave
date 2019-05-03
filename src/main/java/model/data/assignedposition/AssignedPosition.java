package model.data.assignedposition;

import model.data.substitute.Substitute;
import model.data.substituteposition.SubstitutePosition;

public class AssignedPosition {

    private Substitute substitute;
    private int substituteID;
    public SubstitutePosition substitutePosition;
    private int substitutePositionID;

    private int assignedID;


    public AssignedPosition() {}

    public AssignedPosition(int assignedID) {
        this.assignedID = assignedID;
    }

    public void assignSubstitute(Substitute sub) {
        this.substitute = sub;
        this.substituteID = substitute.getID();
    }

    public void substitutePosition(SubstitutePosition subPos) {
        this.substitutePosition = subPos;
        this.substitutePositionID = substitutePosition.getID();
    }

    public int getSubstituteID() { return substituteID; }
    public void setSubstituteID(int substituteID) { this.substituteID = substituteID; }

    public int getSubstitutePositionID() { return substitutePositionID; }
    public void setSubstitutePositionID(int substitutePositionID) { this.substitutePositionID = substitutePositionID; }

    public int getAssignedID() { return assignedID; }
    public void setAssignedID(int assignedID) { this.assignedID = assignedID; } ;


    @Override
    public String toString() {
        return this.assignedID + ";" +
                substituteID + ";" +
                substitutePositionID;
    }


}
