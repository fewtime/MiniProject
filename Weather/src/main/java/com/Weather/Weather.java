package com.Weather;

import com.Weather.Base.Data;
import com.Weather.Base.RootObject;
import com.Weather.Common.HttpRequest;
import com.google.gson.Gson;

import java.util.Scanner;

/**
 * Created by cowlog on 18-2-2.
 * Implement a demo.
 */
public class Weather {
    private final static String apiURL = "http://www.sojson.com/open/api/weather/json.shtml";

    public static void main(String[] args) {
        String param;
        Gson gson = new Gson();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("输入一个城市名字('q'退出)： ");
            param = sc.nextLine();
            String s = HttpRequest.sendGet(apiURL, "city=" + param);
            RootObject rootObject = gson.fromJson(s, RootObject.class);
            if (rootObject.getStatus() == 200) {
                Data data = rootObject.getData();
                System.out.println("温度: " + data.getWendu() + "℃, 空气质量: " + data.getQuality());
            }
        } while (!param.equals("q"));
    }
}
