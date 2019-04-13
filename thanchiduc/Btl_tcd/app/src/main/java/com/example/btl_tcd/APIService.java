package com.example.btl_tcd;

public class APIService {

    /*private static String baseURL = "https://devandroi.000webhostapp.com/Server/";*/

    public static String baseURL = "http://192.168.140.2:8080/api-androi/";

    public static DataService getService(){
        return APIRetrofitClient.getClient(baseURL).create(DataService.class);
    }
}
