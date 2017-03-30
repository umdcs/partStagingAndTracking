package com.example.alextangen.unitedpipeline;

import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by alextangen on 3/30/17.
 */

class GlobalPresenter {
    private static final GlobalPresenter ourInstance = new GlobalPresenter();
    //private final AppCompatActivity View;
    private Model model;

    static GlobalPresenter getInstance() {
        return ourInstance;
    }

    //Model model;

    ProgressBar prog;

    public GlobalPresenter() {

        //AppCompatActivity View;
        //Model model;
        int mData;

        //this.View = view;
        model = new Model();
    }

    public void addJob(Job job) { model.addJob(job); }
    public Job getJob(int whichJob) { return model.getJob(whichJob);}

    public void pfHours(int jobNum, int Selection, double hours) {model.pfHours(jobNum, Selection, hours);}
    public void lbHours(int jobNum, int Selection, double hours) {model.lbHours(jobNum, Selection, hours);}
    public double getPfHours(int jobNum, int Selection) {return model.getPfHours(jobNum, Selection);}
    public double getLbHours(int jobNum, int Selection) {return model.getLbHours(jobNum, Selection);}


    public void matlRcvd(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.matlRcvd(jobNum, prog, tracker, Selection); }
    public void startFab(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.startFab(jobNum, prog, tracker, Selection); }
    public void endFab(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.endFab(jobNum, prog, tracker, Selection); }
    public void xRay(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.xRay(jobNum, prog, tracker, Selection); }
    public void startCoat(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.startCoat(jobNum, prog, tracker, Selection); }
    public void endCoat(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.endCoat(jobNum, prog, tracker, Selection); }
    public void shipRdy(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.shipRdy(jobNum, prog, tracker, Selection); }


}

