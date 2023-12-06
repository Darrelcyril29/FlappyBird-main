package com.example.test.Data.Entity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.test.Data.Entity.Skin;
import com.example.test.Data.Entity.UserDAO;
import com.example.test.Data.Entity.User;
@Database(entities = {User.class,Skin.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {


    public abstract UserDAO userDao();
    public abstract SkinDAO skinDao();
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "App-Database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
