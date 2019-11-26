package com.kuliah.komsi.moneys3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityTambahTransaksi extends AppCompatActivity {
    private Button btnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_transaksi);
        ActivityTambahTransaksi.this.setTitle("Tambah Transaksi");

        btnScan = findViewById(R.id.scanNota);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scanPage = new Intent(ActivityTambahTransaksi.this, ActivityScanNota.class);
                startActivity(scanPage);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.save){
            Toast.makeText(this, "Data Disimpan", Toast.LENGTH_SHORT).show();
            onBackPressed();
//            startActivity(new Intent(this, MainActivity.class));
        }
        return true;
    }

    /*public void scanNota(View view) {
        Intent scanPage = new Intent(ActivityTambahTransaksi.this, ActivityScanNota.class);
        startActivity(scanPage);
    }*/


}