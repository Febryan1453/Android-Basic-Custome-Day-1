package com.febryan.implicitdanexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.febryan.implicitdanexplicitintent.databinding.ActivityMoveDataBinding;

public class MoveDataActivity extends AppCompatActivity {

    private ActivityMoveDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMoveDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String nama = getIntent().getStringExtra("nama");
        int umur = getIntent().getIntExtra("umur",0);
        double tinggi = getIntent().getDoubleExtra("tinggi",0.0);

        binding.tvNama.setText(nama);
        binding.tvUmur.setText(String.valueOf(umur));
        binding.tvTinggi.setText(String.valueOf(tinggi));

    }
}