// SQLiteAssetHelper subclass that defines the app's database of DSObjects

package com.mikesrv9a.nightskyguide;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DSObjectDatabaseHelper extends SQLiteAssetHelper{
    private static final String DATABASE_NAME = "DSObjects.db";
    private static final int DATABASE_VERSION = 4;

    public static String KEY_ID = "_id";
    public static String KEY_OBJECT = "object";
    public static String KEY_TYPE = "type";
    public static String KEY_MAGNITUDE = "mag";
    public static String KEY_SIZE = "size";
    public static String KEY_DISTANCE = "distance";
    public static String KEY_RA = "ra";
    public static String KEY_DEC = "dec";
    public static String KEY_CONSTELLATION = "const";
    public static String KEY_NAME = "name";
    public static String KEY_PSA = "psa";
    public static String KEY_OITH = "oith";
    public static String KEY_CATALOGUE = "catalogue";
    public static String KEY_SKYATLAS = "skyatlas";

    // constructor
    public DSObjectDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade(DATABASE_VERSION);
    }

    public Cursor getDSObjects() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {
                KEY_ID,
                KEY_OBJECT,
                KEY_TYPE,
                KEY_MAGNITUDE,
                KEY_SIZE,
                KEY_DISTANCE,
                KEY_RA,
                KEY_DEC,
                KEY_CONSTELLATION,
                KEY_NAME,
                KEY_PSA,
                KEY_OITH,
                KEY_CATALOGUE,
                KEY_SKYATLAS
        };
        String sqlTables = "dsObjects";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);
        c.moveToFirst();
        return c;
    }

    // only used to refresh database (after version error) - not normal function for app
    public static void forceDatabaseReload(Context context) {
        DSObjectDatabaseHelper dbHelper = new DSObjectDatabaseHelper(context);
        dbHelper.setForcedUpgrade(DATABASE_VERSION);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.setVersion(-1);
        db.close();
        dbHelper.getWritableDatabase();
    }
}
