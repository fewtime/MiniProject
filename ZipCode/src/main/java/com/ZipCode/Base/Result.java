package com.ZipCode.Base;

/**
 * Created by cowlog on 18-2-2.
 * Implement Result object.
 */

public class Result {
    private String postnumber;
    private String province;
    private String city;
    private String district;
    private String address;
    private String jd;

    public String getPostnumber() {
        return this.postnumber;
    }

    public void setPostnumber(String postnumber) {
        this.postnumber = postnumber;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJd() {
        return this.jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }
}
