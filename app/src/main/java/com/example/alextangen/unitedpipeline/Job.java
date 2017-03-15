package com.example.alextangen.unitedpipeline;

/**
 * Created by Katia on 3/3/2017.
 */

public class Job {

    private Piece[] pieces;

    private String[] Names = new String[10];
    private int i = 0;
    private double pfHoursTotal;
    private double lbHoursTotal;

    public Job(int numPieces) {
        pieces = new Piece[numPieces]; //pieces is the array of all pieces for this job
        for(int i=0; i<numPieces; i++) {
            pieces[i] = new Piece(); //initialize the desired number of pieces
            System.out.println("Now in Job constructor");
            System.out.println("Material received on piece[" + i + "] = " + pieces[i].getMatlReceived());
            System.out.println("Start Fabrication on piece[" + i + "] = " + pieces[i].getStartFab());
            System.out.println("End Fabrication on piece[" + i + "] = " + pieces[i].getEndFab());
            System.out.println("xRay on piece[" + i + "] = "+ pieces[i].getXRay());
            System.out.println("Start Painting/Coating on piece[" + i + "] = " + pieces[i].getStartCoat());
            System.out.println("End Painting/Coating on piece[" + i + "] = " + pieces[i].getEndCoat());
            System.out.println("Ship Ready on piece[" + i + "] = " + pieces[i].getShipRdy());
        }


        pfHoursTotal = 0;
        lbHoursTotal = 0;
    }

    public void setMaterialsReceived(int number) {
        // all of these if statements need to be called by jobs, not by the pieces array
        if(pieces[number].getMatlReceived() == false) {
            System.out.println("Material Received was false");
            pieces[number].setMatlRcvd(true);
        }
        else {
            pieces[number].setMatlRcvd(false);
            System.out.println("Material Received was true");
        }
    }

    public void setStartedFab(int number) {
        if(pieces[number].getStartFab() == false) {
            pieces[number].setStartFab(true);
        }
        else pieces[number].setStartFab(false);
    }

    public void setFinishedFab(int number) {
        if(pieces[number].getEndFab() == false) {
            pieces[number].setEndFab(true);
        }
        else pieces[number].setEndFab(false);
    }

    public void setXRayReady(int number) {
        if(pieces[number].getXRay() == false) {
            pieces[number].setxRay(true);
        }
        else pieces[number].setxRay(false);
    }

    public void setStartedCoating(int number) {
        if(pieces[number].getStartCoat() == false) {
            pieces[number].setStartCoat(true);
        }
        else pieces[number].setStartCoat(false);
    }

    public void setFinishedCoating(int number) {
        if(pieces[number].getEndCoat() == false) {
            pieces[number].setEndCoat(true);
        }
        else pieces[number].setEndCoat(false);
    }

    public void setReadyToShip(int number) {
        if(pieces[number].getShipRdy() == false) {
            pieces[number].setShipRdy(true);
        }
        else pieces[number].setShipRdy(false);
    }

    public Piece[] getPieces() {
        for(int i=0; i<1; i++) {
            //pieces[i] = new Piece();
            /*
            System.out.println("Now in getPieces() function");
            System.out.println("Material received on piece[" + i + "] = " + pieces[i].getMatlReceived());
            System.out.println("Start Fabrication on piece[" + i + "] = " + pieces[i].getStartFab());
            System.out.println("End Fabrication on piece[" + i + "] = " + pieces[i].getEndFab());
            System.out.println("xRay on piece[" + i + "] = "+ pieces[i].getXRay());
            System.out.println("Start Painting/Coating on piece[" + i + "] = " + pieces[i].getStartCoat());
            System.out.println("End Painting/Coating on piece[" + i + "] = " + pieces[i].getEndCoat());
            System.out.println("Ship Ready on piece[" + i + "] = " + pieces[i].getShipRdy());
            */
        }
        return pieces;
    }

    public void setName(String name) {
        Names[i] = name;
        i++;
    }

    public String getName(int whichJob) {
        return Names[whichJob];
    }

    public int getJob(Job job, String name) {
        for (int j = 0; j < i; j++) {
            if (name == job.getName(j)) {
                return j;
            }
        }
        return -1;
    }

    // public methods to create/store/update/access pieces and tally man hours
}
