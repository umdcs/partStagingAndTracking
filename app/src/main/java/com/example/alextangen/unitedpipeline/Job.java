package com.example.alextangen.unitedpipeline;

/**
 * Created by Katia on 3/3/2017.
 */

public class Job {

    private Piece[] pieces;

    private String Name;
    private double pfHoursTotal;
    private double lbHoursTotal;

    public Job(int numPieces) {
        pieces = new Piece[numPieces]; //pieces is the array of all pieces, within each is another array of 7
        for(int i=0; i<numPieces; i++) {
            pieces[i] = new Piece();
            System.out.println("Material received = " + pieces[i].getMatlReceived());
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
        if(pieces[0].getMatlReceived() == false) {
            System.out.println("Material Received was false");
            pieces[0].setMatlRcvd(true);
        }
        else {
            pieces[0].setMatlRcvd(false);
            System.out.println("Material Received was true");
        }
    }

    public void setStartedFab() {
        if(pieces[0].getStartFab() == false) {
            pieces[0].setStartFab(true);
        }
        else pieces[0].setStartFab(false);
    }

    public void setFinishedFab() {
        if(pieces[0].getEndFab() == false) {
            pieces[0].setEndFab(true);
        }
        else pieces[0].setEndFab(false);
    }

    public void setXRayReady() {
        if(pieces[0].getXRay() == false) {
            pieces[0].setxRay(true);
        }
        else pieces[0].setxRay(false);
    }

    public void setStartedCoating() {
        if(pieces[0].getStartCoat() == false) {
            pieces[0].setStartCoat(true);
        }
        else pieces[0].setStartCoat(false);
    }

    public void setFinishedCoating() {
        if(pieces[0].getEndCoat() == false) {
            pieces[0].setEndCoat(true);
        }
        else pieces[0].setEndCoat(false);
    }

    public void setReadyToShip() {
        if(pieces[0].getShipRdy() == false) {
            pieces[0].setShipRdy(true);
        }
        else pieces[0].setShipRdy(false);
    }

    public Piece[] getPieces() {
        for(int i=0; i<1; i++) {
            //pieces[i] = new Piece();
            System.out.println("Material received = " + pieces[i].getMatlReceived());
            System.out.println("Start Fabrication = " + pieces[i].getStartFab());
            System.out.println("End Fabrication = " + pieces[i].getEndFab());
            System.out.println("xRay = " + pieces[i].getXRay());
            System.out.println("Start Painting/Coating = " + pieces[i].getStartCoat());
            System.out.println("End Painting/Coating = " + pieces[i].getEndCoat());
            System.out.println("Ship Ready = " + pieces[i].getShipRdy());
        }
        return pieces;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    // public methods to create/store/update/access pieces and tally man hours
}
