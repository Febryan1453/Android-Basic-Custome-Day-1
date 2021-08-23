package com.febryan.implicitdanexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.febryan.implicitdanexplicitintent.databinding.ActivityFormInputBinding;

public class FormInputActivity extends AppCompatActivity {

    private ActivityFormInputBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String [] pend = {"SMA", "S1", "S2", "S3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, pend);

        binding.spinPendidikan.setAdapter(adapter);

        binding.btnSave.setOnClickListener(v -> {

            String nama = binding.tvNama.getText().toString();
            String alamat = binding.tvAlamat.getText().toString();
            String umur = binding.tvUmur.getText().toString();
            String telp = binding.tvTelp.getText().toString();
            String gender = binding.cowo.isChecked() ? "Pria" : "Wanita";
            String pendidikan = binding.spinPendidikan.getSelectedItem().toString();

            if (nama.isEmpty() || alamat.isEmpty() || umur.isEmpty() || gender.isEmpty() || pendidikan.isEmpty() || telp.isEmpty()){
                Toast.makeText(FormInputActivity.this, "Lengkapi Data", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent();
            intent.putExtra("nama", nama);
            intent.putExtra("alamat", alamat);
            intent.putExtra("umur", umur);
            intent.putExtra("telp", telp);
            intent.putExtra("jk", gender);
            intent.putExtra("pend", pendidikan);

            setResult(300,intent);
            finish(); // Destroy Activity Form input supaya ga kebuka lagi ketika back

        });

    }
}