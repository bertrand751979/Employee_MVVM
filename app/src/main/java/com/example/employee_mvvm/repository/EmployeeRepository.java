package com.example.employee_mvvm.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Adapter;

import androidx.lifecycle.LiveData;

import com.example.employee_mvvm.ApplicationDatabase;
import com.example.employee_mvvm.adapter.AdapterEmployee;
import com.example.employee_mvvm.fragments.DisplayFragment;
import com.example.employee_mvvm.fragments.MyAlertDialogFragment;
import com.example.employee_mvvm.models.Employee;
import com.example.employee_mvvm.viewModels.DisplayFragmentViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import kotlin.collections.ArrayDeque;

public class EmployeeRepository {
    int sum=0;
    private ArrayList<Employee> searchList;
    public AdapterEmployee employeeAdapter;
    public ArrayList<Employee> listAdapterBis;


    private EmployeeRepository(){}
    private static EmployeeRepository INSTANCE = null;
    public static EmployeeRepository getInstance(){
        if(INSTANCE == null){
            INSTANCE = new EmployeeRepository();
        }
        return INSTANCE;
    }

    public ArrayList<Employee> getListAdapterBis() {
        return listAdapterBis;
    }

    public void setListAdapterBis(ArrayList<Employee> listAdapterBis) {
        this.listAdapterBis = listAdapterBis;
    }

    public ArrayList<Employee> getSearchList() {
        return searchList;
    }

    public void setSearchList(ArrayList<Employee> searchList) {
        this.searchList = searchList;
    }

    public void addEmployee(Employee employee, Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDatabase.getInstance(context).getEmployeeDao().insertEmployee(employee);
            }
        });
    }



    public void deleteEmployee(Employee employee,Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDatabase.getInstance(context).getEmployeeDao().deleteEmployee(employee);
            }
        });

    }

    public LiveData<List<Employee>> getEmployees(Context context){
        return ApplicationDatabase.getInstance(context).getEmployeeDao().getEmployees();
    }

    public int moyWages(){
        int compteur=0;
        int sumWages =0;
        for(Employee employee:EmployeeRepository.getInstance().getListAdapterBis()){
            compteur = compteur+1;
            sumWages+= employee.getWages();
        }
        Log.d("compte", String.valueOf(compteur));
        sum=sumWages/compteur;
        Log.d("sum", String.valueOf(sum));
        return sum;
    }


}
