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

    // public methods to create/store pieces and tally man hours
}
