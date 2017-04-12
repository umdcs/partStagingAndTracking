package com.example.alextangen.unitedpipeline;

/**
 * Created by alextangen on 4/12/17.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ProgressAndHoursTest {
    @Test
    public void assertJobProgress() throws Exception {
        Job job = new Job(4);
        assertEquals(4, job.getNumPieces());
        assertEquals(0, job.getPieceProgress(0));
        job.setMaterialsReceived(0);
        assertEquals(10, job.getPieceProgress(0));
        assertEquals("Materials Received", job.getPieceString(0));

        job.setMaterialsReceived(3);
        job.setStartedFab(3);
        job.setFinishedFab(3);
        job.setXRayReady(3);

        assertNotEquals(40, job.getPieceProgress(2));

        assertEquals(50, job.getPieceProgress(3));
        assertEquals("X-Ray Ready", job.getPieceString(3));

        job.setMaterialsReceived(1);
        job.setStartedFab(1);
        job.setFinishedFab(1);
        job.setXRayReady(1);
        job.setStartedCoating(1);
        job.setFinishedCoating(1);
        job.setReadyToShip(1);

        assertNotEquals("Materials Received", job.getPieceProgress(1));
        assertEquals("Ready to Ship!", job.getPieceString(1));
        assertEquals(100, job.getPieceProgress(1));
    }

    @Test
    public void assertJobHours() throws Exception {
        Job job = new Job(2);
        assertEquals(2, job.getNumPieces());
        assertEquals(0.0, job.getPfHoursTotal(), 0);
        job.setPfHours(0, 12);
        job.setLbHours(0, 16);
        job.setPfHours(1, 33);
        job.setLbHours(1, 22);

        assertEquals(33.0, job.getPfHours(1), 0);
        assertEquals(45.0, job.getPfHoursTotal(), 0);

        assertNotEquals(100, job.getLbHours(1));

        assertEquals(38.0, job.getLbHoursTotal(), 0);
    }
}
