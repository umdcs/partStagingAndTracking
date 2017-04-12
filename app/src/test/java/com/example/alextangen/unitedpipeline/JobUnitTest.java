package com.example.alextangen.unitedpipeline;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Katia on 4/12/2017.
 */

public class JobUnitTest {

    @Test
    public void jobCreator() {
        Job testJob = new Job(3); // create a new job with 3 pieces
        assertThat(testJob.getName(), is(""));
        assertThat(testJob.getID(), is(0));
        assertThat(testJob.getNumPieces(), is(3));
    }
}
