package com.example.tornado;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Dish.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DishDao dishDao();
}
