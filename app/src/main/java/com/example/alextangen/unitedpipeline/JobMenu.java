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
    int whichJob = 0;
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

        System.out.println("Current Job");
        currentJob = new Job(pieceCountInt);
        jobNumber = currentJob.getJob(name);

        globs = globs.getInstance();

        if (jobNumber >= 0) {
            currentJob = jobsArray[jobNumber];
        } else {
            System.out.println("Else loop current job");
            jobsArray[whichJob] = currentJob;
            jobsArray[whichJob].setName(name);
            currentJob = jobsArray[whichJob];
            whichJob++;
            globs.addJob(currentJob);
        }
    }

    public void JobProgress(View view) {
        Intent intent = new Intent(this, JobProgress.class);

        //Bundle b = new Bundle();
        //b.putParcelable("CurrentJob", currentJob);
        //intent.putExtras(b);

        intent.putExtra("who", name);
        intent.putExtra("howMany", pieceCount);
        //intent.putExtra("thisJob", currentJob);

        startActivity(intent);
    }

    public void JobHours(View view) {
        Intent intent = new Intent(this, JobHours.class);

        //Bundle b = new Bundle();
        //b.putParcelable("CurrentJob", currentJob);
        //intent.putExtras(b);

        intent.putExtra("who", name);
        intent.putExtra("howMany", pieceCount);

        startActivity(intent);
    }
}
