package com.example.alextangen.unitedpipeline;

import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by alextangen on 3/30/17.
 */

class GlobalPresenter {
    private static final GlobalPresenter ourInstance = new GlobalPresenter();

    private ManagerChoice managerChoice;

    private EditJobMenu editJobMenu;

    private NewJob thisNewJob;

    private JobProgress jobProgress;

    private JobHours jobHours;

    private Model model;

    private Job currentJob;

    private RequestManager requestManager;

    int j;

    public GlobalPresenter() {
        model = new Model();
        requestManager = new RequestManager();
        j = 0;
    }

    static GlobalPresenter getInstance() {
        return ourInstance;
    }

    public void addJobToServer(Job job) { requestManager.addJob(job);}

    public void getJobFromServer(int whichJob) { requestManager.getJobByID(whichJob);}

    public void getNumJobs() {
        System.out.println("Now in the globs getNumJobs function");
        requestManager.getAllJobs();
    }

    public void sendNumber(String nextPostion) {
        System.out.println("Now in the sendNumber function. Position = " + nextPostion);
        thisNewJob.neededID(nextPostion);
    }

    public void pfHours(int jobNum, int Selection, double hours) {model.pfHours(jobNum, Selection, hours);}
    public void lbHours(int jobNum, int Selection, double hours) {model.lbHours(jobNum, Selection, hours);}
    public double getPfHours(int jobNum, int Selection) {return model.getPfHours(jobNum, Selection);}
    public double getLbHours(int jobNum, int Selection) {return model.getLbHours(jobNum, Selection);}

    public void matlRcvd(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.matlRcvd(jobNum, prog, tracker, Selection); }
    public void startFab(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.startFab(jobNum, prog, tracker, Selection); }
    public void endFab(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.endFab(jobNum, prog, tracker, Selection); }
    public void xRay(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.xRay(jobNum, prog, tracker, Selection); }
    public void startCoat(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.startCoat(jobNum, prog, tracker, Selection); }
    public void endCoat(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.endCoat(jobNum, prog, tracker, Selection); }
    public void shipRdy(int jobNum, ProgressBar prog, TextView tracker, int Selection) { model.shipRdy(jobNum, prog, tracker, Selection); }



    public void setManagerChoice(ManagerChoice manChoice) {
        managerChoice = manChoice;
    }

    public void setNewJob(NewJob newJob) { thisNewJob = newJob;}

    public void setEditJob(EditJobMenu edits) {
        editJobMenu = edits;
    }

    public void setJobP(JobProgress progress) {
        jobProgress = progress;
    }

    public void setJobH(JobHours hours) {
        jobHours = hours;
    }

    //Server Communication stuff
    public void postImportantStuff(Job currentJob) {
        requestManager.postImportantInformation(currentJob);
    }

    public void serverEditJob(Job currentJob) {
        requestManager.editJob(currentJob);
    }

    public void getImportantInfo() {requestManager.getImportantInfo();}

    public void notifyUpdateInfo(String result) {
        System.out.println("Now in the notifyUpdateInfo function, Result = " + result);
        managerChoice.setJobsText(result);
    }

    public void notifyJobReceived(Job job) {
        if(job != null) {
            System.out.println("Received a job from the server");
            model.setCurrentJob(job);
            //currentJob = job;
        }
    }

    public Job getCurrentJob() {
        return model.getCurrentJob();
        //return currentJob;
    }

}

