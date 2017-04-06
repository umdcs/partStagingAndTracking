package com.example.alextangen.unitedpipeline;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Katia on 3/3/2017.
 */

public class Job{

    private Piece[] pieces;
    Boolean goodToGo;
    int whatItWas;

    private String[] Names = new String[10];
    private int i = 0;
    private double pfHoursTotal;
    private double lbHoursTotal;
    public String newString;

    public Job(int numPieces) {
        pieces = new Piece[numPieces]; //pieces is the array of all pieces for this job
        for(int i=0; i<numPieces; i++) {
            pieces[i] = new Piece(); //initialize the desired number of pieces
            /*
            System.out.println("Now in Job constructor");
            System.out.println("Material received on piece[" + i + "] = " + pieces[i].getMatlReceived());
            System.out.println("Start Fabrication on piece[" + i + "] = " + pieces[i].getStartFab());
            System.out.println("End Fabrication on piece[" + i + "] = " + pieces[i].getEndFab());
            System.out.println("xRay on piece[" + i + "] = "+ pieces[i].getXRay());
            System.out.println("Start Painting/Coating on piece[" + i + "] = " + pieces[i].getStartCoat());
            System.out.println("End Painting/Coating on piece[" + i + "] = " + pieces[i].getEndCoat());
            System.out.println("Ship Ready on piece[" + i + "] = " + pieces[i].getShipRdy());
            */
        }


        pfHoursTotal = 0;
        lbHoursTotal = 0;
    }

    public void setMaterialsReceived(int number) {
        // all of these if statements need to be called by jobs, not by the pieces array
        if(pieces[number].getMatlReceived() == false) {
            pieces[number].setMatlRcvd(true);
            goodToGo = true;
        }
        else {
            pieces[number].setMatlRcvd(false);
            goodToGo = false;
        }
    }

    public void setStartedFab(int number) {
        if((pieces[number].getStartFab() == false) && pieces[number].getMatlReceived() == true) {
            pieces[number].setStartFab(true);
            goodToGo = true;
        }
        else {
            pieces[number].setStartFab(false);
            goodToGo = false;
        }
    }

    public void setFinishedFab(int number) {
        if((pieces[number].getEndFab() == false) && pieces[number].getStartFab() == true) {
            pieces[number].setEndFab(true);
            goodToGo = true;
        }
        else {
            pieces[number].setEndFab(false);
            goodToGo = false;
        }
    }

    public void setXRayReady(int number) {
        if((pieces[number].getXRay() == false) && pieces[number].getEndFab() == true) {
            pieces[number].setxRay(true);
            goodToGo = true;
        }
        else {
            pieces[number].setxRay(false);
            goodToGo = false;
        }
    }

    public void setStartedCoating(int number) {
        if((pieces[number].getStartCoat() == false) && pieces[number].getXRay() == true) {
            pieces[number].setStartCoat(true);
            goodToGo = true;
        }
        else {
            pieces[number].setStartCoat(false);
            goodToGo = false;
        }
    }

    public void setFinishedCoating(int number) {
        if((pieces[number].getEndCoat() == false) && pieces[number].getStartCoat() == true) {
            pieces[number].setEndCoat(true);
            goodToGo = true;
        }
        else {
            pieces[number].setEndCoat(false);
            goodToGo = false;
        }
    }

    public void setReadyToShip(int number) {
        if((pieces[number].getShipRdy() == false) && pieces[number].getEndCoat() == true) {
            pieces[number].setShipRdy(true);
            goodToGo = true;
        }
        else {
            pieces[number].setShipRdy(false);
            goodToGo = false;
        }
    }

    public Piece[] getPieces() {
        for(int j=0; j<pieces.length; j++) {
            //pieces[i] = new Piece();

            System.out.println("Now in getPieces() function");
            System.out.println("Material received on piece[" + j + "] = " + pieces[j].getMatlReceived());
            System.out.println("Start Fabrication on piece[" + j + "] = " + pieces[j].getStartFab());
            System.out.println("End Fabrication on piece[" + j + "] = " + pieces[j].getEndFab());
            System.out.println("xRay on piece[" + j + "] = "+ pieces[j].getXRay());
            System.out.println("Start Painting/Coating on piece[" + j + "] = " + pieces[j].getStartCoat());
            System.out.println("End Painting/Coating on piece[" + j + "] = " + pieces[j].getEndCoat());
            System.out.println("Ship Ready on piece[" + j + "] = " + pieces[j].getShipRdy());
            System.out.println("/n");

        }
        return pieces;
    }

    /*

    public void setName(String name) {
        Names[i] = name;
        i++;
    }

    public String getName(int whichJob) {
        return Names[whichJob];
    }

    public int getJob(String name) {
        for (int j = 0; j < i; j++) {
            if(name == this.getName(j)) {
                return j;
            }
        }
        return -1;
    }

    */

    public int getPieceProgress(int number) {
        int thisProgress;
            thisProgress = pieces[number].getProgress();
            return thisProgress;
    }

    public String getPieceString(int number) {
        //String newString;
        newString = pieces[number].getThisString();
        return newString;
    }

    public void setPfHoursTotal(int piece, double hours) {
        pieces[piece].addPfHours(hours);
    }

    public void setLbHoursTotal(int piece, double hours) {
        pieces[piece].addLbHours(hours);
    }

    public double getPfHoursTotal(int piece) {
        pfHoursTotal = pieces[piece].getPfHours();
        return pfHoursTotal;
    }

    public double getLbHoursTotal(int piece) {
        lbHoursTotal = pieces[piece].getLbHours();
        return lbHoursTotal;
    }

    // public methods to create/store/update/access pieces and tally man hours
}
