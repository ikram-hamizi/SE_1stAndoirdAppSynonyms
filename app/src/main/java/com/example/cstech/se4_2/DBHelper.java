package com.example.cstech.se4_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by cstech on 3/22/18.
 */

public class DBHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DB";

    private static final String TABLE_NAME = "Synonyms";
    private static final String COLUMN_WORD = "WORD";
    private static final String COLUMN_SYN = "SYN";
    private static final String COLUMN_ID = "ID";

    private long rownInsert;
    SQLiteDatabase dict;

    private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY NOT NULL ,WORD TEXT NOT NULL ," +
            "SYN TEXT NOT NULL);"; //QUERY-1


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); //arg(4)
    }

    //2 ABSTRACT INHERITED METHODS
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.dict = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        dict.execSQL(query);
        this.onCreate(db);
    }

    //CREATE CUSTOM METHODS
    public void addWordSyn(WordSynTuple ws) {

        rownInsert = -1; //reset
        dict = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_WORD, ws.getWord()); //arg(KEY, VALUE)
        values.put(COLUMN_SYN, ws.getSyn());

        rownInsert = dict.insert(TABLE_NAME, null, values); //INSERT OBJECT TO DICT:DB

        dict.close();
    }

    public Toast rowAddedToast(Context context)
    {
        Toast row_added;
        if (rownInsert != -1)
            row_added = Toast.makeText(context, "Word/Synonym added successfully", Toast.LENGTH_SHORT);
        else
            row_added = Toast.makeText(context, "Word/Synonym was not added", Toast.LENGTH_SHORT);
        return row_added;
    }

    public boolean wordDoesExist(WordSynTuple ws) {
        return (searchTuple(ws));
    }

    private boolean searchTuple(WordSynTuple ws) {
        dict = this.getReadableDatabase();

        String query = "SELECT WORD, SYN FROM " + TABLE_NAME + ";";
        Cursor cursor = dict.rawQuery(query, null);

        String db_word, db_syn; //(0 for col 0) and (1 for col 1) in each row.

        if (cursor.moveToFirst() && cursor != null) {
            do {
                db_word = cursor.getString(0);
                db_syn = cursor.getString(1);
                if (ws.getWord().equalsIgnoreCase(db_word)) {
                    return true;
                }
            } while (cursor.moveToNext());
        }
        return false;
    }

    public String searchSyn(String word) {

        dict = this.getReadableDatabase();
        String query = "SELECT WORD, SYN FROM " + TABLE_NAME + ";";
        Cursor cursor = dict.rawQuery(query, null);

        String db_word, db_syn; //(0 for col 0) and (1 for col 1) in each row.
        if (cursor.moveToFirst() && cursor != null) {
            do {
                db_word = cursor.getString(0);
                db_syn = cursor.getString(1);
                if (word.equalsIgnoreCase(db_word)) {
                    return db_syn;
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return "Synonym for \""+word+"\" not found.";
    }
}