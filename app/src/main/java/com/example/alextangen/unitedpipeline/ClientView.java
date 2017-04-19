package com.example.alextangen.unitedpipeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Katia on 4/19/2017.
 */

public class ClientView extends AppCompatActivity {

    GlobalPresenter globs;
    TextView jobList;
    StringBuilder sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_view);

        globs = globs.getInstance();
        jobList = (TextView) findViewById(R.id.job_list);
        sb = new StringBuilder();

        if(globs.getNumJobs() > 0) {

            for (int m = 0; m < globs.getNumJobs(); m++) {
                sb.append("Job Number: " + m + " ");
                sb.append(globs.getName(m) + " with " + globs.getNumPieces(m) + " pieces");
                sb.append("\n");
            }

            jobList.setText("Current Jobs:\n" + sb);
        }

        else {
            jobList.setText("No jobs to display");
        }
    }

}
