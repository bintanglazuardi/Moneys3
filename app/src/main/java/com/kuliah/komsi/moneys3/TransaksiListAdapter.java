package com.kuliah.komsi.moneys3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TransaksiListAdapter extends ArrayAdapter<Transaksi> {
    private LayoutInflater mInflater;
    private List<Transaksi> mTransaksi = null;
    private ArrayList<Transaksi> arrayList;
    private int layoutResource;
    private Context mContext;;
    private String mAppend;

    public TransaksiListAdapter(@NonNull Context context, int resource, @NonNull List<Transaksi> transaksis, String append) {
        super(context, resource, transaksis);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutResource = resource;
        this.mContext = context;
        mAppend = append;
        this.mTransaksi = transaksis;
    }

    private static class ViewHolder{
        TextView nama;
        TextView tanggal;
        TextView nominal;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null){
            convertView = mInflater.inflate(layoutResource, parent,false);
            holder = new ViewHolder();
            holder.nama = (TextView) convertView.findViewById(R.id.tv_item_nama);
            holder.tanggal = (TextView) convertView.findViewById(R.id.tv_item_tanggal);
            holder.nominal = (TextView) convertView.findViewById(R.id.tv_item_biaya);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        String nama_ = getItem(position).getNama();
        String tanggal_ = getItem(position).getTanggal();
        String nominal_ = getItem(position).getNominal();
        holder.nama.setText(nama_);
        holder.nominal.setText(nominal_);
        holder.tanggal.setText(tanggal_);

        return convertView;
    }

    public void filter(String characterText){
        characterText = characterText.toLowerCase(Locale.getDefault());
        mTransaksi.clear();
        if( characterText.length() == 0){
            mTransaksi.addAll(arrayList);
        }
        else{
            mTransaksi.clear();
            for(Transaksi contact: arrayList){
                mTransaksi.add(contact);
            }
        }
        notifyDataSetChanged();
    }
}
