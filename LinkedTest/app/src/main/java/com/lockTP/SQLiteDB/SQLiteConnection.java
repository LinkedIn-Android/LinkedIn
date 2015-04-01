package com.lockTP.SQLiteDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Weichuan on 3/23/2015.
 */
public class SQLiteConnection extends SQLiteOpenHelper{

    public SQLiteConnection(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists stutb(_id integer primary key autoincrement, name text not null, sex text not null, age integer not null)");
        db.execSQL("insert into stutb(name,sex,age) values('Peter', 'Male', 25)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
