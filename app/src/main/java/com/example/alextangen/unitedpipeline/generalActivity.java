package com.example.alextangen.unitedpipeline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class generalActivity extends AppCompatActivity {

    private Presenter generalPresenter;
    private Job generalJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        Button matlReceived = (Button) findViewById(R.id.matRec);

        //generalPresenter = new Presenter(this); can make presenter work later on
        generalJob = new Job(1);

    }

    public void materialsReceived() {
        generalJob.setMaterialsReceived();
        generalJob.getPieces();
    }

    public void startedFab() {
        generalJob.setStartedFab();
        generalJob.getPieces();
    }

    public void finishedFab() {
        generalJob.setFinishedFab();
        generalJob.getPieces();
    }

    public void xRayReady() {
        generalJob.setXRayReady();
        generalJob.getPieces();
    }

    public void startedCoating() {
        generalJob.setStartedCoating();
        generalJob.getPieces();
    }

    public void finishedCoating() {
        generalJob.setFinishedCoating();
        generalJob.getPieces();
    }

    public void readyToShip() {
        generalJob.setReadyToShip();
        generalJob.getPieces();
    }
}

