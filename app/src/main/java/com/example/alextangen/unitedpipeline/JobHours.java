package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class JobHours extends AppCompatActivity {
    Job currentJob;
    GlobalPresenter globs;
    Spinner spins;
    TextView shows;
    EditText pipers;
    EditText laborers;
    Button back;
    String pipeString;
    String lbString;
    Button carryOn;
    double pfHours;
    double lbHours;
    String whichJobString;
    int jobNum;
    int selection = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_hours);

        pipers = (EditText) findViewById(R.id.Pipes);
        laborers = (EditText) findViewById(R.id.LBS);
        shows = (TextView) findViewById(R.id.shows);
        carryOn = (Button) findViewById(R.id.allDone);
        back = (Button) findViewById(R.id.back);

        globs = globs.getInstance();

        currentJob = globs.getCurrentJob();

        setJobHours();

        Intent intent = getIntent();
        ArrayList list = new ArrayList();

        whichJobString = intent.getStringExtra("whichJob");

        for (int i = 0; i < currentJob.getNumPieces(); i++) {
            list.add("Piece # " + i);
        }
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spins = (Spinner) findViewById(R.id.spins);
        spins.setAdapter(spinnerArrayAdapter);

        //jobNum = whichJobNumber;
        jobNum = 0;

        spins.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int what, long longer) {
                selection = spins.getSelectedItemPosition();

                shows.setText("Pipe Fitter hours  on piece # " + selection + " = "+ globs.getPfHours(jobNum, selection) + "\n" +
                        "Laborer hours on piece # " + selection + " = " + globs.getLbHours(jobNum, selection));
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public void carryThisOn(View view) {
        if((!pipers.getText().toString().equals("")) && (!laborers.getText().toString().equals(""))) {
            pipeString = pipers.getText().toString();
            pfHours = Double.parseDouble(pipeString);
            lbString = laborers.getText().toString();
            lbHours = Double.parseDouble(lbString);
            globs.pfHours(jobNum, spins.getSelectedItemPosition(), pfHours);
            globs.lbHours(jobNum, spins.getSelectedItemPosition(), lbHours);
            System.out.println("pipefitter hours on piece #" + spins.getSelectedItemPosition() + " = " + globs.getPfHours(jobNum, spins.getSelectedItemPosition()));
            System.out.println("laborer hours on piece #" + spins.getSelectedItemPosition() + " = " + globs.getLbHours(jobNum, spins.getSelectedItemPosition()));

            shows.setText("Pipe Fitter hours  on piece # " + selection + " = " + globs.getPfHours(jobNum, selection) + "\n" +
                    "Laborer hours on piece # " + selection + " = " + globs.getLbHours(jobNum, selection));
        }
        else {
            if((pipers.getText().toString().equals("")) && laborers.getText().toString().equals("")) {
                pipers.setHint("Please enter a value for Pipe Fitters");
                laborers.setHint("Please enter a value for Laborers");
            }
            else if(pipers.getText().toString().equals("")) {
                pipers.setHint("Please enter a value for Pipe Fitters");
            }
            else {
                laborers.setHint("Please enter a value for Laborers");
            }
        }
    }

    public void setJobHours() {
        globs.setJobH(this);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, EditJobMenu.class);

        globs.serverEditJob(currentJob);

        intent.putExtra("whichJob", whichJobString);
        System.out.println("whichJob = " + whichJobString);

        startActivity(intent);
    }
}

