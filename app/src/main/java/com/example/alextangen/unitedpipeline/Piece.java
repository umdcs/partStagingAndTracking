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

    public double getPfHours() { return pfHours; }
    public double getLbHours() { return lbHours; }

    public void setMatlRcvd(boolean what) { matlRcvd = what;}
    public void setStartFab(boolean what) { startFab = what;}
    public void setEndFab(boolean what) { endFab = what;}
    public void setxRay(boolean what) { xRay = what;}
    public void setStartCoat(boolean what) { startCoat = what;}
    public void setEndCoat(boolean what) { endCoat = what;}
    public void setShipRdy(boolean what) { shipRdy = what;}

    public void setPfHours(double hours) { pfHours = hours; }
    public void setLbHours(double hours) { lbHours = hours; }

    public void addPfHours(double hours) { pfHours += hours; }
    public void addLbHours(double hours) { lbHours += hours; }

}
