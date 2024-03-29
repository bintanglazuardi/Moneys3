package com.kuliah.komsi.moneys3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTambahTransaksi extends AppCompatActivity {
    private Button btnScan;
    private TextView inputTanggal;
    private EditText inputNama, inputNominal, inputCatatan;
    private Spinner inputKategori;
    private ListView transaksiList;


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
        inputNama = findViewById(R.id.input_nama);
        inputNominal = findViewById(R.id.input_nominal);
        inputTanggal = findViewById(R.id.input_tanggal);
        inputKategori = findViewById(R.id.input_kategori);
        inputCatatan = findViewById(R.id.input_catatan);

    }

    private boolean checkStringIfNull(String string){
        if (string.equals("")){
            return false;
        }else {
            return true;
        }
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
            if (checkStringIfNull(inputNama.getText().toString())){
                DatabaseHelper databaseHelper = new DatabaseHelper(this);
                Transaksi transaksi = new Transaksi(inputNama.getText().toString(),
                        inputNominal.getText().toString(),
                        inputTanggal.getText().toString(),
                        inputKategori.getSelectedItem().toString(),
                        inputCatatan.getText().toString());
                if (databaseHelper.addTransaksi(transaksi)){
                    Toast.makeText(this, "Data Disimpan", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }else{
                    Toast.makeText(this, "Error: Gagal menyimpan data", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
            }
        }
        return true;
    }

    public void ShowDatePickerDialog(View v) {
        DialogFragment newFragment = new FragmentDatePicker();
        newFragment.show(getSupportFragmentManager(), "Date Picker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string="default";
        if (month+1%12==1){
            month_string = "Januari";
        }else if(month+1%12==2){
            month_string = "Februari";
        }else if(month+1%12==3){
            month_string = "Maret";
        }else if(month+1%12==4){
            month_string = "April";
        }else if(month+1%12==5){
            month_string = "Mei";
        }else if(month+1%12==6){
            month_string = "Juni";
        }else if(month+1%12==7){
            month_string = "Juli";
        }else if(month+1%12==8){
            month_string = "Agustus";
        }else if(month+1%12==9){
            month_string = "September";
        }else if(month+1%12==10){
            month_string = "Oktober";
        }else if(month+1%12==11){
            month_string = "November";
        }else if(month+1%12==12){
            month_string = "Desember";
        }

        //month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);

        String dateMessage = (day_string + " " + month_string + " " + year_string);
        //Toast.makeText(this, dateMessage, Toast.LENGTH_SHORT).show();
        inputTanggal.setText(dateMessage);
    }


}