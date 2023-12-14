package com.example.cardview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "allCardValues.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "sensorValueTable";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_lIGHT_SENSOR = "light_value";
    public static final String COLUMN_PROXIMITY_SENSOR = "proximity_value";
    public static final String COLUMN_ACCELEROMETER = "accelerometer_value";
    public static final String COLUMN_GYROSCOPE = "gyroscope_value";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_lIGHT_SENSOR + " TEXT, " +
                COLUMN_PROXIMITY_SENSOR + " TEXT, " +
                COLUMN_ACCELEROMETER + " TEXT, " +
                COLUMN_GYROSCOPE + " TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
