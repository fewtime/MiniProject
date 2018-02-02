package com.ZipCode;

import com.ZipCode.Base.Result;
import com.ZipCode.Base.RootObject;
import com.ZipCode.Common.HttpRequest;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by cowlog on 18-2-2.
 * Implement Zip code (demo).
 */

public class ZipCode {
    private static final String apiURL = "http://api.avatardata.cn/PostNumber/QueryPostnumber";
    private static final String apiKey = null;
    private static final String apiRow = "50";
    private static final String apiPage = "1";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String postCode;
        Gson gson = new Gson();
        do {
            System.out.println("Enter a zip code('q' to quit): ");
            postCode = sc.nextLine();
            String res = HttpRequest.sendGet(apiURL, "key=" + apiKey
                    + "&postnumber=" + postCode
                    + "&page=" + apiPage
                    + "&row=" + apiRow
            );
            RootObject rootObject = gson.fromJson(res, RootObject.class);
            if (rootObject.getErrorCode() == 0) {
                ArrayList<Result> arr = rootObject.getResult();
                for (Result result : arr) {
                    System.out.println(result.getProvince()
                            + " " + result.getCity()
                            + " " + result.getDistrict()
                            + " " + result.getAddress()
                            + " " + result.getJd());
                }
            }
        } while (!postCode.equals("q"));
    }
}
