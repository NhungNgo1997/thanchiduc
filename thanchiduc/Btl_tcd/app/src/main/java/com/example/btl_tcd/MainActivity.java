package com.example.btl_tcd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.btl_tcd.model.ModelTT;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnChoingay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyenman();
            }
        });

    }
    private void  chuyenman(){
        Intent intent = new Intent(this, MainCauhoiActivity.class);
        startActivity(intent);
    }

}
