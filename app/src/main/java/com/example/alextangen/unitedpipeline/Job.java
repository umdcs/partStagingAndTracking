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

    private String[] Names = new String[10];
    private String name;
    private int id;
    private int i = 0;
    private double pfHoursTotal;
    private double lbHoursTotal;
    public String newString;

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
        // all of these if statements need to be called by jobs, not by the pieces array
        if(pieces[pieceNum].getMatlReceived() == false) {
            pieces[pieceNum].setMatlRcvd(true);
            goodToGo = true;
        }
        else {
            pieces[pieceNum].setMatlRcvd(false);
            goodToGo = false;
        }
    }
    public void setStartedFab(int pieceNum) {
        if((pieces[pieceNum].getStartFab() == false) && pieces[pieceNum].getMatlReceived() == true) {
            pieces[pieceNum].setStartFab(true);
            goodToGo = true;
        }
        else {
            pieces[pieceNum].setStartFab(false);
            goodToGo = false;
        }
    }
    public void setFinishedFab(int pieceNum) {
        if((pieces[pieceNum].getEndFab() == false) && pieces[pieceNum].getStartFab() == true) {
            pieces[pieceNum].setEndFab(true);
            goodToGo = true;
        }
        else {
            pieces[pieceNum].setEndFab(false);
            goodToGo = false;
        }
    }
    public void setXRayReady(int pieceNum) {
        if((pieces[pieceNum].getXRay() == false) && pieces[pieceNum].getEndFab() == true) {
            pieces[pieceNum].setxRay(true);
            goodToGo = true;
        }
        else {
            pieces[pieceNum].setxRay(false);
            goodToGo = false;
        }
    }
    public void setStartedCoating(int pieceNum) {
        if((pieces[pieceNum].getStartCoat() == false) && pieces[pieceNum].getXRay() == true) {
            pieces[pieceNum].setStartCoat(true);
            goodToGo = true;
        }
        else {
            pieces[pieceNum].setStartCoat(false);
            goodToGo = false;
        }
    }
    public void setFinishedCoating(int pieceNum) {
        if((pieces[pieceNum].getEndCoat() == false) && pieces[pieceNum].getStartCoat() == true) {
            pieces[pieceNum].setEndCoat(true);
            goodToGo = true;
        }
        else {
            pieces[pieceNum].setEndCoat(false);
            goodToGo = false;
        }
    }
    public void setReadyToShip(int pieceNum) {
        if((pieces[pieceNum].getShipRdy() == false) && pieces[pieceNum].getEndCoat() == true) {
            pieces[pieceNum].setShipRdy(true);
            goodToGo = true;
        }
        else {
            pieces[pieceNum].setShipRdy(false);
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

    public int getPieceProgress(int pieceNum) { return pieces[pieceNum].getProgress(); }
    public String getPieceString(int pieceNum) { return pieces[pieceNum].getThisString(); }

    public void setPfHoursTotal(int pieceNum, double hours) {
        pieces[pieceNum].addPfHours(hours);
    }
    public void setLbHoursTotal(int pieceNum, double hours) {
        pieces[pieceNum].addLbHours(hours);
    }

    public double getPfHoursTotal(int pieceNum) {
        pfHoursTotal = pieces[pieceNum].getPfHours();
        return pfHoursTotal;
    }
    public double getLbHoursTotal(int pieceNum) {
        lbHoursTotal = pieces[pieceNum].getLbHours();
        return lbHoursTotal;
    }

    public int getNumPieces() {
        return pieces.length;
    }

    // public methods to create/store/update/access pieces and tally man hours
}
