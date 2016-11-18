package com.example.marlieske.marlieskepset3;

import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
                AsyncTask.Status status = newAsyncTask.getStatus();
                Log.d(status.toString(), "failed");
                if (status == AsyncTask.Status.FINISHED) {
                    Log.d("fin", "failed");
                    finishedLoading((MovieAsyncTask) newAsyncTask);
                }
            }
    }



    public void finishedLoading(MovieAsyncTask newAsyncTask) {

            if (newAsyncTask.returnString() == "") {
                Toast.makeText(this, R.string.NotFoundToast, Toast.LENGTH_SHORT).show();
            } else {
                Intent toFoundMovie = new Intent(this, FoundMovie.class);
                startActivity(toFoundMovie);
                finish();
            }
        }
}
