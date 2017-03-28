package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class JobHours extends AppCompatActivity {
    private Job[] jobsArray = new Job[10];
    Bundle bn;
    Job currentJob;
    Presenter presenter;
    //ProgressBar prg;
    Spinner spins;
    //TextView tracker;
    EditText pipers;
    EditText laborers;
    String name;
    String pieceCount;
    String pipeString;
    String lbString;
    Button carryOn;
    double pfHours;
    double lbHours;
    int pieceCountInt;
    int jobNumber;
    int whichJob = 0;
    int jobNum;
    int selection = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_hours);

        //tracker = (TextView) findViewById(R.id.tracker);
        pipers = (EditText) findViewById(R.id.Pipes);
        laborers = (EditText) findViewById(R.id.LBS);

        carryOn = (Button) findViewById(R.id.allDone);

        Intent intent = getIntent();
        //ArrayList list = new ArrayList();

        //try {
        //    bn = new Bundle();
        //    bn = getIntent().getExtras();
        //    currentJob = bn.getParcelable("CurrentJob");
        //}
        //catch (Exception e) {
        //    Log.e("Err", e.getMessage());
        //}

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

        /*
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

        spins.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int what, long longer) {
                selection = spins.getSelectedItemPosition();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */

        /*
        carryOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pipeString = pipers.getText().toString();
                pfHours = Double.parseDouble(pipeString);
                lbString = laborers.getText().toString();
                lbHours = Double.parseDouble(lbString);
                presenter.pfHours(jobNum, spins.getSelectedItemPosition(), pfHours);
                presenter.lbHours(jobNum, spins.getSelectedItemPosition(), lbHours);
            }
        });
        */
    }
        public void carryThisOn(View view) {
        pipeString = pipers.getText().toString();
        pfHours = Double.parseDouble(pipeString);
        lbString = laborers.getText().toString();
        lbHours = Double.parseDouble(lbString);
        //presenter.pfHours(jobNum, spins.getSelectedItemPosition(), pfHours);
        //presenter.lbHours(jobNum, spins.getSelectedItemPosition(), lbHours);
        }
    }

