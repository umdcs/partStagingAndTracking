package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class ManagerChoice extends AppCompatActivity {

    GlobalPresenter globs;
    TextView text;
    EditText editor;
    String whichJob;
    StringBuilder sb;
    String name;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_choice);
        globs = globs.getInstance();
        text = (TextView) findViewById(R.id.viewer);
        editor = (EditText) findViewById(R.id.editor);
        sb = new StringBuilder();

        globs.setManagerChoice(this);

        globs.getImportantInfo();


        /*
        if(globs.getNumJobs() > 0) {

            for (int m = 0; m < globs.getNumJobs(); m++) {
                sb.append("Job Number: " + m + " ");
                sb.append(globs.getName(m) + " with " + globs.getNumPieces(m) + " pieces");
                sb.append("\n");
            }

            text.setText("Current Jobs: \n" + sb);
            globs.getImportantInfo();
        }

        else {
            text.setText("No jobs to display");
        }
        */

        //whichJob = editor.getText().toString();
        //System.out.println("whichJob = " + whichJob);

    }

    public void setJobsText(String result) {
        try {
            JSONObject jsonData = new JSONObject(result);
            name = jsonData.optString("name");
            id = jsonData.optString("ID");
            //text.setText("Name: " + name + "ID: " + id);
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        text.setText(result);
    }

    public void newJob(View view) {
        Intent intent = new Intent(this, NewJob.class);

        startActivity(intent);
    }

    public void existingJob(View view) {
        Intent editJob = new Intent(this, EditJobMenu.class);
        whichJob = editor.getText().toString();
        editJob.putExtra("whichJob", whichJob);
        System.out.println("whichJob = " + whichJob);


        startActivity(editJob);
    }
}
