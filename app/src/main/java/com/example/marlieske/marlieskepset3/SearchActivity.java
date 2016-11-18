package com.example.marlieske.marlieskepset3;

import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.json.*;

import java.io.BufferedReader;

/**
 * Marlieske Doorn, App studio 11-16
 * This activity enables the user to enter search for movies and look for these movies.
 */

public class SearchActivity extends AppCompatActivity {
    String Keyword;
    //AsyncTask newAsyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getApplicationContext();
    }

    public void loadMovies(View view) {
        // Retrieve word from ET
        EditText ETKeyWord = (EditText) findViewById(R.id.ETKeyWord);
            if (ETKeyWord.getText().toString() == "") {
                Toast.makeText(this, R.string.toastNoKeyWord, Toast.LENGTH_SHORT).show();
            }
            else {
                Keyword = ETKeyWord.getText().toString();
                AsyncTask newAsyncTask = new MovieAsyncTask(this);
                newAsyncTask.execute(Keyword);
            }
    }

    public void DisplayMovie(MovieAsyncTask newAsyncTask) {
        String result = newAsyncTask.returnString();
        try {
            JSONObject obj = new JSONObject(result);
            String title = obj.getString("Title");
            String year = obj.getString("Year");
            String genre = obj.getString("Genre");
            String plot = obj.getString("Plot");
            String rating = obj.getString("imdbRating");
        //    Image poster = obj.getString("Poster");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void savedList() {

    }

}
