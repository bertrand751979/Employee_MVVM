package com.example.employee_mvvm.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employee_mvvm.R;
import com.example.employee_mvvm.adapter.AdapterEmployee;
import com.example.employee_mvvm.models.Employee;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private TextView vhMatricule;
    private TextView vhSurname;
    private TextView vhname;
    private TextView vhPoste;
    private TextView vhStartYear;
    private TextView vhWages;
    private ImageView imgDelete;

    public EmployeeViewHolder(@NonNull View view) {
        super(view);
        vhMatricule = view.findViewById(R.id.rawMat);
        vhSurname = view.findViewById(R.id.rawSurname);
        vhname = view.findViewById(R.id.rawName);
        vhPoste = view.findViewById(R.id.rawPoste);
        vhStartYear = view.findViewById(R.id.rawYearStart);
        vhWages = view.findViewById(R.id.rawWages);
        imgDelete = view.findViewById(R.id.rawDelete);
    }

    public TextView getVhMatricule() {
        return vhMatricule;
    }

    public void setVhMatricule(TextView vhMatricule) {
        this.vhMatricule = vhMatricule;
    }

    public TextView getVhSurname() {
        return vhSurname;
    }

    public void setVhSurname(TextView vhSurname) {
        this.vhSurname = vhSurname;
    }

    public TextView getVhname() {
        return vhname;
    }

    public void setVhname(TextView vhname) {
        this.vhname = vhname;
    }

    public TextView getVhPoste() {
        return vhPoste;
    }

    public void setVhPoste(TextView vhPoste) {
        this.vhPoste = vhPoste;
    }

    public TextView getVhStartYear() {
        return vhStartYear;
    }

    public void setVhStartYear(TextView vhStartYear) {
        this.vhStartYear = vhStartYear;
    }

    public TextView getVhWages() {
        return vhWages;
    }

    public void setVhWages(TextView vhWages) {
        this.vhWages = vhWages;
    }

    public ImageView getImgDelete() {
        return imgDelete;
    }

    public void setImgDelete(ImageView imgDelete) {
        this.imgDelete = imgDelete;
    }

    public void bind(Employee employee, AdapterEmployee.EmployeeAdapterInterface employeeAdapterInterface){
        vhMatricule.setText(employee.getGender());
        vhSurname.setText(employee.getSurname());
        vhname.setText(employee.getName());
        vhPoste.setText(employee.getPoste());
        vhStartYear.setText(employee.getStartYear());
        vhWages.setText(String.valueOf(employee.getWages()));
        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                employeeAdapterInterface.delete(employee);
            }
        });
    }
}
