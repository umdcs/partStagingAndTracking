package com.example.alextangen.unitedpipeline;

import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Katia on 3/3/2017.
 */

public class Model {

    Job currentJob;
    private int numJobs;
    GlobalPresenter globs;

    public Model() {
        globs = globs.getInstance();
        numJobs = 0;
    }

    public void setCurrentJob(Job job) {
        currentJob = job;
    }

    public Job getCurrentJob() { return currentJob;}


    public void matlRcvd(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        //Job job = jobs[jobNum];
        currentJob.setMaterialsReceived(selection);
        currentJob.getPieces();
    }

    public void startFab(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        //Job job = jobs[jobNum];
        currentJob.setStartedFab(selection);
        currentJob.getPieces();
    }

    public void endFab(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        //Job job = jobs[jobNum];
        currentJob.setFinishedFab(selection);
        currentJob.getPieces();
    }

    public void xRay(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        //Job job = jobs[jobNum];
        currentJob.setXRayReady(selection);
        currentJob.getPieces();
    }

    public void startCoat(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        //Job job = jobs[jobNum];
        currentJob.setStartedCoating(selection);
        currentJob.getPieces();
    }

    public void endCoat(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        //Job job = jobs[jobNum];
        currentJob.setFinishedCoating(selection);
        currentJob.getPieces();
    }

    public void shipRdy(int jobNum, ProgressBar prog, TextView tracker, int selection) {
        //Job job = jobs[jobNum];
        currentJob.setReadyToShip(selection);
        currentJob.getPieces();
    }

    public void pfHours(int jobNum, int Selection, double hours) {
        //Job job = jobs[jobNum];
        currentJob.setPfHours(Selection, hours);
    }

    public void lbHours(int jobNum, int Selection, double hours) {
        //Job job = jobs[jobNum];
        currentJob.setLbHours(Selection, hours);
    }

    public double getPfHours(int jobNum, int Selection) {
        //Job job = jobs[jobNum];
        return currentJob.getPfHours(Selection);
    }

    public double getLbHours(int jobNum, int Selection) {
        //Job job = jobs[jobNum];
        return currentJob.getLbHours(Selection);
    }

    public int getNumPieces(int jobNum) {
        //Job job = jobs[jobNum];
        return currentJob.getNumPieces();
    }
}
