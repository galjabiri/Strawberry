package com.otb.strawberryroad;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Mobile.class},version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract mobileDao mobileDao();
}
