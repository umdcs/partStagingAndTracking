package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Katia on 4/19/2017.
 */

public class ClientView extends AppCompatActivity {

    GlobalPresenter globs;
    EditText jobSelection;
    TextView jobList;
    StringBuilder sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("LOG: Inside ClientView");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_view);

        globs = globs.getInstance();
        jobSelection= (EditText) findViewById(R.id.job_selection);
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

    public void viewProgress(View view) {
        Intent viewProgress = new Intent(this, JobProgressClient.class);
        String selection = jobSelection.getText().toString();
        viewProgress.putExtra("selection", selection);
        startActivity(viewProgress);
    }

}
