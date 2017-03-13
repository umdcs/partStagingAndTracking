package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);
    }

    public void continueInGeneral(View view) {
        // triggers new activity in no role just to make sure pieces work

        Intent generalIntent = new Intent(this, generalActivity.class);
        generalIntent.putExtra("Presenter", presenter);

        startActivity(generalIntent);
    }

    public void continueAsClient(View view) {
        // triggers new activity in the role of a client

        //Intent managerIntent = new Intent(this, ManagerActivity.class);

        //startActivity(managerIntent);
    }

    public void continueAsManager(View view) {
        // triggers new activity in the role of a manager

        Intent managerIntent = new Intent(this, ManagerActivity.class);

        startActivity(managerIntent);
    }
}
