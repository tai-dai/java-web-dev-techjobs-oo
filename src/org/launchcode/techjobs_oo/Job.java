package org.launchcode.techjobs_oo;

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
    // DONE!!!

    public Job(){
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    // DONE!!!

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

    @Override
    public String toString(){
        Object[] props = {this.name, this.employer, this.location, this.positionType, this.coreCompetency};
        String[] results = new String[5];

        int i = -1;
        int sumNulls = 0;

        for (Object object : props){
            i++;
            if (object == null){
                results[i] = "Data not available";
                sumNulls ++;
            } else {
                results[i] = object.toString();
            }
        }

        if (sumNulls == 5){
            return "\nOOPS! This job does not seem to exist.\n";

        } else {
            return "\n" +
                    "ID: " + this.id + "\n" +
                    "Name: " + results[0] + "\n" +
                    "Employer: " + results[1] + "\n" +
                    "Location: " + results[2] + "\n" +
                    "Position Type: " + results[3] +"\n" +
                    "Core Competency: " + results[4] + "\n" +
                    "\n";
        }
    }

//    Getters and setters:

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Employer getEmployer() { return employer; }
    public void setEmployer(Employer employer) { this.employer = employer; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public PositionType getPositionType() { return positionType; }
    public void setPositionType(PositionType positionType) { this.positionType = positionType; }

    public CoreCompetency getCoreCompetency() { return coreCompetency; }
    public void setCoreCompetency(CoreCompetency coreCompetency) { this.coreCompetency = coreCompetency; }

    public int getId() { return id; }
}
