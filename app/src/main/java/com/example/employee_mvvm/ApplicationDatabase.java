package com.example.employee_mvvm;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.employee_mvvm.models.Employee;

import java.util.ArrayList;

@Database(entities = {Employee.class}, version =1)
public abstract class ApplicationDatabase extends RoomDatabase {

    private static ApplicationDatabase INSTANCE;
    public abstract EmployeeDao getEmployeeDao();



    public static synchronized ApplicationDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),ApplicationDatabase.class,"employee_app").build();
        }
        return INSTANCE;
    }
}
