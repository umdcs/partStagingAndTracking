package com.example.alextangen.unitedpipeline;

/**
 * Created by Katia on 3/3/2017.
 */

public class Piece {

    private boolean matlRcvd;
    private boolean startFab;
    private boolean endFab;
    private boolean xRay;
    private boolean startCoat;
    private boolean endCoat;
    private boolean shipRdy;
    private int progress;
    private String thisString;

    private double pfHours;
    private double lbHours;

    public Piece() {
        matlRcvd = false;
        startFab = false;
        endFab = false;
        xRay = false;
        startCoat = false;
        endCoat = false;
        shipRdy = false;

        pfHours = 0;
        lbHours = 0;
    }

    public boolean getMatlReceived() {
        return matlRcvd;
    }
    public boolean getStartFab() {
        return startFab;
    }
    public boolean getEndFab() {
        return endFab;
    }
    public boolean getXRay() {
        return xRay;
    }
    public boolean getStartCoat() { return startCoat; }
    public boolean getEndCoat() {
        return endCoat;
    }
    public boolean getShipRdy() { return shipRdy; }

    public int getProgress() {
        return progress;
    }

    public String getThisString() {
        return thisString;
    }

    public double getPfHours() { return pfHours; }
    public double getLbHours() { return lbHours; }

    public void setMatlRcvd(boolean what) {
        matlRcvd = what;
        progress = 10;
        thisString = "Materials Received";
    }
    public void setStartFab(boolean what) {
        startFab = what;
        progress = 20;
        thisString = "Fabrication Started";
    }
    public void setEndFab(boolean what) {
        endFab = what;
        progress = 40;
        thisString = "Fabrication Complete";
    }
    public void setxRay(boolean what) {
        xRay = what;
        progress = 50;
        thisString = "X-Ray Ready";
    }
    public void setStartCoat(boolean what) {
        startCoat = what;
        progress = 60;
        thisString = "Coating Started";
    }
    public void setEndCoat(boolean what) {
        endCoat = what;
        progress = 80;
        thisString = "Coating Complete";
    }
    public void setShipRdy(boolean what) {
        shipRdy = what;
        progress = 100;
        thisString = "Ready to Ship!";
    }

    public void setPfHours(double hours) { pfHours = hours; }
    public void setLbHours(double hours) { lbHours = hours; }

    public void addPfHours(double hours) { pfHours += hours; }
    public void addLbHours(double hours) { lbHours += hours; }

}
