package com.example.alextangen.unitedpipeline;

import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by Katia on 3/3/2017.
 */

public class Presenter implements Serializable {

    private MainActivity view;
    private Model model;

    public Presenter(MainActivity view) {
        this.view = view;
        model = new Model();
    }

    public void addJob(Job job) { model.addJob(job); }

    public void matlRcvd(int jobNum, ProgressBar prog, TextView tracker) { model.matlRcvd(jobNum, prog, tracker); }
    public void startFab(int jobNum, ProgressBar prog, TextView tracker) { model.startFab(jobNum, prog, tracker); }
    public void endFab(int jobNum, ProgressBar prog, TextView tracker) { model.endFab(jobNum, prog, tracker); }
    public void xRay(int jobNum, ProgressBar prog, TextView tracker) { model.xRay(jobNum, prog, tracker); }
    public void startCoat(int jobNum, ProgressBar prog, TextView tracker) { model.startCoat(jobNum, prog, tracker); }
    public void endCoat(int jobNum, ProgressBar prog, TextView tracker) { model.endCoat(jobNum, prog, tracker); }
    public void shipRdy(int jobNum, ProgressBar prog, TextView tracker) { model.shipRdy(jobNum, prog, tracker); }

}
