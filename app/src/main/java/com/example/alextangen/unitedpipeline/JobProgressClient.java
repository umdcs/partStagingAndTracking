package com.example.alextangen.unitedpipeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Katia on 4/19/2017.
 */

public class JobProgressClient extends AppCompatActivity {

    GlobalPresenter globs;
    Job currentJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_progress_client);

        globs = globs.getInstance();

        currentJob = new Job(3);
        globs.addJob(currentJob);
        globs.matlRcvd(0, new ProgressBar(this), new TextView(this), 0);
        globs.matlRcvd(0, new ProgressBar(this), new TextView(this), 1);
        globs.matlRcvd(0, new ProgressBar(this), new TextView(this), 2);
        globs.startFab(0, new ProgressBar(this), new TextView(this), 1);
        globs.startFab(0, new ProgressBar(this), new TextView(this), 2);
        globs.endFab(0, new ProgressBar(this), new TextView(this), 2);

        //String selectionString = getIntent().getStringExtra("selection");
        //int selectionNum = Integer.parseInt(selectionString);

        //currentJob = globs.getJob(selectionNum);

        //if (currentJob != null) {
            ProgressBar[] progArray = new ProgressBar[currentJob.getNumPieces()];
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

            for (int i = 0; i < currentJob.getNumPieces(); i++) {
                progArray[i] = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
                progArray[i].setScaleY(3);
                progArray[i].setIndeterminate(false);
                progArray[i].setPadding(20,20,20,20);
                progArray[i].setProgress(currentJob.getPieceProgress(i));
                System.out.println("Piece progress = " + currentJob.getPieceProgress(i));
                progArray[i].setVisibility(View.VISIBLE);
                layout.addView(progArray[i]);
            }
        //}

    }
}
