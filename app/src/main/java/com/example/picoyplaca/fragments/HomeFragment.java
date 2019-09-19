package com.example.picoyplaca.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.danimahardhika.cafebar.CafeBar;
import com.example.picoyplaca.PicoPlacaApplication;
import com.example.picoyplaca.R;
import com.example.picoyplaca.utils.Constants;
import com.example.picoyplaca.utils.DateHelper;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btnConsultar, btnClear;
    private EditText numberPlaca;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, null);
        btnConsultar = (Button) view.findViewById(R.id.btn_consultar);
        btnClear = (Button) view.findViewById(R.id.btn_clear);
        numberPlaca = (EditText) view.findViewById(R.id.edit_placa);
        btnConsultar.setOnClickListener(this);
        btnClear.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_consultar:
                hideSoftKeyboard();
                if (!numberPlaca.getText().toString().trim().isEmpty()){
                    comparePlaca(numberPlaca.getText().toString().trim());
                } else {
                    alertDialog(getResources().getString(R.string.no_input), getResources().getColor(R.color.alert_warnign));
                }

                break;

            case R.id.btn_clear:
                numberPlaca.setText("");
                break;
        }
    }

    public void comparePlaca(String numberPlaca){

        int ultimo = 0;
        isInteger(numberPlaca.substring(numberPlaca.length() - 1));

        if (isInteger(numberPlaca.substring(numberPlaca.length() - 1))) {
            ultimo = Integer.parseInt(numberPlaca.substring(numberPlaca.length() - 1));
            if (DateHelper.intoOfRangeMorning(DateHelper.getHour()) || DateHelper.intoOfRangeEvening(DateHelper.getHour())){

                switch (DateHelper.getDay()){
                    case Constants.DAY_OF_WEEK.MONDAY:
                        if (ultimo == 1 || ultimo == 2){
                            alertDialog(getResources().getString(R.string.no_circula), getResources().getColor(R.color.alert_fail));
                            PicoPlacaApplication.databaseManager.inserBitacora(numberPlaca,DateHelper.getDate(), true);
                        } else {
                            alertDialog(getResources().getString(R.string.circula), getResources().getColor(R.color.alert_ok));
                        }
                        break;

                    case Constants.DAY_OF_WEEK.TUESDAY:
                        if (ultimo == 3 || ultimo == 4){
                            alertDialog(getResources().getString(R.string.no_circula), getResources().getColor(R.color.alert_fail));
                            PicoPlacaApplication.databaseManager.inserBitacora(numberPlaca,DateHelper.getDate(), true);
                        } else {
                            alertDialog(getResources().getString(R.string.circula), getResources().getColor(R.color.alert_ok));
                        }
                        break;

                    case Constants.DAY_OF_WEEK.WEDNESDAY:
                        if (ultimo == 5 || ultimo == 6){
                            alertDialog(getResources().getString(R.string.no_circula), getResources().getColor(R.color.alert_fail));
                            PicoPlacaApplication.databaseManager.inserBitacora(numberPlaca,DateHelper.getDate(), true);

                        } else {
                            alertDialog(getResources().getString(R.string.circula), getResources().getColor(R.color.alert_ok));
                        }
                        break;

                    case Constants.DAY_OF_WEEK.THURSDAY:
                        if (ultimo == 7 || ultimo == 8){
                            alertDialog(getResources().getString(R.string.no_circula), getResources().getColor(R.color.alert_fail));
                            PicoPlacaApplication.databaseManager.inserBitacora(numberPlaca,DateHelper.getDate(), true);
                        } else {
                            alertDialog(getResources().getString(R.string.circula), getResources().getColor(R.color.alert_ok));
                        }
                        break;

                    case Constants.DAY_OF_WEEK.FRIDAY:
                        if (ultimo == 9 || ultimo == 0){
                            alertDialog(getResources().getString(R.string.no_circula), getResources().getColor(R.color.alert_fail));
                            PicoPlacaApplication.databaseManager.inserBitacora(numberPlaca,DateHelper.getDate(), true);
                        } else {
                            alertDialog(getResources().getString(R.string.circula), getResources().getColor(R.color.alert_ok));

                        }
                        break;

                    case Constants.DAY_OF_WEEK.SATURDAY:
                        alertDialog(getResources().getString(R.string.circula), getResources().getColor(R.color.alert_ok));

                        break;

                    case Constants.DAY_OF_WEEK.SUNDAY:
                        alertDialog(getResources().getString(R.string.circula), getResources().getColor(R.color.alert_ok));

                        break;
                }
            } else {
                alertDialog(getResources().getString(R.string.circula), getResources().getColor(R.color.alert_ok));

            }

        }else {
            alertDialog(getResources().getString(R.string.circula), getResources().getColor(R.color.alert_ok));

        }

    }

    public boolean isInteger(String numero){
        try{
            Integer.parseInt(numero);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public void alertDialog(String message, int color) {
        CafeBar.Builder builder = new CafeBar.Builder(getContext())
                .customView(R.layout.snack_dialog)
                .fitSystemWindow()
                .autoDismiss(true);

        final CafeBar cafeBar = builder.build();
        View v = cafeBar.getView();

        @SuppressLint("WrongViewCast") AppCompatTextView txtMsj = (AppCompatTextView) v.findViewById(R.id.txtMsj);
        @SuppressLint("WrongViewCast") LinearLayout linear = (LinearLayout) v.findViewById(R.id.linear);
        txtMsj.setText(message);
        linear.setBackgroundColor(color);

        cafeBar.show();
    }

    private void hideSoftKeyboard(){
        try {
            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
