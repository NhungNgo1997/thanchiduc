package com.example.btl_tcd.model;

public class ModelTT {
    int id;
    String noidung,a,b,c,d,dapan_dung;

    public ModelTT(int id, String noidung, String a, String b, String c, String d , String dapan_dung) {

        this.id = id;
        this.noidung = noidung;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.dapan_dung = dapan_dung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getDapan_dung() {
        return dapan_dung;
    }

    public void setDapan_dung(String dapan_dung) {
        this.dapan_dung = dapan_dung;
    }
}
