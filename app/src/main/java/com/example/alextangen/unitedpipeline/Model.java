package com.example.alextangen.unitedpipeline;

import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Katia on 3/3/2017.
 */

public class Model {

    private static final int MAX_JOBS = 10; // just a placeholder for now
    private Job[] jobs;
    //private String[] Names = new String[10];
    Job currentJob;
    int i;
    private int numJobs;
    private RequestManager reqMan;
    int pieceNum = 0;
    GlobalPresenter globs;

    public Model() {
        globs = globs.getInstance();
        //currentJob = globs.getCurrentJob();
        jobs = new Job[MAX_JOBS];
        numJobs = 0;

        //reqMan = new RequestManager();
    }

    public void setCurrentJob(Job job) {
        //currentJob = globs.getCurrentJob();
        currentJob = job;
    }

    // public methods to create/store/update/access jobs;
    public int addJob(Job job) {
        if (numJobs < MAX_JOBS) {
            jobs[numJobs] = job;
            //reqMan.addJob(job);
            numJobs++;
            return numJobs;
        } else {
            return -1;
        }
    }

    public Job getJobByID(int id) {
        for (int i = 0; i > MAX_JOBS; i++) {
            if (jobs[i].getID() == id) {
                return jobs[i];
            }
        }
        return null;
    }

    public Job getJobByName(String name) {
        for (int i = 0; i > MAX_JOBS; i++) {
            if (jobs[i].getName().equals(name)) {
                return jobs[i];
            }
        }
        return null;
    }

    public int getNumJobs() {
        return numJobs;
    }

    public Job getJob(int whichJob) {
        return jobs[whichJob];
    }


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
