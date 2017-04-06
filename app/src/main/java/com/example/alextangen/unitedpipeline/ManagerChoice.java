package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ManagerChoice extends AppCompatActivity {

    GlobalPresenter globs;
    TextView text;
    EditText editor;
    String whichJob;
    StringBuilder sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_choice);
        globs = globs.getInstance();
        text = (TextView) findViewById(R.id.viewer);
        editor = (EditText) findViewById(R.id.editor);
        sb = new StringBuilder();

        if(globs.getNumJobs() > 0) {

            for (int m = 0; m < globs.getNumJobs(); m++) {
                sb.append("Job Number: " + m + " ");
                sb.append(globs.getName(m) + " with " + globs.getNumPieces(m) + " pieces");
                sb.append("\n");
            }

            text.setText("Current Jobs: \n" + sb);
        }

        else {
            text.setText("No jobs to display");
        }

        whichJob = editor.getText().toString();

    }

    public void newJob(View view) {
        Intent intent = new Intent(this, NewJob.class);

        startActivity(intent);
    }

    public void existingJob(View view) {
        Intent editJob = new Intent(this, EditJob.class);
        editJob.putExtra("whichJob", whichJob);

        startActivity(editJob);
    }
}
