package com.example.alextangen.unitedpipeline;

import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by Katia on 3/3/2017.
 */

public class Presenter implements Serializable {

    private MainActivity view;
    private Model model;

    public Presenter(MainActivity view) {
        this.view = view;
        model = new Model();
    }

    public void matlRcvd(Job job, ProgressBar prog, TextView tracker) {
        job.setMaterialsReceived();
        job.getPieces();
        prog.setProgress(10);
        tracker.setText("Materials have been Received");
    }

    public void startFab(Job job, ProgressBar prog, TextView tracker) {
        job.setStartedFab();
        job.getPieces();
        prog.setProgress(20);
        tracker.setText("Fabrication Started");
    }

    public void endFab(Job job, ProgressBar prog, TextView tracker) {
        job.setFinishedFab();
        job.getPieces();
        prog.setProgress(40);
        tracker.setText("Fabrication Complete");
    }

    public void xRay(Job job, ProgressBar prog, TextView tracker) {
        job.setXRayReady();
        job.getPieces();
        prog.setProgress(50);
        tracker.setText("X-Ray Ready");
    }

    public void startCoat(Job job, ProgressBar prog, TextView tracker) {
        job.setStartedCoating();
        job.getPieces();
        prog.setProgress(60);
        tracker.setText("Started Painting/Coating");
    }

    public void endCoat(Job job, ProgressBar prog, TextView tracker) {
        job.setFinishedCoating();
        job.getPieces();
        prog.setProgress(80);
        tracker.setText("Painting/Coating Complete");
    }

    public void shipRdy(Job job, ProgressBar prog, TextView tracker) {
        job.setReadyToShip();
        job.getPieces();
        prog.setProgress(20);
        tracker.setText("Ready to Ship!");
    }

}
