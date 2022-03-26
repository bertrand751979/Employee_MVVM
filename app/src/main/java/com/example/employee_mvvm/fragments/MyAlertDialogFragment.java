package com.example.employee_mvvm.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.employee_mvvm.adapter.AdapterEmployee;
import com.example.employee_mvvm.models.Employee;
import com.example.employee_mvvm.activities.MainActivity;
import com.example.employee_mvvm.R;
import com.example.employee_mvvm.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class MyAlertDialogFragment extends DialogFragment {

    public static EditText mEditText;
    private Button done;
    private Button cancel;
    private List<Employee> employees;
    //public static ArrayList<Employee> listEmployee = new ArrayList<>();
    private  ArrayList<Employee> researchSearch = new ArrayList<>();
    //private AdapterEmployee.EmployeeAdapterInterface employeeAdapterInterface;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //listEmployee = new ArrayList<Employee>(SharedPreferencesManager.getInstance(this.getContext()).getEmployeeList(MainActivity.MY_EMPLOYEE_KEY));
    }

    public MyAlertDialogFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        done = view.findViewById(R.id.btnValidez);
        cancel = view.findViewById(R.id.btnAnnulez);
        mEditText = (EditText) view.findViewById(R.id.txt_your_search);
        String title = getArguments().getString("title", "");
        getDialog().setTitle(title);
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                if(title.toLowerCase().contains("year")){
                    searchYear();
                    Toast.makeText(MyAlertDialogFragment.this.getContext(), "itemYear", Toast.LENGTH_SHORT).show();
                }
                if(title.toLowerCase().contains("skills")){
                    searchSkills();
                    Toast.makeText(MyAlertDialogFragment.this.getContext(), "itemSkills", Toast.LENGTH_SHORT).show();
                }
                if(title.toLowerCase().contains("surname")){
                    searchName();
                    Toast.makeText(MyAlertDialogFragment.this.getContext(), "itemSurname", Toast.LENGTH_SHORT).show();
                }
                if(title.toLowerCase().contains("reboot")){
                    Toast.makeText(MyAlertDialogFragment.this.getContext(), "itemSurname", Toast.LENGTH_SHORT).show();
                }
                //SharedPreferencesManager.getInstance(getContext()).moyWages();
                dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    public void searchName(){
        //EmployeeRepository.getInstance().getSearchList().clear();
        int count = 0;
        for(Employee employee : EmployeeRepository.getInstance().getSearchList()){
            if(employee.getSurname().equalsIgnoreCase(mEditText.getText().toString())) {
                researchSearch.add(employee);
                Toast.makeText(MyAlertDialogFragment.this.getContext(), "Je passe dans la methode"+EmployeeRepository.getInstance().getSearchList().size(), Toast.LENGTH_LONG).show();
            }
        }
        EmployeeRepository.getInstance().employeeAdapter.setEmployees(new ArrayList<>(researchSearch));
        EmployeeRepository.getInstance().employeeAdapter.notifyDataSetChanged();
    }


    public void searchYear(){
        //EmployeeRepository.getInstance().getSearchList().clear();
        int count = 0;
        for(Employee employee : EmployeeRepository.getInstance().getSearchList()){
            if(employee.getStartYear().equalsIgnoreCase(mEditText.getText().toString())) {
                researchSearch.add(employee);
                //Toast.makeText(MyAlertDialogFragment.this.getContext(), "Je passe dans la methode"+EmployeeRepository.getInstance().getSearchList().size(), Toast.LENGTH_LONG).show();
            }
        }
        EmployeeRepository.getInstance().employeeAdapter.setEmployees(new ArrayList<>(researchSearch));
        EmployeeRepository.getInstance().employeeAdapter.notifyDataSetChanged();
    }


    public void searchSkills(){
        //EmployeeRepository.getInstance().getSearchList().clear();
        int count = 0;
        for(Employee employee : EmployeeRepository.getInstance().getSearchList()){
            if(employee.getPoste().equalsIgnoreCase(mEditText.getText().toString())) {
                researchSearch.add(employee);
                Toast.makeText(MyAlertDialogFragment.this.getContext(), "Je passe dans la methode"+EmployeeRepository.getInstance().getSearchList().size(), Toast.LENGTH_LONG).show();
            }
        }
        EmployeeRepository.getInstance().employeeAdapter.setEmployees(new ArrayList<>(researchSearch));
        EmployeeRepository.getInstance().employeeAdapter.notifyDataSetChanged();
    }




   /* public void searchSkills(List<Employee> employees){
        if(listSearch!=null){
            listSearch.clear();}
        for(Employee employee : SharedPreferencesManager.getInstance(this.getContext()).getEmployeeList(MainActivity.MY_EMPLOYEE_KEY) ){
            if(employee.getPoste().equalsIgnoreCase(mEditText.getText().toString())){
                listSearch.add(employee);
                Toast.makeText(this.getContext(), "Taille"+listSearch.size(), Toast.LENGTH_SHORT).show();
            }
        }
        employeeAdapter.setEmployees(new ArrayList<>(employees));
        employeeAdapter.notifyDataSetChanged();
    }

    public void searchYear(List<Employee> employees){
        if(listSearch!=null){
            listSearch.clear();}
        for(Employee employee : SharedPreferencesManager.getInstance(this.getContext()).getEmployeeList(MainActivity.MY_EMPLOYEE_KEY) ){
            if(employee.getStartYear().equalsIgnoreCase(mEditText.getText().toString())){
                listSearch.add(employee);
                Toast.makeText(this.getContext(), "Taille"+listSearch.size(), Toast.LENGTH_SHORT).show();
            }
        }
        employeeAdapter.setEmployees(new ArrayList<>(employees));
        employeeAdapter.notifyDataSetChanged();
    }










   /* public void searchName(List<Employee> employees){
        if(listSearch!=null){
            listSearch.clear();}
            for(Employee employee : SharedPreferencesManager.getInstance(this.getContext()).getEmployeeList(MainActivity.MY_EMPLOYEE_KEY) ){
                if(employee.getSurname().equalsIgnoreCase(mEditText.getText().toString())){
                    listSearch.add(employee);
                    Toast.makeText(this.getContext(), "Taille"+listSearch.size(), Toast.LENGTH_SHORT).show();
                }
            }
        employeeAdapter.setEmployees(new ArrayList<>(employees));
        employeeAdapter.notifyDataSetChanged();
    }

    public void searchSkills(List<Employee> employees){
        if(listSearch!=null){
        listSearch.clear();}
        for(Employee employee : SharedPreferencesManager.getInstance(this.getContext()).getEmployeeList(MainActivity.MY_EMPLOYEE_KEY) ){
            if(employee.getPoste().equalsIgnoreCase(mEditText.getText().toString())){
                listSearch.add(employee);
                Toast.makeText(this.getContext(), "Taille"+listSearch.size(), Toast.LENGTH_SHORT).show();
            }
        }
        employeeAdapter.setEmployees(new ArrayList<>(employees));
        employeeAdapter.notifyDataSetChanged();
    }

    public void searchYear(List<Employee> employees){
        if(listSearch!=null){
            listSearch.clear();}
        for(Employee employee : SharedPreferencesManager.getInstance(this.getContext()).getEmployeeList(MainActivity.MY_EMPLOYEE_KEY) ){
            if(employee.getStartYear().equalsIgnoreCase(mEditText.getText().toString())){
                listSearch.add(employee);
                Toast.makeText(this.getContext(), "Taille"+listSearch.size(), Toast.LENGTH_SHORT).show();
            }
        }
        employeeAdapter.setEmployees(new ArrayList<>(employees));
        employeeAdapter.notifyDataSetChanged();
    }*/



}
