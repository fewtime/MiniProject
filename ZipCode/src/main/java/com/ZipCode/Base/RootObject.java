package com.ZipCode.Base;

import java.util.ArrayList;

/**
 * Created by cowlog on 18-2-2.
 * Implement Root object.
 */

public class RootObject {
    private int total;
    private ArrayList<Result> result;
    private Object SingerResult;
    private int error_code;
    private String reason;

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<Result> getResult() {
        return this.result;
    }

    public void setResult(ArrayList<Result> result) {
        this.result = result;
    }

    public Object getSingerResult() {
        return this.SingerResult;
    }

    public void setSingerResult(Object SingerResult) {
        this.SingerResult = SingerResult;
    }


    public int getErrorCode() {
        return this.error_code;
    }

    public void setErrorCode(int error_code) {
        this.error_code = error_code;
    }


    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
