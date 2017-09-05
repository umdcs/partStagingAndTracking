package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Katia on 4/19/2017.
 */

public class ClientView extends AppCompatActivity {

    GlobalPresenter globs;
    EditText jobSelection;
    TextView jobList;
    StringBuilder sb;
    String name;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_view);

        globs = globs.getInstance();
        jobSelection= (EditText) findViewById(R.id.job_selection);
        jobList = (TextView) findViewById(R.id.job_list);
        sb = new StringBuilder();

        globs.setClientView(this);

        globs.getImportantInfo();
    }

    public void setJobsText(String result) {
        jobList.setText(result);
    }

    public void viewProgress(View view) {
        if(!jobSelection.getText().toString().equals("")) {
            Intent viewProgress = new Intent(this, JobProgressClient.class);
            String selection = jobSelection.getText().toString();
            viewProgress.putExtra("selection", selection);
            startActivity(viewProgress);
        }
        else {
            jobSelection.setHint("Must select a job!");
        }
    }
}
