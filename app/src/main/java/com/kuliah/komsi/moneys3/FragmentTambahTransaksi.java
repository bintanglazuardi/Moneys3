package com.kuliah.komsi.moneys3;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTambahTransaksi extends Fragment {
    private TextView inputTanggal;
    ImageButton btnScan;

    public FragmentTambahTransaksi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tambah_transaksi, container, false);
        TextView inputtanggal = (TextView) view.findViewById(R.id.input_tanggal);
        inputtanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new FragmentDatePicker();
                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });

        btnScan = view.findViewById(R.id.scanNota);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getActivity(), ActivityScanNota.class);
                startActivity(mIntent);
            }
        });

        return view;
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);

        String dateMessage = (month_string + "/" + day_string + "/" + year_string);
        inputTanggal.setText(dateMessage);
    }

}
