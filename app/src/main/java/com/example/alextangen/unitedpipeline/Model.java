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
        jobs[numJobs] = job;
        numJobs++;
    }

    public void matlRcvd(int jobNum, ProgressBar prog, TextView tracker) {
        Job job = jobs[jobNum];
        job.setMaterialsReceived(pieceNum);
        job.getPieces();
        prog.setProgress(10);
        tracker.setText("Materials have been Received");
    }

    public void startFab(int jobNum, ProgressBar prog, TextView tracker) {
        Job job = jobs[jobNum];
        job.setStartedFab(pieceNum);
        job.getPieces();
        prog.setProgress(20);
        tracker.setText("Fabrication Started");
    }

    public void endFab(int jobNum, ProgressBar prog, TextView tracker) {
        Job job = jobs[jobNum];
        job.setFinishedFab(pieceNum);
        job.getPieces();
        prog.setProgress(40);
        tracker.setText("Fabrication Complete");
    }

    public void xRay(int jobNum, ProgressBar prog, TextView tracker) {
        Job job = jobs[jobNum];
        job.setXRayReady(pieceNum);
        job.getPieces();
        prog.setProgress(50);
        tracker.setText("X-Ray Ready");
    }

    public void startCoat(int jobNum, ProgressBar prog, TextView tracker) {
        Job job = jobs[jobNum];
        job.setStartedCoating(pieceNum);
        job.getPieces();
        prog.setProgress(60);
        tracker.setText("Started Painting/Coating");
    }

    public void endCoat(int jobNum, ProgressBar prog, TextView tracker) {
        Job job = jobs[jobNum];
        job.setFinishedCoating(pieceNum);
        job.getPieces();
        prog.setProgress(80);
        tracker.setText("Painting/Coating Complete");
    }

    public void shipRdy(int jobNum, ProgressBar prog, TextView tracker) {
        Job job = jobs[jobNum];
        job.setReadyToShip(pieceNum);
        job.getPieces();
        prog.setProgress(20);
        tracker.setText("Ready to Ship!");
    }
}
