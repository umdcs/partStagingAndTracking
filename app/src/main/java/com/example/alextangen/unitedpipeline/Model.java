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
    int i;
    private int numJobs;
    private RequestManager reqMan;
    int pieceNum = 0;

    public Model() {
        jobs = new Job[MAX_JOBS];
        numJobs = 0;
        reqMan = new RequestManager();
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
        job.setPfHoursTotal(Selection, hours);
    }

    public void lbHours(int jobNum, int Selection, double hours) {
        Job job = jobs[jobNum];
        job.setLbHoursTotal(Selection, hours);
    }

    public double getPfHours(int jobNum, int Selection) {
        Job job = jobs[jobNum];
        return job.getPfHoursTotal(Selection);
    }

    public double getLbHours(int jobNum, int Selection) {
        Job job = jobs[jobNum];
        return job.getLbHoursTotal(Selection);
    }

    public int getNumPieces(int jobNum) {
        Job job = jobs[jobNum];
        return job.getNumPieces();
    }
}
