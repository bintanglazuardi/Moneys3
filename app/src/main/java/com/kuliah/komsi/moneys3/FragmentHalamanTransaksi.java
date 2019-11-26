package com.kuliah.komsi.moneys3;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHalamanTransaksi extends Fragment {
    private ImageButton tambahTransaksi;
    private Spinner spinnerTahun, spinnerBulan;

    public FragmentHalamanTransaksi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View view = inflater.inflate(R.layout.fragment_halaman_transaksi, container, false);

        tambahTransaksi = view.findViewById(R.id.tambah_transaksi);
        tambahTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getActivity(), ActivityTambahTransaksi.class);
                startActivity(mIntent);

            }
        });
        spinnerBulan = view.findViewById(R.id.bulan_spinner);
        ArrayAdapter<CharSequence> adapterTahun = ArrayAdapter.createFromResource
                (getActivity(),R.array.tahun_array, R.layout.spinner_item);
        adapterTahun.setDropDownViewResource(
                R.layout.spinner_item);

        /*if (spinnerTahun != null){
            spinnerTahun.setOnItemSelectedListener(getActivity());
        }*/

        spinnerBulan = view.findViewById(R.id.bulan_spinner);
        ArrayAdapter<CharSequence> adapterBulan = ArrayAdapter.createFromResource
                (getActivity(),R.array.bulan_array, R.layout.spinner_item);
        adapterBulan.setDropDownViewResource(
                R.layout.spinner_item);

        /*if (spinnerBulan != null){
            spinnerBulan.setOnItemSelectedListener(getActivity());
        }*/

        return view;
    }

}
