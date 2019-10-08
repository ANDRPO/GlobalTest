package com.example.globaltest;

public class MyDataUsers {
    private int id_st;
    private String fir_name_st, sec_name_st, las_name_st, city_st, url_st, age_st;

    public String getUrl_st() {
        return url_st;
    }

    public void setUrl_st(String url_st) {
        this.url_st = url_st;
    }

    public MyDataUsers(int id_st, String fir_name_st, String sec_name_st, String las_name_st, String city_st, String url_st, String age_st) {
        this.id_st = id_st;
        this.fir_name_st = fir_name_st;
        this.sec_name_st = sec_name_st;
        this.las_name_st = las_name_st;
        this.city_st = city_st;
        this.url_st = url_st;
        this.age_st = age_st;
    }

    public String getCity_st() {
        return city_st;
    }

    public void setCity_st(String city_st) {
        this.city_st = city_st;
    }

    public int getId_st() {
        return id_st;
    }

    public void setId_st(int id_st) {
        this.id_st = id_st;
    }

    public String getFir_name_st() {
        return fir_name_st;
    }

    public void setFir_name_st(String fir_name_st) {
        this.fir_name_st = fir_name_st;
    }

    public String getSec_name_st() {
        return sec_name_st;
    }

    public void setSec_name_st(String sec_name_st) {
        this.sec_name_st = sec_name_st;
    }

    public String getLas_name_st() {
        return las_name_st;
    }

    public void setLas_name_st(String las_name_st) {
        this.las_name_st = las_name_st;
    }

    public String getAge_st() {
        return age_st;
    }

    public void setAge_st(String age_st) {
        this.age_st = age_st;
    }
}
