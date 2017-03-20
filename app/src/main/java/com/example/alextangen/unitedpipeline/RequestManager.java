package com.example.alextangen.unitedpipeline;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for handling interaction between Android app and node server.
 * Created by Katia on 3/20/2017.
 */

public class RequestManager {

    private Job job;

    public RequestManager() {
        job = new Job(1);
    }

    public void getAllJobs() {
        new HTTPAsyncTask().execute("http://10.0.2.2:8080/getAllJobs", "GET");
    }

    public void getJobByID(int id) {
        String uri = "http://10.0.2.2:8080/getJobByID/".concat(Integer.toString(id));
        new HTTPAsyncTask().execute(uri, "GET");
    }

    public void addJob(Job job) {
        JSONObject jsonJob = null;
        try {
            jsonJob = new JSONObject();
            // convert Job object to JSON object
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new HTTPAsyncTask().execute("http://10.0.2.2:8080/addJob", "POST", jsonJob.toString());
    }
}
