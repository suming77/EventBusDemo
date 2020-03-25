package com.sum.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_normal).setOnClickListener(this);
        findViewById(R.id.btn_stick).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_normal://普通使用
                startActivity(new Intent(this, OneActivity.class));
                break;
            case R.id.btn_stick://AndroidEventBus
                startActivity(new Intent(this, AndroidEventBusReceiveActivity.class));
                break;
            default:
                break;
        }
    }
}
