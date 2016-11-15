package com.example.marlieske.marlieskepset3;

import android.os.AsyncTask;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Marlieske on 15-11-2016.
 */

public class MovieAsyncTask extends AsyncTask<String, Integer, String> {
    public  MovieAsyncTask(SearchActivity activity) {
        this.context=this.activity.getApplicationContext;
    }
    protected void OnPreExecute() {
        Toast.makeText(context, "Loading your movies");
    }

    String DoinBackground(String... params) {
        return HTTPRequestHelper.downloadfromServer(params);
    }

    protected void OnPostExecute(String result) {
        super.OnPostExecute(result);
        if (params[0])
        // check: iets ontvangen? && iets gevonden? else:
        ArrayList<MovieData> MovieData = new ArrayList<>();


    }
}