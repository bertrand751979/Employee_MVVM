package com.example.employee_mvvm.viewModels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.employee_mvvm.models.Employee;
import com.example.employee_mvvm.repository.EmployeeRepository;

import java.util.List;

public class DisplayFragmentViewModel extends ViewModel {
    public LiveData<List<Employee>> getEmployees (Context context){
        return EmployeeRepository.getInstance().getEmployees(context);
    }



    public void addEmployee(Employee employee, Context context){
        EmployeeRepository.getInstance().addEmployee(employee,context);
    }


    public void deleteEmployee(Employee employee, Context context){
        EmployeeRepository.getInstance().deleteEmployee(employee, context);

    }



}
