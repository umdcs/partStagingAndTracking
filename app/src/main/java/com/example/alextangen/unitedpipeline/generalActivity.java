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
    private int jobNum;
    ProgressBar prg;
    TextView tracker;
    Button matlReceived;
    Button startedFab;
    Button finishedFab;
    Button xRay;
    Button startCoat;
    Button finishedCoat;
    Button readyShip;
    int selection;



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

        //Intent intent = getIntent();
        //presenter = (Presenter) intent.getParcelableExtra("Presenter");
        presenter = new Presenter(this);

        generalJob = new Job(1);
        jobNum = 0;
        presenter.addJob(generalJob);

        matlReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.matlRcvd(jobNum, prg, tracker, selection); }
        });

        startedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.startFab(jobNum, prg, tracker, selection); }
        });

        finishedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.endFab(jobNum, prg, tracker, selection); }
        });

        xRay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.xRay(jobNum, prg, tracker, selection); }
        });

        startCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.startCoat(jobNum, prg, tracker, selection); }
        });

        finishedCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.endCoat(jobNum, prg, tracker, selection); }
        });

        readyShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.shipRdy(jobNum, prg, tracker, selection); }
        });

    }
}

