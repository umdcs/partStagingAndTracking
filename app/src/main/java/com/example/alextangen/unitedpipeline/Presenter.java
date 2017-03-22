package com.example.alextangen.unitedpipeline;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by Katia on 3/3/2017.
 */

public class Presenter {

    private AppCompatActivity view;
    private Model model;
    private int mData;

    public Presenter(AppCompatActivity view) {
        this.view = view;
        model = new Model();
    }

    public void addJob(Job job) { model.addJob(job); }

    public void matlRcvd(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.matlRcvd(jobNum, prog, tracker, Selection); }
    public void startFab(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.startFab(jobNum, prog, tracker, Selection); }
    public void endFab(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.endFab(jobNum, prog, tracker, Selection); }
    public void xRay(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.xRay(jobNum, prog, tracker, Selection); }
    public void startCoat(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.startCoat(jobNum, prog, tracker, Selection); }
    public void endCoat(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.endCoat(jobNum, prog, tracker, Selection); }
    public void shipRdy(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.shipRdy(jobNum, prog, tracker, Selection); }

}
