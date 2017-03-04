package com.example.alextangen.unitedpipeline;

/**
 * Created by Katia on 3/3/2017.
 */

public class Presenter {

    private MainActivity view;
    private Model model;

    public Presenter(MainActivity view) {
        this.view = view;
        model = new Model();
    }

    // public methods to facilitate interactions between the view(s) and the model
    // updates the view based on which role the user takes - client or manager
}
