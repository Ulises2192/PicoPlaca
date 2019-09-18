package com.example.picoyplaca.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PicoPlacaHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PicoPlaca";

    // TABLAS
    public static final String TABLE_BITACORA = "t_bitacora";


    // ATRIBUTOS
    public static final String PK = "pk";
    public static final String PLACA = "placa";
    public static final String FECHA_CONSULTA = "fecha_consulta";
    public static final String CONTRAVENCION = "contravencion";



    private static final String CREATE_TABLE_BITACORA = "CREATE TABLE IF NOT EXISTS " +
            TABLE_BITACORA + "(" +
            PK + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PLACA + " TEXT, " +
            FECHA_CONSULTA + " DATE, " +
            CONTRAVENCION + " BOOLEAN);";


    private Context mcontext;

    public PicoPlacaHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BITACORA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BITACORA);
        onCreate(db);
    }
}
