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

public class JobProgress extends AppCompatActivity {

    Job currentJob;
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
    String whichJob;
    int whichJobNumber;
    int jobNum;
    int selection = 0;
    GlobalPresenter globs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_progress);

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

        matlReceived.setVisibility(View.VISIBLE);
        startedFab.setVisibility(View.GONE);
        finishedFab.setVisibility(View.GONE);
        xRay.setVisibility(View.GONE);
        startCoat.setVisibility(View.GONE);
        finishedCoat.setVisibility(View.GONE);
        readyShip.setVisibility(View.GONE);

        globs = GlobalPresenter.getInstance();
        //currentJob = globs.getJob(0);


        Intent intent = getIntent();
        ArrayList list = new ArrayList();

        whichJob = intent.getStringExtra("whichJob");

        whichJobNumber = Integer.parseInt(whichJob);

        for (int i = 0; i < globs.getJob(whichJobNumber).getNumPieces(); i++) {
            list.add("Piece # " + i);
        }
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spins = (Spinner) findViewById(R.id.spins);
        spins.setAdapter(spinnerArrayAdapter);

        jobNum = whichJobNumber;
        currentJob = globs.getJob(jobNum);

        spins.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int what, long longer) {
                selection = spins.getSelectedItemPosition();
                prg.setProgress(0);
                tracker.setText(currentJob.getPieceString(selection));
                prg.setProgress(currentJob.getPieceProgress(selection));
                switch (currentJob.getPieceProgress(selection)) {
                    case 0:
                        matlReceived.setVisibility(View.VISIBLE);
                        startedFab.setVisibility(View.GONE);
                        finishedFab.setVisibility(View.GONE);
                        xRay.setVisibility(View.GONE);
                        startCoat.setVisibility(View.GONE);
                        finishedCoat.setVisibility(View.GONE);
                        readyShip.setVisibility(View.GONE);
                        break;
                    case 10:
                        matlReceived.setVisibility(View.VISIBLE);
                        startedFab.setVisibility(View.VISIBLE);
                        finishedFab.setVisibility(View.GONE);
                        xRay.setVisibility(View.GONE);
                        startCoat.setVisibility(View.GONE);
                        finishedCoat.setVisibility(View.GONE);
                        readyShip.setVisibility(View.GONE);
                        break;
                    case 20:
                        matlReceived.setVisibility(View.VISIBLE);
                        startedFab.setVisibility(View.VISIBLE);
                        finishedFab.setVisibility(View.VISIBLE);
                        xRay.setVisibility(View.GONE);
                        startCoat.setVisibility(View.GONE);
                        finishedCoat.setVisibility(View.GONE);
                        readyShip.setVisibility(View.GONE);
                        break;
                    case 40:
                        matlReceived.setVisibility(View.VISIBLE);
                        startedFab.setVisibility(View.VISIBLE);
                        finishedFab.setVisibility(View.VISIBLE);
                        xRay.setVisibility(View.VISIBLE);
                        startCoat.setVisibility(View.GONE);
                        finishedCoat.setVisibility(View.GONE);
                        readyShip.setVisibility(View.GONE);
                        break;
                    case 50:
                        matlReceived.setVisibility(View.VISIBLE);
                        startedFab.setVisibility(View.VISIBLE);
                        finishedFab.setVisibility(View.VISIBLE);
                        xRay.setVisibility(View.VISIBLE);
                        startCoat.setVisibility(View.VISIBLE);
                        finishedCoat.setVisibility(View.GONE);
                        readyShip.setVisibility(View.GONE);
                        break;
                    case 60:
                        matlReceived.setVisibility(View.VISIBLE);
                        startedFab.setVisibility(View.VISIBLE);
                        finishedFab.setVisibility(View.VISIBLE);
                        xRay.setVisibility(View.VISIBLE);
                        startCoat.setVisibility(View.VISIBLE);
                        finishedCoat.setVisibility(View.VISIBLE);
                        readyShip.setVisibility(View.GONE);
                        break;
                    case 80:
                    case 100:
                        matlReceived.setVisibility(View.VISIBLE);
                        startedFab.setVisibility(View.VISIBLE);
                        finishedFab.setVisibility(View.VISIBLE);
                        xRay.setVisibility(View.VISIBLE);
                        startCoat.setVisibility(View.VISIBLE);
                        finishedCoat.setVisibility(View.VISIBLE);
                        readyShip.setVisibility(View.VISIBLE);
                        break;
                    default:
                        matlReceived.setVisibility(View.VISIBLE);
                        startedFab.setVisibility(View.GONE);
                        finishedFab.setVisibility(View.GONE);
                        xRay.setVisibility(View.GONE);
                        startCoat.setVisibility(View.GONE);
                        finishedCoat.setVisibility(View.GONE);
                        readyShip.setVisibility(View.GONE);
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
                prg.setProgress(0);
                tracker.setText("");
            }
        });

        matlReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { globs.matlRcvd(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
                startedFab.setVisibility(View.VISIBLE);
                finishedFab.setVisibility(View.GONE);
                xRay.setVisibility(View.GONE);
                startCoat.setVisibility(View.GONE);
                finishedCoat.setVisibility(View.GONE);
                readyShip.setVisibility(View.GONE);
            }
        });

        startedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { globs.startFab(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
                finishedFab.setVisibility(View.VISIBLE);
                xRay.setVisibility(View.GONE);
                startCoat.setVisibility(View.GONE);
                finishedCoat.setVisibility(View.GONE);
                readyShip.setVisibility(View.GONE);
            }
        });

        finishedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { globs.endFab(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
                xRay.setVisibility(View.VISIBLE);
                startCoat.setVisibility(View.GONE);
                finishedCoat.setVisibility(View.GONE);
                readyShip.setVisibility(View.GONE);
            }
        });

        xRay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { globs.xRay(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
                startCoat.setVisibility(View.VISIBLE);
                finishedCoat.setVisibility(View.GONE);
                readyShip.setVisibility(View.GONE);
            }
        });

        startCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { globs.startCoat(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
                finishedCoat.setVisibility(View.VISIBLE);
                readyShip.setVisibility(View.GONE);
            }
        });

        finishedCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { globs.endCoat(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
                readyShip.setVisibility(View.VISIBLE);
            }
        });

        readyShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { globs.shipRdy(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
            }
        });
}

}