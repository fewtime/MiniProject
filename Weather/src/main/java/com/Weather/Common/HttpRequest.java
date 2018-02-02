package com.Weather.Common;

import java.io.*;
import java.net.*;

/**
 * Created by cowlog on 18-1-30.
 * Implement HTTP GET and POST methods
 */

public class HttpRequest {


    private static final String USER_AGENT = "Mozilla/5.0";

    public static String sendGet(String urlString, String param) {
        String stream = null;
        try {
            if (param != null) {
                urlString = urlString + "?" + param;
            }
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            // Default method: GET
            urlConnection.setRequestMethod("GET");

            // Add request property
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("User-Agent", USER_AGENT);

            urlConnection.connect();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = r.readLine()) != null) {
                    sb.append(line);
                }
                stream = sb.toString();
                urlConnection.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return stream;
    }

    public static String sendPost(String urlString, String param) {
        String stream = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            urlConnection.setRequestMethod("POST");

            // Add request property
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("User-Agent", USER_AGENT);

            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);

            // Sent Post request
            DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
            wr.writeBytes(param);
            wr.flush();
            wr.close();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = r.readLine()) != null) {
                    sb.append(line);
                }
                stream = sb.toString();
                urlConnection.disconnect();
            }

        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stream;
    }
}
