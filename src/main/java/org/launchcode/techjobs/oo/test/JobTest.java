package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.CoreCompetency;


import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(1,testJob2.getId(), .001);
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob1.equals(testJob2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String string = testJob.toString();
        int endIndex = string.length() - 1;
        assertEquals('\n', string.charAt(0));
        assertEquals('\n', string.charAt(endIndex));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job tester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: 1" +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence\n", tester.toString());
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job incompleteJob = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job incompleteJob2 = new Job("Product tester", new Employer(), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job incompleteJob3 = new Job("Product tester", new Employer("ACME"), new Location(), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job incompleteJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(), new CoreCompetency("Persistence"));
        Job incompleteJob5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency());

        assertEquals("\nID: 1" +
                "\nName: Data not available" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence\n", incompleteJob.toString());
        assertEquals("\nID: 2" +
                "\nName: Product tester" +
                "\nEmployer: Data not available" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence\n", incompleteJob2.toString());
        assertEquals("\nID: 3" +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Data not available" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence\n", incompleteJob3.toString());
        assertEquals("\nID: 4" +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Persistence\n", incompleteJob4.toString());
        assertEquals("\nID: 5" +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Data not available\n", incompleteJob5.toString());
    }

}
