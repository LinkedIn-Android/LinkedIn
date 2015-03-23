package com.example.xiaotingli.linkedtest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.database.SQLException;
import android.widget.EditText;

/**
 * Created by xiaotingli on 3/22/15.
 */
public class UserOpenHelper extends SQLiteOpenHelper {

//    EditText email = (EditText)findViewById(R.id.emailAdd);
//    String userEmail = email.getText().toString();
//    EditText password = (EditText)findViewById(R.id.password);
//    String userPassword = password.getText().toString();

    private String email;
    private String password;

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "LinkedIn";
    private static final String USERS_TABLE_CREATE = "users";
    private SQLiteDatabase db;

    private static final String DATABASE_CREATE =
            "create table" + USERS_TABLE_CREATE + "(_id integer primary key autoincrement, "
                    + "email text not null,"
                    + "password text not null"
                    + ");";


    UserOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(USERS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor GetAllRows() {
        try {
            return db.query(USERS_TABLE_CREATE, new String[] {
                    "_id", "email", "password"}, null, null, null, null, null);
        } catch (SQLException e) {
            Log.e("Exception on query", e.toString());
            return null;
        }
    }
}