package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Presenter presenter;
    public GlobalPresenter globalPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //presenter = new Presenter(this);
        globalPresenter = new GlobalPresenter();
    }

    public void continueAsClient(View view) {
        // triggers new activity in the role of a client
    }

    public void continueAsManager(View view) {
        // triggers new activity in the role of a manager

        Intent managerIntent = new Intent(this, NewJob.class);
        startActivity(managerIntent);
    }
}
