package com.example.alextangen.unitedpipeline;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Katia on 3/3/2017.
 */

public class Job{

    private Piece[] pieces;

    private String[] Names = new String[10];
    private String name;
    private int id;
    //private int i = 0;
    private double pfHoursTotal;
    private double lbHoursTotal;
    //public String newString;

    public Job(int numPieces) {
        name = "";
        id = 0;
        pieces = new Piece[numPieces]; //pieces is the array of all pieces for this job
        for (int i = 0; i < numPieces; i++) {
            pieces[i] = new Piece(); //initialize the desired number of pieces

            pfHoursTotal = 0;
            lbHoursTotal = 0;
        }
    }

    // public methods to create/store/update/access pieces and tally man hours

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getID() { return id; }
    public void setID(int id) { this.id = id; }

    public void setMaterialsReceived(int pieceNum) {
        pieces[pieceNum].setMatlRcvd(true);
        pieces[pieceNum].setStartFab(false);
        pieces[pieceNum].setEndFab(false);
        pieces[pieceNum].setxRay(false);
        pieces[pieceNum].setStartCoat(false);
        pieces[pieceNum].setEndCoat(false);
        pieces[pieceNum].setShipRdy(false);
    }
    public void setStartedFab(int pieceNum) {
        if(pieces[pieceNum].getMatlReceived() == true) {
            pieces[pieceNum].setStartFab(true);
            pieces[pieceNum].setEndFab(false);
            pieces[pieceNum].setxRay(false);
            pieces[pieceNum].setStartCoat(false);
            pieces[pieceNum].setEndCoat(false);
            pieces[pieceNum].setShipRdy(false);
        }
    }
    public void setFinishedFab(int pieceNum) {
        if(pieces[pieceNum].getStartFab() == true) {
            pieces[pieceNum].setEndFab(true);
            pieces[pieceNum].setxRay(false);
            pieces[pieceNum].setStartCoat(false);
            pieces[pieceNum].setEndCoat(false);
            pieces[pieceNum].setShipRdy(false);
        }
    }
    public void setXRayReady(int pieceNum) {
        if(pieces[pieceNum].getEndFab() == true) {
            pieces[pieceNum].setxRay(true);
            pieces[pieceNum].setStartCoat(false);
            pieces[pieceNum].setEndCoat(false);
            pieces[pieceNum].setShipRdy(false);
        }
    }
    public void setStartedCoating(int pieceNum) {
        if (pieces[pieceNum].getXRay() == true) {
            pieces[pieceNum].setStartCoat(true);
            pieces[pieceNum].setEndCoat(false);
            pieces[pieceNum].setShipRdy(false);
        }
    }
    public void setFinishedCoating(int pieceNum) {
        if(pieces[pieceNum].getStartCoat() == true) {
            pieces[pieceNum].setEndCoat(true);
            pieces[pieceNum].setShipRdy(false);
        }
    }
    public void setReadyToShip(int pieceNum) {
        if(pieces[pieceNum].getEndCoat() == true) {
            pieces[pieceNum].setShipRdy(true);
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

    public int getPieceProgress(int pieceNum) { return pieces[pieceNum].getProgress(); }
    public String getPieceString(int pieceNum) { return pieces[pieceNum].getThisString(); }

    public void setPfHours(int pieceNum, double hours) {
        pieces[pieceNum].addPfHours(hours);
        pfHoursTotal += hours;
    }
    public void setLbHours(int pieceNum, double hours) {
        pieces[pieceNum].addLbHours(hours);
        lbHoursTotal += hours;
    }

    public double getPfHours(int pieceNum) { return pieces[pieceNum].getPfHours(); }
    public double getLbHours(int pieceNum) { return pieces[pieceNum].getLbHours(); }

    public double getPfHoursTotal() { return pfHoursTotal; }
    public double getLbHoursTotal() { return lbHoursTotal; }

    public int getNumPieces() { return pieces.length; }

}
