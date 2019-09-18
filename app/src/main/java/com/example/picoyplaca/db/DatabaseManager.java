package com.example.picoyplaca.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DatabaseManager {
    private static DatabaseManager sInstance;
    private SQLiteDatabase database;
    private PicoPlacaHelper mPicoPlacaHelper;

    private DatabaseManager(Context context) {
        mPicoPlacaHelper = new PicoPlacaHelper(context);
        database = mPicoPlacaHelper.getWritableDatabase();
    }

    public static synchronized DatabaseManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseManager(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Return a {@link Cursor} that contains every planet in the database.
     *
     * @param sortOrder Optional sort order string for the query, can be null
     * @return {@link Cursor} containing all planet results.
     */
    public Cursor queryBitacora(String orderBy) {
        //TODO: Implement the query
        Cursor cursor = database.query(PicoPlacaHelper.TABLE_BITACORA, null, null, null, null, null, orderBy + " DESC");
        if (cursor != null) {
            cursor.moveToFirst();
            return cursor;
        } else {
            return null;
        }
    }


    public void inserBitacora(String placa, String fechaConsulta, boolean contravecion) {

        ContentValues contentValue = new ContentValues();
        contentValue.put(PicoPlacaHelper.PLACA, placa);
        contentValue.put(PicoPlacaHelper.FECHA_CONSULTA, fechaConsulta);
        contentValue.put(PicoPlacaHelper.CONTRAVENCION, contravecion);

        database.insert(PicoPlacaHelper.TABLE_BITACORA, null, contentValue);
    }






}