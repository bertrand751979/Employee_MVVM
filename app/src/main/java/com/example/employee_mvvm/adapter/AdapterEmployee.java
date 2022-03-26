package com.example.employee_mvvm.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employee_mvvm.repository.EmployeeRepository;
import com.example.employee_mvvm.viewHolder.EmployeeViewHolder;
import com.example.employee_mvvm.R;
import com.example.employee_mvvm.models.Employee;

import java.util.ArrayList;

public class AdapterEmployee extends RecyclerView.Adapter<EmployeeViewHolder> {

    public interface EmployeeAdapterInterface{
        void delete(Employee employee);
    }

    private ArrayList<Employee> employees = new ArrayList<>();
    private EmployeeAdapterInterface employeeAdapterInterface;

    public AdapterEmployee(EmployeeAdapterInterface employeeAdapterInterface) {
        this.employeeAdapterInterface = employeeAdapterInterface;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_display,parent,false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.bind(employees.get(position), employeeAdapterInterface);
        EmployeeRepository.getInstance().setListAdapterBis(employees);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
