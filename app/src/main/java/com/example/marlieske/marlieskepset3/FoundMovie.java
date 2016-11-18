package com.example.marlieske.marlieskepset3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;

public class FoundMovie extends AppCompatActivity {
String title;
    Array arrMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_movie);
    }

    public void DisplayMovie(MovieAsyncTask newAsyncTask) {
        String result = newAsyncTask.returnString();
        try {
            JSONObject obj = new JSONObject(result);
            title = obj.getString("Title");
            String year = obj.getString("Year");
            String genre = obj.getString("Genre");
            String plot = obj.getString("Plot");
            String rating = obj.getString("imdbRating");
            String poster = obj.getString("Poster");

            TextView TVTitle = (TextView) findViewById(R.id.TVtitle);
            TVTitle.setText(title);
            TextView TVYear = (TextView) findViewById(R.id.TVYear);
            TVYear.setText("(" + year + ")");
            TextView TVGenre = (TextView) findViewById(R.id.TVGenre);
            TVGenre.setText("Genre: " + genre + "Rating: " + rating);
            TextView TVPlot = (TextView) findViewById(R.id.TVPlot);
            TVPlot.setText(plot);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void addToList(View view) {
        SharedPreferences spList = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spList.edit();
        //editor.putString("Status_0", arrMovie.size());


        editor.putString("movie_0", title);
        editor.commit();
        Intent toWatchList = new Intent(this, watchListActivity.class);
        startActivity(toWatchList);
        finish();
    }
}
