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

    GlobalPresenter globs;

    private Job job;
    String myURI = "http://10.0.0.2:8090";

    public RequestManager() {
        globs = globs.getInstance();
    }

    public void getAllJobs() {
        new HTTPAsyncTask().execute("http://131.212.41.37:8090/getAllJobs", "GET");
    }

    public void getJobByID(int id) {
        String uri = "http://131.212.41.37:8090/getJobByID/".concat(Integer.toString(id));
        new HTTPAsyncTask().execute(uri, "GET");
    }

    //public  void postImportantInformation(int jobNum) {
    public void postImportantInformation(Job job) {
        String name = job.getName();
        System.out.println("Name = " + name);
        //String name = globs.getName(jobNum);
        //String uri = "http://131.212.41.37:8090/importantInfo/";
        String uri = "http://10.0.2.2:8090/importantInfo";
        Integer ID = job.getID();
        JSONObject jsonInfo = new JSONObject();
        Gson gson = new Gson();
        String importantString = gson.toJson(job);
        try {
            jsonInfo.put("name", name);
            //jsonInfo.put("ID", ID.toString());
            jsonInfo.put("ID", ID);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        new HTTPAsyncTask().execute(uri, "POST", jsonInfo.toString());
    }

    public void addJob(Job job) {
        //globs = globs.getInstance();
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
        //new HTTPAsyncTask().execute("http://131.212.41.37:8090/addJob", "POST", jsonJob.toString());
        new HTTPAsyncTask().execute("http://10.0.2.2:8090/addJob", "POST", jsonJob.toString());
    }

    public void editJob(Job job) {
        Integer ID = job.getID();
        JSONObject jobObject = null;
        Gson gson = new Gson();
        String jobString = gson.toJson(job);
        Log.d("DEBUG", jobString);
        try {
            jobObject = new JSONObject();
            jobObject.put("Job", jobString);
            jobObject.put("ID", ID);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        new HTTPAsyncTask().execute("http://10.0.2.2:8090/updateJob", "POST", jobObject.toString());


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
                System.out.println("sb = " + sb.toString());
                return sb.toString();

            } catch (MalformedURLException e) {
                System.out.println("MalformedURLException");
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                System.out.println("Had an IOExcpetion");
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
                System.out.println("Json Data:  " + jsonData.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
