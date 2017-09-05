package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EditJobMenu extends AppCompatActivity {

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
        setContentView(R.layout.activity_edit_job);
        Intent intent = getIntent();

        globs = globs.getInstance();
        setEditJobMenu();

        whichJobString = intent.getStringExtra("whichJob");
        System.out.println(whichJobString);
        whichJobNumber = Integer.parseInt(whichJobString);

        System.out.println("Attempting to get job from server");
        globs.getJobFromServer(whichJobNumber);
        System.out.println("Didn't fail getting job");

        whichJobString = whichJobNumber.toString();
    }

    public void setEditJobMenu() {
        globs.setEditJob(this);
    }

    public void setCurrentJob(Job job) {
        System.out.println("Received a job from the presenter");
        currentJob = job;
    }


    public void JobProgress(View view) {
        Intent intent = new Intent(this, JobProgress.class);

        intent.putExtra("whichJob", whichJobString);

        startActivity(intent);
    }

    public void JobHours(View view) {
        Intent intent = new Intent(this, JobHours.class);

        intent.putExtra("whichJob", whichJobString);

        startActivity(intent);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, ManagerChoice.class);

        startActivity(intent);
    }
}
