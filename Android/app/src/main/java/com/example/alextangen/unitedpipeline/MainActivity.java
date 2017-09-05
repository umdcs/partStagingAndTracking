package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public GlobalPresenter globalPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        globalPresenter = new GlobalPresenter();
    }

    public void continueAsClient(View view) {
        // triggers new activity in the role of a client
        System.out.println("LOG: Inside continueAsClient");
        Intent clientIntent = new Intent(this, ClientView.class);
        System.out.println("LOG: Intent created");
        startActivity(clientIntent);
    }

    public void continueAsManager(View view) {
        // triggers new activity in the role of a manager
        Intent managerIntent = new Intent(this, ManagerChoice.class);
        startActivity(managerIntent);
    }
}
