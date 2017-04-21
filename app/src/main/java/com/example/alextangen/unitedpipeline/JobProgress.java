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

        globs = GlobalPresenter.getInstance();

        currentJob = globs.getCurrentJob();

        setJobProgress();

        Intent intent = getIntent();
        ArrayList list = new ArrayList();

        whichJob = intent.getStringExtra("whichJob");

        whichJobNumber = Integer.parseInt(whichJob);

        System.out.println("Current Job pieces = " + currentJob.getNumPieces());
        for(int i = 0; i < currentJob.getNumPieces(); i++) {
            list.add("Piece # " + i);
        }
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spins = (Spinner) findViewById(R.id.spins);
        spins.setAdapter(spinnerArrayAdapter);

        jobNum = whichJobNumber;
        System.out.println("jobNum = " + jobNum);

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
            public void onClick(View view) { globs.matlRcvd(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
            }
        });

        startedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { globs.startFab(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
            }
        });

        finishedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { globs.endFab(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
            }
        });

        xRay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { globs.xRay(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
            }
        });

        startCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { globs.startCoat(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
            }
        });

        finishedCoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { globs.endCoat(jobNum, prg, tracker, spins.getSelectedItemPosition());
                prg.setProgress(currentJob.getPieceProgress(selection));
                tracker.setText(currentJob.getPieceString(selection));
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

    public void goBack(View view) {
        Intent intent = new Intent(this, NewJobMenu.class);

        System.out.println("jobNum in post function = " + jobNum);

        globs.serverEditJob(globs.getCurrentJob());

        startActivity(intent);
    }

    public void setJobProgress() {
        globs.setJobP(this);
    }

}