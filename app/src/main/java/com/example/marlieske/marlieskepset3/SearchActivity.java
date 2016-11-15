package com.example.marlieske.marlieskepset3;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    String Keyword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getApplicationContext();
    }

    public void loadMovies(View view) {
        // Haal het woord op uit de ET
        EditText ETKeyWord = findViewById(R.id.ETKeyWord);
            if (ETKeyWord.getText().toString() == "") {
                Toast.makeText("Please enter keyword");
            }
            else {
                Keyword = ETKeyWord.getText().toString();
            }
        // maak een task om de films te laden
        AsyncTask AsyncTask = new AsyncTask() {
            AsyncTask.execute
            // voer asynctask uit
        }
    }

    public void movieAdapter() {
        // resultaten door adatper
    }

}
