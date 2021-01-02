package org.launchcode.techjobs_oo;

import java.util.Objects;

public class CoreCompetency extends JobField{

    public CoreCompetency(String value) {
        super(value);
    }

//    // Custom equals and hashCode methods:

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof CoreCompetency)) return false;
        CoreCompetency coreCompetency = (CoreCompetency) o;
        return getId() == coreCompetency.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
