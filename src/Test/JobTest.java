package Test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job jobbie;
    Job jobbert;
    Job jobathan;

    @Before public void initialize() {
        jobbie = new Job(){};
        jobbert = new Job(){};
        jobathan = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence")){};
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
        assertTrue(jobathan.toString().contains("ID: 15\n"));
        assertTrue(jobathan.toString().contains("Name: Product tester\n"));
        assertTrue(jobathan.toString().contains("Employer: ACME\n"));
        assertTrue(jobathan.toString().contains("Location: Desert\n"));
        assertTrue(jobathan.toString().contains("Position Type: Quality control\n"));
        assertTrue(jobathan.toString().contains("Core Competency: Persistence\n"));
    }
    
    @Test
    public void testToStringEmptyField(){
        jobathan.setEmployer(null);
        assertTrue(jobathan.toString().contains("Employer: Data not available"));
    }

    @Test
    public void testToStringIdOnly(){
        assertEquals(jobbie.toString(), "\nOOPS! This job does not seem to exist.\n");
    }
}