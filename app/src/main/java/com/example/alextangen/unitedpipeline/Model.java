package com.example.alextangen.unitedpipeline;

/**
 * Created by Katia on 3/3/2017.
 */

public class Model {

    private static final int MAX_JOBS = 10; // just a placeholder for now

    private Job[] jobs;
    private int numJobs;

    public Model() {
        jobs = new Job[MAX_JOBS];
        numJobs = 0;
    }

    // public methods to create/store/update/access jobs;
    public void addJob(Job job) {
        jobs[numJobs] = job;
        numJobs++;
    }
}
