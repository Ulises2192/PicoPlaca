package com.example.picoyplaca.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.picoyplaca.PicoPlacaApplication;
import com.example.picoyplaca.R;
import com.example.picoyplaca.adapter.BitacoraAdapter;
import com.example.picoyplaca.db.PicoPlacaHelper;
import com.example.picoyplaca.models.BitacoraModel;
import com.example.picoyplaca.models.FilterType;

import java.util.ArrayList;
import java.util.List;

public class HistoricFragment extends Fragment {

    private static BitacoraAdapter adapter;
    private RecyclerView recyBitacora;
    private RecyclerView.LayoutManager lManager;
    private List<BitacoraModel> items = new ArrayList<>();

    private String fecha, placa;
    private boolean contravencion = false;

    public static EditText placaFilter;;
    public static FilterType filterType;
    public static boolean isSearchWithPrefix = false;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_historic, null);
        placaFilter= (EditText) view.findViewById(R.id.placa_filter);
        filterType = FilterType.NAME;

        initRecycler(view);
        filterPlaca();
        return view;
    }

    public void initRecycler(View view){

        recyBitacora = (RecyclerView) view.findViewById(R.id.recy_bitacora);
        recyBitacora.setHasFixedSize(true);
        lManager = new LinearLayoutManager(getContext());
        recyBitacora.setLayoutManager(lManager);
        getBitacora();

    }

    public void getBitacora(){
        items.clear();
        Cursor cursorMovie = PicoPlacaApplication.databaseManager.queryBitacora("fecha_consulta");

        while (!cursorMovie.isAfterLast()) {
            fecha = cursorMovie.getString(cursorMovie.getColumnIndex(PicoPlacaHelper.FECHA_CONSULTA));
            placa = cursorMovie.getString(cursorMovie.getColumnIndex(PicoPlacaHelper.PLACA));
            System.out.println("La fecha de consulta es " + fecha);

            items.add(new BitacoraModel(fecha, placa, contravencion));

            cursorMovie.moveToNext();
        }

        adapter = new BitacoraAdapter(items, getContext());
        recyBitacora.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public static void filterPlaca() {
        placaFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                adapter.filter(filterType, s.toString(), isSearchWithPrefix);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(filterType, s.toString(), isSearchWithPrefix);
            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.filter(filterType, s.toString(), isSearchWithPrefix);
            }
        });
    }
}
