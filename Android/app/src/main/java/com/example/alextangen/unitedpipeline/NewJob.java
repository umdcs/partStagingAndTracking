package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.annotation.IntegerRes;
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
    String idString;
    Integer id;
    Job currentJob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_job);

        globs = globs.getInstance();
        globs.setNewJob(this);

        System.out.println("Now in the NewJob onCreate method");
        globs.getNumJobs();

        whoFor = (EditText) findViewById(R.id.who);
        howMany = (EditText) findViewById(R.id.howMany);
        carryOn = (Button) findViewById(R.id.carryOn);
    }

    public void neededID(String needed) {
        idString = needed;
        System.out.println("Now in the neededID function. Id = " + needed);
        id = Integer.parseInt(idString);
    }

    public void nextActivity(View view) {
        if((!whoFor.getText().toString().equals("")) && (!howMany.getText().toString().equals(""))) {
            Intent intent = new Intent(this, NewJobMenu.class);

            pieceCountInt = Integer.parseInt(howMany.getText().toString());
            name = whoFor.getText().toString();

            currentJob = new Job(pieceCountInt);
            currentJob.setName(whoFor.getText().toString());
            currentJob.setID(id);

            whichJobNumber = id;

            globs.addJobToServer(currentJob);
            //code to get what number the new job is at on the server
            globs.getNumJobs();

            System.out.println("New Job");

            globs.postImportantStuff(currentJob);

            System.out.println("Attempting to get job from server");
            globs.getJobFromServer(whichJobNumber);
            System.out.println("Didn't fail getting job");

            intent.putExtra("whichJob", whichJobNumber.toString());

            startActivity(intent);
        }
        else {
            if((whoFor.getText().toString().equals("")) && (howMany.getText().toString().equals(""))) {
                whoFor.setHint("Please enter who this job is for:");
                howMany.setHint("Please enter the number of pieces:");
            }
            else if(whoFor.getText().toString().equals("")) {
                whoFor.setHint("Please enter who this job is for:");
            }
            else {
                howMany.setHint("Please enter the number of pieces:");
            }
        }
    }
}
