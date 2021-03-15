package com.example.simplesignup;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class LifeCycleActivity extends AppCompatActivity {

    private static final String TAG =LifeCycleActivity.class.getSimpleName() ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.i(TAG ,"ON CREATE");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG ,"ON START");

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG ,"ON RESUME");

    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG ,"ON PAUSE");

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG ,"ON DESTROY");

    }

}