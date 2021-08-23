package com.febryan.implicitdanexplicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.febryan.implicitdanexplicitintent.databinding.ActivityInputDataBinding;

public class InputDataActivity extends AppCompatActivity {

    private ActivityInputDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInputDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvAdd.setOnClickListener(v -> {
            Intent intent = new Intent(InputDataActivity.this, FormInputActivity.class);
            startActivityForResult(intent, 200);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 200){
            if (resultCode == 300){

                String nama = data.getStringExtra("nama");
                String alamat = data.getStringExtra("alamat");
                String umur = data.getStringExtra("umur");
                String telp = data.getStringExtra("telp");
                String jk = data.getStringExtra("jk");
                String pend = data.getStringExtra("pend");

                binding.tvNama.setText(nama);
                binding.tvAlamat.setText(alamat);
                binding.tvUmur.setText(umur);
                binding.tvTelp.setText(telp);
                binding.tvGender.setText(jk);
                binding.tvPend.setText(pend);

                binding.btnTelpon.setVisibility(View.VISIBLE);
                binding.btnTelpon.setText("Hubungi "+ nama);
                binding.btnTelpon.setOnClickListener(v -> {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+ telp));
                    startActivity(intent);
                });

            }
        }

    }
}