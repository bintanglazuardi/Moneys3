package com.kuliah.komsi.moneys3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_transaksi.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "transaksi_table";
    public static final String COL_ID = "ID";
    public static final String COL_NAMA = "NAMA";
    public static final String COL_NOMINAL = "NOMINAL";
    public static final String COL_TANGGAL = "TANGGAL";
    public static final String COL_KATEGORI = "KATEGORI";
    public static final String COL_CATATAN = "CATATAN";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " +
                TABLE_NAME + " ( " +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAMA + " TEXT, " +
                COL_NOMINAL + " TEXT, " +
                COL_TANGGAL + " TEXT, " +
                COL_KATEGORI + " TEXT, " +
                COL_CATATAN + " TEXT )";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
