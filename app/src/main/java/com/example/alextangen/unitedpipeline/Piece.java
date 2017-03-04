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

    // public methods to update/access progress and man hours
}
