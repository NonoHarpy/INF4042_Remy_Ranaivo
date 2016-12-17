package org.esiea.remy_ranaivo.projet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by nora on 07/11/16.
 */

public class BeerDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + BeerEntry.TABLE_NAME + " (" +
                    BeerEntry._ID + " INTEGER PRIMARY KEY," +
                    BeerEntry.CBEERNAME + TEXT_TYPE + COMMA_SEP +
                    BeerEntry.CDESC + TEXT_TYPE + " )";

    //Constructeur
    public BeerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public static class BeerEntry implements BaseColumns {
        public static final String TABLE_NAME = "beer_entry";
        public static final String CBEERNAME= "beer_name";
        public static final String CDESC = "beer_description";
    }

}
