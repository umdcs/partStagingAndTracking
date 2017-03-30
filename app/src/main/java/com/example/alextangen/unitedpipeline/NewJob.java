package com.example.alextangen.unitedpipeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewJob extends AppCompatActivity {

    Presenter presenter;
    GlobalPresenter globs;
    EditText whoFor;
    EditText howMany;
    Button carryOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_job);

        globs = globs.getInstance();

        whoFor = (EditText) findViewById(R.id.who);
        howMany = (EditText) findViewById(R.id.howMany);
        carryOn = (Button) findViewById(R.id.carryOn);
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, JobMenu.class);

        intent.putExtra("who", whoFor.getText().toString());
        intent.putExtra("howMany", howMany.getText().toString());

        startActivity(intent);
    }
}
