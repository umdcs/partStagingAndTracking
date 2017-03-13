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
            public void onClick(View view) { presenter.matlRcvd(generalJob, prg, tracker); }
        });

        startedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.startFab(generalJob, prg, tracker); }
        });

        finishedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.endFab(generalJob, prg, tracker); }
        });

        xRay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.xRay(generalJob, prg, tracker); }
        });

        startCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.startCoat(generalJob, prg, tracker); }
        });

        finishedCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.endCoat(generalJob, prg, tracker); }
        });

        readyShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.shipRdy(generalJob, prg, tracker); }
        });

    }
}

