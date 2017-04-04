package com.example.alextangen.unitedpipeline;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
        Gson gson = new Gson();
        String jobString = gson.toJson(job);
        Log.d("DEBUG", jobString);
        try {
            jsonJob = new JSONObject();
            jsonJob.put("Job", jobString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new HTTPAsyncTask().execute("http://10.0.2.2:8080/addJob", "POST", jsonJob.toString());
    }

    /** Handles HTTP messages by using a separate thread */
    private class HTTPAsyncTask extends AsyncTask<String, Integer, String> {

        @Override
        /*
         * @param params[0] URI
         * @param params[1] type of request (GET or POST)
         * @param params[2] JSON object (only in the case of a POST request)
         * @return string containing contents of HTTP response
         * @exception MalformedURLException
         * @exception IOException
         */
        protected String doInBackground(String... params) {

            /* Variables for creating a connection to HTTP server */
            HttpURLConnection serverConnection = null;
            InputStream is = null;

            try {
                URL url = new URL(params[0]);

                /* Open connection */
                serverConnection = (HttpURLConnection) url.openConnection();

                /* Set GET or POST */
                serverConnection.setRequestMethod(params[1]);

                /* In the case of a POST request ... */
                if (params[1].equals("POST")) {
                    Log.d("DEBUG POST", "In post: params[0]=" + params[0] + ", params[1]=" + params[1] + ", params[2]=" + params[2]);

                    /* Prepare connection to handle JSON object */
                    serverConnection.setDoOutput(true);
                    serverConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                    Log.d("DEBUG", Integer.toString(params[2].getBytes().length));
                    serverConnection.setRequestProperty("Content-Length", "" + Integer.toString(params[2].getBytes().length));

                    /* JSON data is written to the server */
                    DataOutputStream out = new DataOutputStream(serverConnection.getOutputStream());
                    out.writeBytes(params[2]);

                    /* Flush & close output stream buffer */
                    out.flush();
                    out.close();
                }

                /* Get HTTP response */
                is = serverConnection.getInputStream();

                /* Turn response (including JSON data) into a string */
                StringBuilder sb = new StringBuilder();
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                return sb.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } finally {
                Log.d("DEBUG", "Made it this far ...");
                serverConnection.disconnect();
            }
        }

        /**
         * Extracts JSON data
         * @param result string from doInBackground containing contents of HTTP response
         * @exception JSONException
         */
        protected void onPostExecute(String result) {
            try {
                /* Take resulting string from doInBackground & extract JSON object */
                JSONObject jsonData = new JSONObject(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
