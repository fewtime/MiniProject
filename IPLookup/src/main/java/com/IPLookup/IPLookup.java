package com.IPLookup;

import com.IPLookup.Http.HttpRequest;
import com.google.gson.Gson;

import java.util.Scanner;

/**
 * Created by cowlog on 18-1-30.
 */
public class IPLookup {
    private static final String apiURL = "http://ip-api.com/json/";
    public static void main(String[] args) {
        String res = HttpRequest.sendGet(apiURL, null);
        Gson gson = new Gson();
        Info info = gson.fromJson(res, Info.class);
        System.out.println("You are in: " + info.getCity() + ", " + info.getCountry());

        System.out.println("You can input a IP address: (type 'q' to quit) ");
        Scanner sc = new Scanner(System.in);
        String s = null;

        while ((s = sc.nextLine()) != null) {
            if (s.equals("q")) {
                break;
            }

            s = apiURL + s;
            res = HttpRequest.sendGet(s, null);
            info = gson.fromJson(res, Info.class);

            if (info.getStatus().equals("success")) {
                System.out.println("You are in: " + info.getCity() + ", " + info.getCountry());
            } else {
                System.out.println("Invalid IP address.");
            }
            System.out.println("You can input a IP address: (type 'q' to quit) ");
        }
    }
}
