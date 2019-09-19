package com.example.picoyplaca.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.picoyplaca.R;
import com.example.picoyplaca.models.BitacoraModel;
import com.example.picoyplaca.models.FilterType;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BitacoraAdapter extends RecyclerView.Adapter<BitacoraAdapter.BitacoraViewHolder> implements View.OnClickListener {
    private List<BitacoraModel> items;
    private Context context;
    private View.OnClickListener listener;
    private ArrayList<BitacoraModel> filterArrayList;

    public BitacoraAdapter(List<BitacoraModel> items, Context context) {
        this.items = items;
        this.context = context;

        this.filterArrayList = new ArrayList<>();
        this.filterArrayList.addAll(items);
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
        viewHolder.txtPlaca.setText(items.get(i).getNumeroPlaca());
        viewHolder.txtFecha.setText(items.get(i).getFechaConsulta());

        int ultimo_valor = Integer.parseInt(items.get(i).getNumeroPlaca().substring(items.get(i).getNumeroPlaca().length() - 1));

        switch (ultimo_valor){
            case 1:
                viewHolder.txtLu.setTextColor(context.getResources().getColor(R.color.alert_fail));
                break;
            case 2:
                viewHolder.txtLu.setTextColor(context.getResources().getColor(R.color.alert_fail));
                break;
            case 3:
                viewHolder.txtMa.setTextColor(context.getResources().getColor(R.color.alert_fail));
                break;
            case 4:
                viewHolder.txtMa.setTextColor(context.getResources().getColor(R.color.alert_fail));
                break;
            case 5:
                viewHolder.txtMi.setTextColor(context.getResources().getColor(R.color.alert_fail));
                break;
            case 6:
                viewHolder.txtMi.setTextColor(context.getResources().getColor(R.color.alert_fail));
                break;
            case 7:
                viewHolder.txtJu.setTextColor(context.getResources().getColor(R.color.alert_fail));
                break;
            case 8:
                viewHolder.txtJu.setTextColor(context.getResources().getColor(R.color.alert_fail));
                break;
            case 9:
                viewHolder.txtVi.setTextColor(context.getResources().getColor(R.color.alert_fail));
                break;
            case 0:
                viewHolder.txtVi.setTextColor(context.getResources().getColor(R.color.alert_fail));
                break;
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }

    public void filter(FilterType filterType, String charText, boolean isSearchWithPrefix) {
        if (filterType == FilterType.NAME || filterType == FilterType.ESTADO)
            charText = charText.toLowerCase(Locale.getDefault());
        items.clear();
        if (charText.length() == 0) {
            items.addAll(filterArrayList);
        } else {
            for (BitacoraModel model : filterArrayList) {
                switch (filterType) {
                    case NAME:
                        if (model.getNumeroPlaca().toLowerCase(Locale.getDefault()).contains(charText))
                            items.add(model);
                        break;
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class BitacoraViewHolder extends RecyclerView.ViewHolder {

        public TextView txtPlaca, txtFecha, txtLu, txtMa, txtMi, txtJu, txtVi, txtSa, txtDo;

        public BitacoraViewHolder(View v) {
            super(v);
            txtPlaca = (TextView) v.findViewById(R.id.txt_placa);
            txtFecha = (TextView) v.findViewById(R.id.txt_fecha);

            txtLu = (TextView) v.findViewById(R.id.txt_lu);
            txtMa = (TextView) v.findViewById(R.id.txt_ma);
            txtMi = (TextView) v.findViewById(R.id.txt_mi);
            txtJu = (TextView) v.findViewById(R.id.txt_ju);
            txtVi = (TextView) v.findViewById(R.id.txt_vi);
            txtSa = (TextView) v.findViewById(R.id.txt_sa);
            txtDo = (TextView) v.findViewById(R.id.txt_do);
        }
    }
}
