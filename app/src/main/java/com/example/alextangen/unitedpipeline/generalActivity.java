package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class generalActivity extends AppCompatActivity {

    private Presenter presenter;
    private Job generalJob;
    ProgressBar prg;
    TextView tracker;
    Button matlReceived;
    Button startedFab;
    Button finishedFab;
    Button xRay;
    Button startCoat;
    Button finishedCoat;
    Button readyShip;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        prg = (ProgressBar) findViewById(R.id.progressBar);
        prg.setScaleY(3);

        tracker = (TextView) findViewById(R.id.tracker);

        matlReceived = (Button) findViewById(R.id.matRec);
        startedFab = (Button) findViewById(R.id.sFab);
        finishedFab = (Button) findViewById(R.id.eFab);
        xRay = (Button) findViewById(R.id.xray);
        startCoat = (Button) findViewById(R.id.scoat);
        finishedCoat = (Button) findViewById(R.id.ecoat);
        readyShip = (Button) findViewById(R.id.ship);

        Intent intent = getIntent();
        presenter = (Presenter) intent.getSerializableExtra("Presenter");

        generalJob = new Job(1);

        matlReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generalJob.setMaterialsReceived();
                generalJob.getPieces();
                prg.setProgress(10);
                tracker.setText("Materials have been Received");
            }
        });

        startedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generalJob.setStartedFab();
                generalJob.getPieces();
                prg.setProgress(20);
                tracker.setText("Fabrication Started");
            }
        });

        finishedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generalJob.setFinishedFab();
                generalJob.getPieces();
                prg.setProgress(40);
                tracker.setText("Fabrication Complete");
            }
        });

        xRay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generalJob.setXRayReady();
                generalJob.getPieces();
                prg.setProgress(50);
                tracker.setText("X-Ray Ready");
            }
        });

        startCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generalJob.setStartedCoating();
                generalJob.getPieces();
                prg.setProgress(60);
                tracker.setText("Started Painting/Coating");
            }
        });

        finishedCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generalJob.setFinishedCoating();
                generalJob.getPieces();
                prg.setProgress(80);
                tracker.setText("Painting/Coating Complete");
            }
        });

        readyShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generalJob.setReadyToShip();
                generalJob.getPieces();
                prg.setProgress(100);
                tracker.setText("Ready to Ship!");
            }
        });

    }
}

