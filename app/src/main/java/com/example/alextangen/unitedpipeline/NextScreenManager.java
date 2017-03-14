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

    private Job[] jobs;
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
    int pieceCountInt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);


        Intent intent = getIntent();
        jobs = new Job[1];
        ArrayList list = new ArrayList();
        name = intent.getStringExtra("who");
        System.out.println("Name = " + name);
        //generalJob.setName(name);
        //jobs[0].setName(name);
        pieceCount= intent.getStringExtra("howMany");
        pieceCountInt = Integer.parseInt(pieceCount);
        System.out.println("pieceCount = " + pieceCountInt);
        //jobs = new Job[pieceCountInt];

        jobs[0] = new Job(pieceCountInt);
        //jobs[0] = new Job(1);
        //generalJob = new Job(Integer.parseInt(pieceCount));

        /*
        for(int i = 0; (i < Integer.parseInt(pieceCount)); i++) {
            list.add("Piece #" + i);
        }
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item,list);
        spinnerArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        spins = (Spinner) findViewById(R.id.spins);
        //spins = new Spinner();
        spins.setAdapter(spinnerArrayAdapter);
        */


        //jobs[0] = new Job(1);
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
            public void onClick(View view) {
                jobs[0].setMaterialsReceived();
                jobs[0].getPieces();
                prg.setProgress(10);
                tracker.setText("Materials have been Received");
            }
        });

        startedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jobs[0].setStartedFab();
                jobs[0].getPieces();
                prg.setProgress(20);
                tracker.setText("Fabrication Started");
            }
        });

        finishedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jobs[0].setFinishedFab();
                jobs[0].getPieces();
                prg.setProgress(40);
                tracker.setText("Fabrication Complete");
            }
        });

        xRay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jobs[0].setXRayReady();
                jobs[0].getPieces();
                prg.setProgress(50);
                tracker.setText("X-Ray Ready");
            }
        });

        startCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jobs[0].setStartedCoating();
                jobs[0].getPieces();
                prg.setProgress(60);
                tracker.setText("Started Painting/Coating");
            }
        });

        finishedCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jobs[0].setFinishedCoating();
                jobs[0].getPieces();
                prg.setProgress(80);
                tracker.setText("Painting/Coating Complete");
            }
        });

        readyShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jobs[0].setReadyToShip();
                jobs[0].getPieces();
                prg.setProgress(100);
                tracker.setText("Ready to Ship!");
            }
        });

    }
}