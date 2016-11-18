package com.example.marlieske.marlieskepset3;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Marlieske on 15-11-2016.
 * This function downloads data form the url provided by helper.
 * When the data is downloaded, the file will ...
 */

public class MovieAsyncTask extends AsyncTask<Object, Void, String> {
    Context context;
    SearchActivity activity;
    String result;

    public MovieAsyncTask(SearchActivity activity) {
        // constructs instance
        this.activity = activity;
        this.context=this.activity.getApplicationContext();
    }



    @Override
    protected String doInBackground(Object... params) {
        // executes search
        return HTTPRequestHelper.executeRequest(params[0]);
    }

    @Override
    protected void onPreExecute() {
        // displays message to indicate start search
        Toast.makeText(context, R.string.preExToast, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(String result) {
        //
//        super.OnPostExecute(result);
        Log.d("PE", "pre-if");
        if (result == "") {
            Log.d("PostExecute", "no result");
        }
        else {
            Log.d("PE", "failed");
            returnString();
        }
    }

    public String returnString(){
        Log.d("retstr", "failed");
        return result;
    }

}