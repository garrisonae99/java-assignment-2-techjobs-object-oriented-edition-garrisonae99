package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.id = id;
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    @Override
    public String toString() {
        String stringReturn = "\nID: " + this.getId() +
                "\nName: " + this.getName() +
                "\nEmployer: " + this.getEmployer().getValue() +
                "\nLocation: " + this.getLocation().getValue() +
                "\nPosition Type: " + this.getPositionType().getValue() +
                "\nCore Competency: " + this.getCoreCompetency().getValue() + "\n";
        if (this.name == "") {
            return "\nID: " + this.getId() +
                    "\nName: Data not available" +
                    "\nEmployer: " + this.getEmployer().getValue() +
                    "\nLocation: " + this.getLocation().getValue() +
                    "\nPosition Type: " + this.getPositionType().getValue() +
                    "\nCore Competency: " + this.getCoreCompetency().getValue() + "\n";
        }else if (this.employer.getValue() == null) {
            return "\nID: " + this.getId() +
                    "\nName: " + this.getName() +
                    "\nEmployer: Data not available" +
                    "\nLocation: " + this.getLocation().getValue() +
                    "\nPosition Type: " + this.getPositionType().getValue() +
                    "\nCore Competency: " + this.getCoreCompetency().getValue() + "\n";
        }else if (this.location.getValue() == null) {
            return "\nID: " + this.getId() +
                    "\nName: " + this.getName() +
                    "\nEmployer: " + this.getEmployer().getValue() +
                    "\nLocation: Data not available" +
                    "\nPosition Type: " + this.getPositionType().getValue() +
                    "\nCore Competency: " + this.getCoreCompetency().getValue() + "\n";
        }else if (this.positionType.getValue() == null) {
            return "\nID: " + this.getId() +
                    "\nName: " + this.getName() +
                    "\nEmployer: " + this.getEmployer().getValue() +
                    "\nLocation: " + this.getLocation().getValue() +
                    "\nPosition Type: Data not available" +
                    "\nCore Competency: " + this.getCoreCompetency().getValue() + "\n";
        }else if (this.coreCompetency.getValue() == null) {
            return "\nID: " + this.getId() +
                    "\nName: " + this.getName() +
                    "\nEmployer: " + this.getEmployer().getValue() +
                    "\nLocation: " + this.getLocation().getValue() +
                    "\nPosition Type: " + this.getPositionType().getValue() +
                    "\nCore Competency: Data not available\n";
        }else {
            return stringReturn;
        }
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
