package com.kuliah.komsi.moneys3;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

import com.kuliah.komsi.moneys3.TransaksiListAdapter;
import com.kuliah.komsi.moneys3.DatabaseHelper;
import com.kuliah.komsi.moneys3.Transaksi;



/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHalamanTransaksi extends Fragment {

    public interface OnTransaksiSelectedListener{
        public void OnTransaksiSelected(Transaksi transaksi);
    }
    OnTransaksiSelectedListener mTransaksiListener;

    public interface OnAddTransaksiListener{
        public void onAddTransaksi();
    }
    OnAddTransaksiListener mOnAddTransaksi;

    private ImageButton tambahTransaksi;
    private Spinner spinnerTahun, spinnerBulan;
    private TransaksiListAdapter adapter;
    private ListView transaksiList;

    public FragmentHalamanTransaksi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View view = inflater.inflate(R.layout.fragment_halaman_transaksi, container, false);
        transaksiList = (ListView) view.findViewById(R.id.list_transaksi);
        setupTransaksiList();

        tambahTransaksi = view.findViewById(R.id.tambah_transaksi);
        tambahTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mOnAddTransaksi.onAddTransaksi();       //bikin error
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

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            mTransaksiListener = (OnTransaksiSelectedListener) getActivity();
            mOnAddTransaksi = (OnAddTransaksiListener) getActivity();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach: ClassCastException: " + e.getMessage() );
        }
    }

    private void setupTransaksiList(){
        final ArrayList<Transaksi> transaksis = new ArrayList<>();
        transaksis.add(new Transaksi("KFC", "50000", "22 November 2019", "Makanan", "Hedon"));
        transaksis.add(new Transaksi("KFC", "50000", "22 November 2019", "Makanan", "Hedon"));
        transaksis.add(new Transaksi("KFC", "50000", "22 November 2019", "Makanan", "Hedon"));
        transaksis.add(new Transaksi("KFC", "50000", "22 November 2019", "Makanan", "Hedon"));
        transaksis.add(new Transaksi("KFC", "50000", "22 November 2019", "Makanan", "Hedon"));
        transaksis.add(new Transaksi("KFC", "50000", "22 November 2019", "Makanan", "Hedon"));


        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
        Cursor cursor = databaseHelper.getAllTransaksis();

        if (!cursor.moveToNext()){
            Toast.makeText(getActivity(), "Tidak ada data untuk ditampilkan", Toast.LENGTH_SHORT).show();
        }
        while (cursor.moveToNext()){
            transaksis.add(new Transaksi(
                    cursor.getString(1),//nama
                    cursor.getString(2),//nominal
                    cursor.getString(3),//tanggal
                    cursor.getString(4),//kategori
                    cursor.getString(5)//catatan
            ));
        }

        adapter = new TransaksiListAdapter(getActivity(), R.layout.item_transaksi,transaksis,"");
        transaksiList.setAdapter(adapter);
        transaksiList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                mTransaksiListener.OnTransaksiSelected(transaksis.get(position));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
