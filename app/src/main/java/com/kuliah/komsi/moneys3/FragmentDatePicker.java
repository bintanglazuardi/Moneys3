package com.kuliah.komsi.moneys3;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    //TextView inputtanggal= (TextView)getActivity(). findViewById(R.id.input_tanggal);

    public FragmentDatePicker() {
        // Required empty public constructor
    }


    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        ActivityTambahTransaksi activity = (ActivityTambahTransaksi) getActivity();
        activity.processDatePickerResult(year, month, day);
    }

}
