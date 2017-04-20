package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewJobMenu extends AppCompatActivity {

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

        globs = globs.getInstance();

        whichJobString = intent.getStringExtra("whichJob");
        //whichJobNumber = globs.getNumJobs() - 1;
        //whichJobString = whichJobNumber.toString();
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
