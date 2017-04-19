package com.example.alextangen.unitedpipeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

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

        String selectionString = getIntent().getStringExtra("selection");
        int selectionNum = Integer.parseInt(selectionString);

        currentJob = globs.getJobByID(selectionNum);

        ProgressBar[] progArray = new ProgressBar[currentJob.getNumPieces()];

        for (int i = 0; i < currentJob.getNumPieces(); i++) {
            progArray[i].setProgress(currentJob.getPieceProgress(i));
        }

    }
}
