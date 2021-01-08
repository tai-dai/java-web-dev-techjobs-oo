package Test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job jobbie;
    Job jobbert;
    Job jobathan;
    Job jobathan2;
    Job jobathan3;

    @Before public void initialize() {
        jobbie = new Job(){};
        jobbert = new Job(){};
        jobathan = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence")){};
        jobathan2 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence")){};
        jobathan3 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency("")){};
    }

    @Test
    public void emptyTest() {
        assertEquals(10,10,.001);
    }

    @Test
    public void testSettingJobId(){
        int jobbieID = jobbie.getId();
        int jobbertID = jobbert.getId();
        assertNotEquals(jobbieID, jobbertID);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertNotNull(jobathan.getId());
        assertEquals(jobathan.getName(), "Product tester");
        assertEquals(jobathan.getEmployer().getValue(), "ACME");
        assertEquals(jobathan.getLocation().getValue(), "Desert");
        assertEquals(jobathan.getPositionType().getValue(), "Quality control");
        assertEquals(jobathan.getCoreCompetency().getValue(), "Persistence");
        assertTrue(Integer.class.isInstance(jobathan.getId()));
        assertTrue(jobathan.getName() instanceof String);
        assertTrue(jobathan.getEmployer() instanceof Employer);
        assertTrue(jobathan.getLocation() instanceof Location);
        assertTrue(jobathan.getPositionType() instanceof PositionType);
        assertTrue(jobathan.getCoreCompetency() instanceof CoreCompetency);
       }

    @Test
    public void testsJobsForEquality(){
        assertNotEquals(jobbie, jobbert);
    }

    @Test
    public void testToStringBufferLines(){
        assertTrue(jobathan.toString().startsWith("\n"));
        assertTrue(jobathan.toString().endsWith("\n"));
    }

    @Test
        public void testToStringLabelsAndFields(){
        assertEquals(jobathan.toString(),
//                "\nID: 23\n" +
                        "\nID: " + jobathan.getId() + "\n" +
                        "Name: Product tester\n" +
                        "Employer: ACME\n" +
                        "Location: Desert\n" +
                        "Position Type: Quality control\n" +
                        "Core Competency: Persistence\n\n");
    }
    
    @Test
    public void testToStringEmptyField(){
        assertTrue(jobathan2.toString().contains("Employer: Data not available"));
    }

    @Test
    public void testToStringIdOnly(){
        assertEquals(jobathan3.toString(), "\nOOPS! This job does not seem to exist.\n");
    }
}