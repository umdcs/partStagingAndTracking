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

public class Presenter implements Parcelable {

    private AppCompatActivity view;
    private Model model;
    private int mData;

    public Presenter(AppCompatActivity view) {
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

    // required for implementing Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
    }

    public static final Parcelable.Creator<Presenter> CREATOR
            = new Parcelable.Creator<Presenter>() {
        public Presenter createFromParcel(Parcel in) {
            return new Presenter(in);
        }

        public Presenter[] newArray(int size) {
            return new Presenter[size];
        }
    };

    private Presenter(Parcel in) {
        mData = in.readInt();
    }

}
