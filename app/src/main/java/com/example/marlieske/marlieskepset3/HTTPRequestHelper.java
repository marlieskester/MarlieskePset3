package com.example.marlieske.marlieskepset3;

import android.content.Intent;
import android.util.Log;
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
    public static String executeRequest(Object Keyword) {
        String result = "";
        try {
            URL link = new URL("http://www.omdbapi.com/?t=" + Keyword);
            HttpURLConnection connection = (HttpURLConnection) link.openConnection();
            Integer ResponseCode = connection.getResponseCode();

            if (ResponseCode >= 300 && ResponseCode <= 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                return String.valueOf(br);
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                result = br.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}