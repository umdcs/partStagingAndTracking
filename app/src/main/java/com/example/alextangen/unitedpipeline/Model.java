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
    private RequestManager reqMan;
    int pieceNum = 0;

    public Model() {
        jobs = new Job[MAX_JOBS];
        numJobs = 0;
        reqMan = new RequestManager();
    }

    // public methods to create/store/update/access jobs;
    public void addJob(Job job) {
        if (numJobs < MAX_JOBS) {
            jobs[numJobs] = job;
            reqMan.addJob(job);
            numJobs++;
        }
    }

    public void matlRcvd(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setMaterialsReceived(selection);
        job.getPieces();
        //prog.setProgress(job.getPieceProgress(selection));
        //tracker.setText("Materials have been Received");
    }

    public void startFab(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setStartedFab(selection);
        job.getPieces();
        //prog.setProgress(job.getPieceProgress(selection));
        //tracker.setText("Fabrication Started");
    }

    public void endFab(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setFinishedFab(selection);
        job.getPieces();
        //prog.setProgress(job.getPieceProgress(selection));
        //tracker.setText("Fabrication Complete");
    }

    public void xRay(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setXRayReady(selection);
        job.getPieces();
        //prog.setProgress(job.getPieceProgress(selection));
        //tracker.setText("X-Ray Ready");
    }

    public void startCoat(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setStartedCoating(selection);
        job.getPieces();
        //prog.setProgress(job.getPieceProgress(selection));
        //tracker.setText("Started Painting/Coating");
    }

    public void endCoat(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setFinishedCoating(selection);
        job.getPieces();
        //prog.setProgress(job.getPieceProgress(selection));
        //tracker.setText("Painting/Coating Complete");
    }

    public void shipRdy(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        Job job = jobs[jobNum];
        job.setReadyToShip(selection);
        job.getPieces();
        //prog.setProgress(job.getPieceProgress(selection));
        //tracker.setText("Ready to Ship!");
    }
}
