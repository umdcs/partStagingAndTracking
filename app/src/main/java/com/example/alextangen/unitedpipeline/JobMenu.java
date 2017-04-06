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
    Integer whichJob;
    String whichJobString;
    Integer whichJobNumber;
    GlobalPresenter globs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_menu);
        Intent intent = getIntent();

        //whichJobString = intent.getStringExtra("whichJob");
        //whichJobNumber = Integer.parseInt(whichJobString);
        name = intent.getStringExtra("who");
        System.out.println("Name = " + name);
        pieceCount = intent.getStringExtra("howMany");
        pieceCountInt = Integer.parseInt(pieceCount);
        System.out.println("pieceCount = " + pieceCountInt);

        globs = globs.getInstance();

        whichJob = globs.getJobNumber(name);
        //returns -1 if first not in the array already
        System.out.println("Job Number = " + whichJob);



        if(whichJob >=0) {
            System.out.println("Job already existed");
            currentJob = globs.getJob(whichJob);
            whichJobString = whichJob.toString();
        }
        else {
            //whichJobNumber = current vacant location
            whichJobNumber = globs.getNumJobs();
            System.out.println("New Job");
            System.out.println("At location number: " + whichJobNumber);
            globs.setName(name, whichJobNumber);
            currentJob = new Job(pieceCountInt);
            globs.addJob(currentJob);
            //jobNumber = globs.getJobNumber(name);
            //whichJob = globs.getNumJobs() - 1;
            //globs.setName(name, whichJob);
            //globs.setName(name, whichJobNumber);
            //whichJob = globs.getJobNumber(name);
            whichJobString = whichJobNumber.toString();
        }

        //whichJobString = whichJobNumber.toString();


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

        intent.putExtra("whichJob", whichJobString);
        intent.putExtra("who", name);
        intent.putExtra("howMany", pieceCount);

        startActivity(intent);
    }

    public void JobHours(View view) {
        Intent intent = new Intent(this, JobHours.class);

        intent.putExtra("whichJob", whichJobString);
        intent.putExtra("who", name);
        intent.putExtra("howMany", pieceCount);

        startActivity(intent);
    }
}
