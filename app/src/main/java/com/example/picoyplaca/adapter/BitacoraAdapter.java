package com.example.picoyplaca.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.picoyplaca.R;
import com.example.picoyplaca.models.BitacoraModel;

import java.util.List;

public class BitacoraAdapter extends RecyclerView.Adapter<BitacoraAdapter.BitacoraViewHolder> implements View.OnClickListener {
    private List<BitacoraModel> items;
    private Context context;
    private View.OnClickListener listener;


    public BitacoraAdapter(List<BitacoraModel> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public BitacoraViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_bitacora, viewGroup, false);

        v.setOnClickListener(this);

        return new BitacoraViewHolder(v);

    }

    @Override
    public void onBindViewHolder(BitacoraViewHolder viewHolder, final int i) {

        String placa = items.get(i).getNumeroPlaca();
        String fecha = items.get(i).getFechaConsulta();

        viewHolder.txtPlaca.setText(placa);
        viewHolder.txtFecha.setText(fecha);

    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }


    public static class BitacoraViewHolder extends RecyclerView.ViewHolder {

        public TextView txtPlaca, txtFecha;

        public BitacoraViewHolder(View v) {
            super(v);

            txtPlaca = (TextView) v.findViewById(R.id.txt_placa);
            txtFecha = (TextView) v.findViewById(R.id.txt_fecha);

        }
    }
}
