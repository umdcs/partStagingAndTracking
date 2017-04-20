package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewJob extends AppCompatActivity {

    GlobalPresenter globs;
    EditText whoFor;
    EditText howMany;
    Button carryOn;
    Integer whichJobNumber;
    String name;
    int pieceCountInt;
    Job currentJob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_job);

        globs = globs.getInstance();

        whoFor = (EditText) findViewById(R.id.who);
        howMany = (EditText) findViewById(R.id.howMany);
        carryOn = (Button) findViewById(R.id.carryOn);
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, NewJobMenu.class);

        //intent.putExtra("who", whoFor.getText().toString());
        //intent.putExtra("howMany", howMany.getText().toString());

        //whichJobNumber = globs.getNumJobs();

        pieceCountInt = Integer.parseInt(howMany.getText().toString());
        name = whoFor.getText().toString();

        currentJob = new Job(pieceCountInt);
        currentJob.setName(whoFor.getText().toString());
        currentJob.setID(globs.getNumJobs());
        globs.addJob(currentJob);
        globs.addJobToServer(currentJob);
        whichJobNumber = globs.getNumJobs() - 1;
        System.out.println("New Job");
        System.out.println("At location number: " + whichJobNumber);
        //globs.setName(name, whichJobNumber);
        //globs.setNumPieces(pieceCountInt, whichJobNumber);
        //currentJob = new Job(pieceCountInt);
        globs.postImportantStuff(whichJobNumber);




        intent.putExtra("whichJob", whichJobNumber.toString());

        startActivity(intent);
    }
}
