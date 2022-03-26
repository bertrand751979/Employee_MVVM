package com.example.employee_mvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.employee_mvvm.models.Employee;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Query("SELECT*FROM employee")
    LiveData<List<Employee>> getEmployees();


    @Insert
    void insertEmployee(Employee employee);


    @Delete
    void deleteEmployee (Employee employee);

}
