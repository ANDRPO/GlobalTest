package com.example.globaltest.Data;

public class MyDataComments {
    private int id_com;
    private String comment;

    public MyDataComments(int id_com, String comment) {
        this.id_com = id_com;
        this.comment = comment;
    }

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
