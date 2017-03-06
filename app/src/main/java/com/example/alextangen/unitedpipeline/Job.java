package com.example.alextangen.unitedpipeline;

/**
 * Created by Katia on 3/3/2017.
 */

public class Job {

    private Piece[] pieces;

    private double pfHoursTotal;
    private double lbHoursTotal;

    public Job(int numPieces) {
        pieces = new Piece[numPieces]; //pieces is the array of all pieces, within each is another array of 7
        for(int i=0; i<numPieces; i++) {
            pieces[i] = new Piece();
            System.out.println("Material received = " + pieces[i].getMatlRecieved());
            System.out.println("Start Fabrication = " + pieces[i].getStartFab());
            System.out.println("End Fabrication = " + pieces[i].getEndFab());
            System.out.println("xRay = " + pieces[i].getXRay());
            System.out.println("Start Painting/Coating = " + pieces[i].getStartCoat());
            System.out.println("End Painting/Coating = " + pieces[i].getEndCoat());
            System.out.println("Ship Ready = " + pieces[i].getShipRdy());
        }


        pfHoursTotal = 0;
        lbHoursTotal = 0;
    }

    public void setMaterialsReceived() {
        if(pieces[1].getMatlRecieved() == false) {
            pieces[1].setMatlRcvd(true);
        }
        else pieces[1].setMatlRcvd(false);
    }

    public void setStartedFab() {
        if(pieces[1].getStartFab() == false) {
            pieces[1].setStartFab(true);
        }
        else pieces[1].setStartFab(false);
    }

    public void setFinishedFab() {
        if(pieces[1].getEndFab() == false) {
            pieces[1].setEndFab(true);
        }
        else pieces[1].setEndFab(false);
    }

    public void setXRayReady() {
        if(pieces[1].getXRay() == false) {
            pieces[1].setxRay(true);
        }
        else pieces[1].setxRay(false);
    }

    public void setStartedCoating() {
        if(pieces[1].getStartCoat() == false) {
            pieces[1].setStartCoat(true);
        }
        else pieces[1].setStartCoat(false);
    }

    public void setFinishedCoating() {
        if(pieces[1].getEndCoat() == false) {
            pieces[1].setEndCoat(true);
        }
        else pieces[1].setEndCoat(false);
    }

    public void setReadyToShip() {
        if(pieces[1].getShipRdy() == false) {
            pieces[1].setShipRdy(true);
        }
        else pieces[1].setShipRdy(false);
    }

    public Piece[] getPieces() {
        for(int i=0; i<1; i++) {
            pieces[i] = new Piece();
            System.out.println("Material received = " + pieces[i].getMatlRecieved());
            System.out.println("Start Fabrication = " + pieces[i].getStartFab());
            System.out.println("End Fabrication = " + pieces[i].getEndFab());
            System.out.println("xRay = " + pieces[i].getXRay());
            System.out.println("Start Painting/Coating = " + pieces[i].getStartCoat());
            System.out.println("End Painting/Coating = " + pieces[i].getEndCoat());
            System.out.println("Ship Ready = " + pieces[i].getShipRdy());
        }
        return pieces;
    }

    // public methods to create/store/update/access pieces and tally man hours
}
