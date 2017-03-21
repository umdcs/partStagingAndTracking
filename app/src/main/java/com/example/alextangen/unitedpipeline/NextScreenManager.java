package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class NextScreenManager extends AppCompatActivity {

    private Job[] jobsArray = new Job[10];
    Job currentJob;
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
    int pieceCountInt;
    int jobNumber;
    int whichJob = 0;
    int jobNum;
    int selection = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_screen_manager);

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
        ArrayList list = new ArrayList();

        name = intent.getStringExtra("who");
        System.out.println("Name = " + name);
        pieceCount = intent.getStringExtra("howMany");
        pieceCountInt = Integer.parseInt(pieceCount);
        System.out.println("pieceCount = " + pieceCountInt);

        System.out.println("Current Job");
        currentJob = new Job(pieceCountInt);
        jobNumber = currentJob.getJob(name);

        if (jobNumber >= 0) {
            currentJob = jobsArray[jobNumber];
        } else {
            System.out.println("Else loop current job");
            jobsArray[whichJob] = new Job(pieceCountInt);
            jobsArray[whichJob].setName(name);
            currentJob = jobsArray[whichJob];
            whichJob++;
        }





        for (int i = 0; (i < Integer.parseInt(pieceCount)); i++) {
            list.add("Piece # " + i);
        }
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spins = (Spinner) findViewById(R.id.spins);
        spins.setAdapter(spinnerArrayAdapter);

        presenter = new Presenter(this);

        jobNum = 0;
        presenter.addJob(currentJob);

        prg.setProgress(currentJob.getPieceProgress(selection));

        spins.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int what, long longer) {
                selection = spins.getSelectedItemPosition();
                prg.setProgress(0);
                tracker.setText(currentJob.getPieceString(selection));
                prg.setProgress(currentJob.getPieceProgress(selection));
            }
            public void onNothingSelected(AdapterView<?> parent) {
                prg.setProgress(0);
                tracker.setText("");
            }
        });

        matlReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.matlRcvd(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
            }
        });

        startedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.startFab(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
            }
        });

        finishedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.endFab(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
            }
        });

        xRay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.xRay(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
            }
        });

        startCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.startCoat(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
            }
        });

        finishedCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.endCoat(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
            }
        });

        readyShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.shipRdy(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
            }
        });
}

}