package com.example.alextangen.unitedpipeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Katia on 4/19/2017.
 */

public class JobProgressClient extends AppCompatActivity {

    GlobalPresenter globs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_view);

        globs = globs.getInstance();
    }
}
