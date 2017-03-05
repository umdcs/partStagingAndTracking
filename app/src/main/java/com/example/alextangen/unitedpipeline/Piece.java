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

    public boolean getMatlRecieved() {
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

    public boolean getStartCoat() {
        return startCoat;
    }

    public boolean getEndCoat() {
        return endCoat;
    }

    public boolean getShipRdy() {
        return shipRdy;
    }

    // public methods to update/access progress and man hours
}
