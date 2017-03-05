package com.example.alextangen.unitedpipeline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class generalActivity extends AppCompatActivity {

    private Presenter generalPresenter;
    private Job generalJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        //generalPresenter = new Presenter(this); can make presenter work later on
        generalJob = new Job(6);

        //generalJob.setPieces(6); // need to find a way to set all pieces to false on create and return that
        //generalJob.getPieces();
    }
}
