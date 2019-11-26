package com.kuliah.komsi.moneys3;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHalamanGrafik extends Fragment {
    PieChartView pieChartView;

    public FragmentHalamanGrafik() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_halaman_grafik, container, false);
        pieChartView = view.findViewById(R.id.chart);

        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(60, Color.BLUE).setLabel("50%"));
        pieData.add(new SliceValue(25, Color.GRAY).setLabel("15%"));
        pieData.add(new SliceValue(10, Color.RED).setLabel("10%"));
        pieData.add(new SliceValue(30, Color.MAGENTA).setLabel("25%"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(10);
        pieChartData.setHasCenterCircle(true).setCenterText1("Grafik").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);

        return view;




    }

}


