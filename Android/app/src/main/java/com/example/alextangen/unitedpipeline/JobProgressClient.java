package com.example.alextangen.unitedpipeline;

import android.app.ActionBar;
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

        String selectionString = getIntent().getStringExtra("selection");
        int selectionNum = Integer.parseInt(selectionString);

        globs.setJobProgressClient(this);
        globs.getJobFromServer(selectionNum);

    }

    public void createView() {
        currentJob = globs.getCurrentJob();

        if (currentJob != null) {
            TextView[] textArray = new TextView[currentJob.getNumPieces()];
            ProgressBar[] progArray = new ProgressBar[currentJob.getNumPieces()];

            LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

            for (int i = 0; i < currentJob.getNumPieces(); i++) {
                textArray[i] = new TextView(this);
                textArray[i].setPadding(50,25,50,25);
                textArray[i].setTextSize(20);
                textArray[i].setText("Piece " + i + ": " + currentJob.getPieceString(i));
                layout.addView(textArray[i]);

                progArray[i] = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
                progArray[i].setIndeterminate(false);
                progArray[i].setMinimumHeight(50);
                progArray[i].setPadding(20,20,20,20);
                progArray[i].setScaleY(3);
                progArray[i].setProgress(currentJob.getPieceProgress(i));
                progArray[i].setVisibility(View.VISIBLE);
                layout.addView(progArray[i]);
            }
        }
    }
}
