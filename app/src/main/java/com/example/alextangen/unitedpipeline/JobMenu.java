package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class JobMenu extends AppCompatActivity {

    String name;
    String pieceCount;
    int pieceCountInt;
    Job currentJob;
    int jobNumber;
    Job[] jobsArray = new Job[10];
    int whichJob;
    GlobalPresenter globs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_menu);
        Intent intent = getIntent();
        name = intent.getStringExtra("who");
        System.out.println("Name = " + name);
        pieceCount = intent.getStringExtra("howMany");
        pieceCountInt = Integer.parseInt(pieceCount);
        System.out.println("pieceCount = " + pieceCountInt);

        //System.out.println("Current Job");
        //currentJob = new Job(pieceCountInt);
        //currentJob.setName(name);
        //jobNumber = currentJob.getJob(name);

        globs = globs.getInstance();
        //add job to jobs array in the model
        //globs.addJob(currentJob);
        whichJob = globs.getJobNumber(name);

        if(whichJob >=0) {
            currentJob = globs.getJob(whichJob);
        }
        else {
            currentJob = new Job(pieceCountInt);
            jobNumber = globs.addJob(currentJob);
            globs.setName(name, jobNumber);
        }

        /*
        if (jobNumber >= 0) {
            //If job name already exists, get that job and use it
            currentJob = jobsArray[jobNumber];
        } else {
            //If job name does not already exist, add it to the jobs array
            System.out.println("Else loop current job");
            jobsArray[whichJob] = currentJob;
            jobsArray[whichJob].setName(name);
            currentJob = jobsArray[whichJob];
            whichJob++;
            globs.addJob(currentJob);
        }
        */
    }

    public void JobProgress(View view) {
        Intent intent = new Intent(this, JobProgress.class);

        intent.putExtra("who", name);
        intent.putExtra("howMany", pieceCount);

        startActivity(intent);
    }

    public void JobHours(View view) {
        Intent intent = new Intent(this, JobHours.class);


        intent.putExtra("who", name);
        intent.putExtra("howMany", pieceCount);

        startActivity(intent);
    }
}
