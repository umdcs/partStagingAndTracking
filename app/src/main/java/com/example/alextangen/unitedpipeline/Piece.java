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
        if (matlRcvd == true) {
            thisString = "Materials Received";
            progress = 10;
        }
        else {
            thisString = "";
            progress = 0;
            startFab = false;
            endFab = false;
            xRay = false;
            startCoat = false;
            endCoat = false;
            shipRdy = false;
        }
    }
    public void setStartFab(boolean what) {
        startFab = what;
        if (startFab == true) {
            thisString = "Fabrication Started";
            progress = 20;
        }
        else {
            if (matlRcvd == true) {
                progress = 10;
                thisString = "Materials Received";
            }
            else {
                progress = 0;
                thisString = "";
            }
            endFab = false;
            xRay = false;
            startCoat = false;
            endCoat = false;
            shipRdy = false;
        }
    }
    public void setEndFab(boolean what) {
        endFab = what;
        if (endFab == true) {
            thisString = "Fabrication Complete";
            progress = 40;
        }
        else {
            if (startFab == true) {
                progress = 20;
                thisString = "Fabrication Started";
            }
            else if (matlRcvd == true) {
                progress = 10;
                thisString = "Materials Received";
            }
            else {
                progress = 0;
                thisString = "";
            }
            xRay = false;
            startCoat = false;
            endCoat = false;
            shipRdy = false;
        }
    }
    public void setxRay(boolean what) {
        xRay = what;
        if (xRay == true) {
            thisString = "X-Ray Ready";
            progress = 50;
        }
        else {
            if (endFab == true) {
                progress = 40;
                thisString = "Fabrication Complete";
            }
            else if (startFab == true) {
                progress = 20;
                thisString = "Fabrication Started";
            }
            else if (matlRcvd == true) {
                progress = 10;
                thisString = "Materials Received";
            }
            else {
                progress = 0;
                thisString = "";
            }
            startCoat = false;
            endCoat = false;
            shipRdy = false;
        }
    }
    public void setStartCoat(boolean what) {
        startCoat = what;
        if (startCoat == true) {
            thisString = "Coating Started";
            progress = 60;
        }
        else {
            if (xRay == true) {
                progress = 50;
                thisString = "X-Ray Ready";
            }
            else if (endFab == true) {
                progress = 40;
                thisString = "Fabrication Complete";
            }
            else if (startFab == true) {
                progress = 20;
                thisString = "Fabrication Started";
            }
            else if (matlRcvd == true) {
                progress = 10;
                thisString = "Materials Received";
            }
            else {
                progress = 0;
                thisString = "";
            }
            endCoat = false;
            shipRdy = false;
        }
    }
    public void setEndCoat(boolean what) {
        endCoat = what;
        if (endCoat == true) {
            thisString = "Coating Complete";
            progress = 80;
        }
        else {
            if (startCoat == true) {
                progress = 60;
                thisString = "Coating Started";
            }
            else if (xRay == true) {
                progress = 50;
                thisString = "X-Ray Ready";
            }
            else if (endFab == true) {
                progress = 40;
                thisString = "Fabrication Complete";
            }
            else if (startFab == true) {
                progress = 20;
                thisString = "Fabrication Started";
            }
            else if (matlRcvd == true) {
                progress = 10;
                thisString = "Materials Received";
            }
            else {
                progress = 0;
                thisString = "";
            }
            shipRdy = false;
        }

    }
    public void setShipRdy(boolean what) {
        shipRdy = what;
        if (shipRdy == true) {
            thisString = "Ready to Ship!";
            progress = 100;
        }
        else {
            if (endCoat == true) {
                progress = 80;
                thisString = "Coating Complete";
            }
            else if ((endCoat == false) && (startCoat == true)) {
                progress = 60;
                thisString = "Coating Started";
            }
            else if ((endCoat == false) && (startCoat == false) && (xRay == true)) {
                progress = 50;
                thisString = "X-Ray Ready";
            }
            else if ((endCoat == false) && (startCoat == false) && (xRay == false) && (endFab == true)) {
                progress = 40;
                thisString = "Fabrication Complete";
            }
            else if ((endCoat == false) && (startCoat == false) && (xRay == false) && (endFab == false) && (startFab == true)) {
                progress = 20;
                thisString = "Fabrication Started";
            }
            else if ((endCoat == false) && (startCoat == false) && (xRay == false) && (endFab == false) && (startFab == false) && (matlRcvd == true)) {
                progress = 10;
                thisString = "Materials Received";
            }
            else {
                progress = 0;
            }
        }
    }

    public void setPfHours(double hours) { pfHours = hours; }
    public void setLbHours(double hours) { lbHours = hours; }

    public void addPfHours(double hours) { pfHours += hours; }
    public void addLbHours(double hours) { lbHours += hours; }

}
