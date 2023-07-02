package org.Bincady.Inc.eduline;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class dbHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "credentials";
    private static final String STUDENT_ID = "student_id";
    private static final String PASSWORD = "pswrd";
    public dbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + STUDENT_ID +" TEXT,"
                + PASSWORD+ " TEXT)";
        db.execSQL(query);
    }

    public void insert(String id, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STUDENT_ID, id);
        values.put(PASSWORD, pass);
        db.insert(TABLE_NAME, null, values);
        db.close();

    }


    public List<String> read() {
        List<String> info = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        int id_index = cursor.getColumnIndex(STUDENT_ID);
        int password_index = cursor.getColumnIndex(PASSWORD);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            String getid = cursor.getString(id_index);
            String getpassword = cursor.getString(password_index);
            info.add(getid);
            info.add(getpassword);
            cursor.moveToNext();
        }
        cursor.close();

        return info;
    }
    public void reset(){
        SQLiteDatabase db = this.getWritableDatabase();
        onUpgrade(db,1,1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
