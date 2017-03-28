package com.example.alextangen.unitedpipeline;

import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Katia on 3/3/2017.
 */

public class Model {

    private static final int MAX_JOBS = 10; // just a placeholder for now
    private Job[] jobs;
    private int numJobs;
    int pieceNum = 0;

    public Model() {
        jobs = new Job[MAX_JOBS];
        numJobs = 0;
    }

    // public methods to create/store/update/access jobs;
    public void addJob(Job job) {
        if (numJobs < MAX_JOBS) {
            jobs[numJobs] = job;
            numJobs++;
        }
    }

    public void matlRcvd(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setMaterialsReceived(selection);
        job.getPieces();
    }

    public void startFab(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setStartedFab(selection);
        job.getPieces();
    }

    public void endFab(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setFinishedFab(selection);
        job.getPieces();
    }

    public void xRay(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setXRayReady(selection);
        job.getPieces();
    }

    public void startCoat(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setStartedCoating(selection);
        job.getPieces();
    }

    public void endCoat(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setFinishedCoating(selection);
        job.getPieces();
    }

    public void shipRdy(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setReadyToShip(selection);
        job.getPieces();
    }

    public void pfHours(int jobNum, int Selection, double hours) {
        Job job = jobs[jobNum];

    }

    public void lbHours(int jobNum, int Selection, double hours) {
        Job job = jobs[jobNum];

    }
}
