package com.example.marlieske.marlieskepset3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Marlieske on 15-11-2016.
 */

public class HTTPRequestHelper {
    String keyWord = params[0];
    connect();

    public void connect() {
        HttpURLConnection connection;
        String result;
        URL link = null;
        try {
            link = new URL("http://www.omdbapi.com/?t=" + keyWord);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (link !=null) {
            try {
                link.openConnection()
                connection.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            Integer ResponseCode = connection.getResponseCode();
            if (ResponseCode >= 200 && ResponseCode <= 300) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while (br != null) {
                        result = result + br;
                }
                return result;
            }
            else {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                return br;
            }

        }
    }
}
