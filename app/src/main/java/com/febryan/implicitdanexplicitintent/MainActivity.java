package com.febryan.implicitdanexplicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    //Implicit Intent = Tujuannya Jelas
    //Explicit Intent = Tujuannya belum jelas

    public void move(View view) {
        startActivity(new Intent(MainActivity.this, MoveActivity.class));
    }

    public void moveData(View view) {

        String nama = "Angga";
        int umur = 20;
        double tinggi = 160.5;

        Intent intent = new Intent(MainActivity.this, MoveDataActivity.class);
        intent.putExtra("nama", nama);
        intent.putExtra("umur", umur);
        intent.putExtra("tinggi", tinggi);
        startActivity(intent);

    }

    public void inputData(View view) {
        startActivity(new Intent(MainActivity.this, InputDataActivity.class));
    }
}