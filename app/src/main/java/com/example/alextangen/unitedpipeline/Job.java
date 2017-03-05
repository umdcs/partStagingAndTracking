package com.example.alextangen.unitedpipeline;

/**
 * Created by Katia on 3/3/2017.
 */

public class Job {

    private Piece[] pieces;

    private double pfHoursTotal;
    private double lbHoursTotal;

    public Job(int numPieces) {
        pieces = new Piece[numPieces];


        pfHoursTotal = 0;
        lbHoursTotal = 0;
    }

    public void setPieces(int numPieces) {
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
    }

    public Piece[] getPieces() {
        return pieces;
    }

    // public methods to create/store/update/access pieces and tally man hours
}
