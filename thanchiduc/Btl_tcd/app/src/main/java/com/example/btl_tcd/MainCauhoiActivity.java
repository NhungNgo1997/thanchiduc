package com.example.btl_tcd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btl_tcd.model.ModelTT;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainCauhoiActivity extends AppCompatActivity {
    ArrayList<ModelTT> list,listRandom;
    TextView tvCau1, tvCau2, tvCau3, tvCau4, tvCauhoi,tvCauhientai;
    public int  cauhientai=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cauhoi);

        tvCau1 = findViewById(R.id.tvCau1);
        tvCau2 = findViewById(R.id.tvCau2);
        tvCau3 = findViewById(R.id.tvCau3);
        tvCau4 = findViewById(R.id.tvCau4);
        tvCauhoi = findViewById(R.id.tvCauhoi);
        tvCauhientai = findViewById(R.id.tvCauhientai);

        tvCau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyencau(tvCau1);
            }
        });
        tvCau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyencau(tvCau2);
            }
        });
        tvCau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyencau(tvCau3);
            }
        });
        tvCau4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyencau(tvCau4);
            }
        });
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backMain();
            }
        });
        loadCauhoi();
    }
    private void backMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void loadCauhoi(){
        DataService dataService = APIService.getService();
        Call<List<ModelTT>> callback = dataService.GetAllData();
        callback.enqueue(new Callback<List<ModelTT>>() {
            @Override
            public void onResponse(Call<List<ModelTT>> call, Response<List<ModelTT>> response) {
//                Toast.makeText(MainCauhoiActivity.this, "k loi nhe", Toast.LENGTH_SHORT).show();
                list = new ArrayList<>();
                cauhientai = 0;
                list = (ArrayList<ModelTT>) response.body();
                listRandom = new ArrayList<>();
                listRandom = list;
                Collections.shuffle(listRandom);

                tvCauhoi.setText(listRandom.get(cauhientai).getNoidung());
                tvCau1.setText(listRandom.get(cauhientai).getA());
                tvCau2.setText(listRandom.get(cauhientai).getB());
                tvCau3.setText(listRandom.get(cauhientai).getC());
                tvCau4.setText(listRandom.get(cauhientai).getD());

                cauhientai+=1;
                tvCauhientai.setText(String.valueOf(cauhientai)+"/100");
            }

            @Override
            public void onFailure(Call<List<ModelTT>> call, Throwable t) {
                Toast.makeText(MainCauhoiActivity.this, "lỗi", Toast.LENGTH_SHORT).show();
                Log.e("ERRO", t.getMessage().toString());
            }
        });
    }
    private void chuyencau(TextView cau){
        String luachon = cau.getText().toString();
        String dapan = list.get(cauhientai-1).getDapan_dung();
        String b = String.valueOf(luachon.equals(dapan));
        if (luachon.equals(dapan)==false) {
            Toast.makeText(MainCauhoiActivity.this, "Rât tiếc.", Toast.LENGTH_SHORT).show();
            loadCauhoi();
            return;
        }
        Toast.makeText(MainCauhoiActivity.this, "Bạn đã chọn đáp án đúng.", Toast.LENGTH_SHORT).show();
        tvCauhoi.setText(listRandom.get(cauhientai).getNoidung());
        tvCau1.setText(listRandom.get(cauhientai).getA());
        tvCau2.setText(listRandom.get(cauhientai).getB());
        tvCau3.setText(listRandom.get(cauhientai).getC());
        tvCau4.setText(listRandom.get(cauhientai).getD());


        cauhientai+=1;
        tvCauhientai.setText(String.valueOf(cauhientai)+"/100");
        if (cauhientai==100){
            Toast.makeText(MainCauhoiActivity.this, "Bạn là nhà vô địch khi vượt qua 100 câu hỏi của hệ thống.", Toast.LENGTH_SHORT).show();
            cauhientai = 0;
            loadCauhoi();
        }
    }
}
