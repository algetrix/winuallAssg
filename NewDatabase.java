package com.example.Assignment;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

@Database(entities = {Entity.class},version = 1,exportSchema = false)
public abstract class NewDatabase extends RoomDatabase {

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "favouritedata.db";
    private static NewDatabase instance;

    public static NewDatabase getInstance(Context context) {
        if (instance == null) {
            //only one instance at a time
            synchronized (LOCK) {

                instance = Room.databaseBuilder(context.getApplicationContext(),
                        NewDatabase.class,
                        NewDatabase.DATABASE_NAME)
                        //no task allowed in background thread
                        .allowMainThreadQueries()
                        .build();
            }
        }
        //to know that database is being instantiating
        Log.d("database","getting database instance");

        return instance;
    }

    public abstract FavouriteDao favouriteDao();

}
