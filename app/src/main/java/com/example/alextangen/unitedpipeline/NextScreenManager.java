package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class NextScreenManager extends AppCompatActivity {

    private Job generalJob;
    int jobNum;
    Presenter presenter;
    ProgressBar prg;
    Spinner spins;
    TextView tracker;
    Button matlReceived;
    Button startedFab;
    Button finishedFab;
    Button xRay;
    Button startCoat;
    Button finishedCoat;
    Button readyShip;
    String name;
    String pieceCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        /*
        Intent intent = getIntent();
        ArrayList list = new ArrayList();
        name = intent.getStringExtra("who");
        generalJob.setName(name);
        pieceCount= intent.getStringExtra("howMany");
        generalJob = new Job(Integer.parseInt(pieceCount));

        /*
        for(int i = 0; (i < Integer.parseInt(pieceCount)); i++) {
            list.add("Piece #" + i);
        }
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,list);
        spinnerArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        spins = (Spinner) findViewById(R.id.spins);
        spins.setAdapter(spinnerArrayAdapter);
        */


        Intent intent = getIntent();
        presenter = (Presenter) intent.getSerializableExtra("Presenter");

        generalJob = new Job(1);
        jobNum = 0;
        presenter.addJob(generalJob);

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

        matlReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.matlRcvd(jobNum, prg, tracker); }
        });

        startedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.startFab(jobNum, prg, tracker); }
        });

        finishedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.endFab(jobNum, prg, tracker); }
        });

        xRay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.xRay(jobNum, prg, tracker); }
        });

        startCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.startCoat(jobNum, prg, tracker); }
        });

        finishedCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.endCoat(jobNum, prg, tracker); }
        });

        readyShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.shipRdy(jobNum, prg, tracker); }
        });

    }
}