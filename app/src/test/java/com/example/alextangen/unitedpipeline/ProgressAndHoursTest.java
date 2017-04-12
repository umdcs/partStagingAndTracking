package com.example.alextangen.unitedpipeline;

/**
 * Created by alextangen on 4/12/17.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ProgressAndHoursTest {
    @Test
    public void assertJobProgress() throws Exception {
        //Create a new job of size 4
        Job job = new Job(4);
        //Make sure job is correct size
        assertEquals(4, job.getNumPieces());
        //Assert that no progress has been made
        assertEquals(0, job.getPieceProgress(0));
        job.setMaterialsReceived(0);
        //increase progress and check both number and string
        assertEquals(10, job.getPieceProgress(0));
        assertEquals("Materials Received", job.getPieceString(0));

        //Edit piece number 3 on the job, get to xRay ready
        job.setMaterialsReceived(3);
        job.setStartedFab(3);
        job.setFinishedFab(3);
        job.setXRayReady(3);

        //Assert that piece 2 has not been edited
        assertNotEquals(40, job.getPieceProgress(2));

        //Assert that piece 3 is where it should be
        assertEquals(50, job.getPieceProgress(3));
        assertEquals("X-Ray Ready", job.getPieceString(3));

        //Increase progress on piece 1 to ready to ship
        job.setMaterialsReceived(1);
        job.setStartedFab(1);
        job.setFinishedFab(1);
        job.setXRayReady(1);
        job.setStartedCoating(1);
        job.setFinishedCoating(1);
        job.setReadyToShip(1);

        //Assert statements to check correctness
        assertNotEquals("Materials Received", job.getPieceProgress(1));
        assertEquals("Ready to Ship!", job.getPieceString(1));
        assertEquals(100, job.getPieceProgress(1));
    }

    @Test
    public void assertJobHours() throws Exception {
        //Create new job of size 2
        Job job = new Job(2);

        //Ensure that job is the correct size, and that no hours have been added
        assertEquals(2, job.getNumPieces());
        assertEquals(0.0, job.getPfHoursTotal(), 0);

        //Add hours to both pieces
        job.setPfHours(0, 12);
        job.setLbHours(0, 16);
        job.setPfHours(1, 33);
        job.setLbHours(1, 22);

        //Assert statements to ensure correctness
        assertEquals(33.0, job.getPfHours(1), 0);
        assertEquals(45.0, job.getPfHoursTotal(), 0);
        assertNotEquals(100, job.getLbHours(1));
        assertEquals(38.0, job.getLbHoursTotal(), 0);
    }
}
