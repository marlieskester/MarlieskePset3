package com.example.marlieske.marlieskepset3;

import android.content.Intent;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Marlieske on 15-11-2016.
 * This function creates the HTTP request when input is offered.
 */


public class HTTPRequestHelper{

    public static String executeRequest(String Keyword) {
        HttpURLConnection connection = null;
        String result = "";
        URL link = null;

        try {
            link = new URL("http://www.omdbapi.com/?t=" + Keyword);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (link !=null) {
            try {
                link.openConnection();
                connection.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Integer ResponseCode = null;
            try {
                ResponseCode = connection.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (ResponseCode >= 300 && ResponseCode <= 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                return String.valueOf(br);
            }
            else {
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (br != null) {
                    result = result + br;
                }
            }

        }
        return result;
    }
}
