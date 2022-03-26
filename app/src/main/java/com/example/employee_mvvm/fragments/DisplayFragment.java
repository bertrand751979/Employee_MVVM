package com.example.employee_mvvm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employee_mvvm.adapter.AdapterEmployee;
import com.example.employee_mvvm.R;
import com.example.employee_mvvm.models.Employee;
import com.example.employee_mvvm.repository.EmployeeRepository;
import com.example.employee_mvvm.viewModels.DisplayFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class DisplayFragment extends Fragment {
    private RecyclerView recyclerView;
    //public  AdapterEmployee employeeAdapter;
    public  MenuItem itemReboot;
    public  MenuItem itemYear;
    public  MenuItem itemSurname;
    public  MenuItem itemSkills;
    public  MenuItem itemMenu;
    private TextView moyenne;
    private Button btnMoy;
    private boolean isDefaultList = true;
    public DisplayFragmentViewModel viewModelDisplay;
    public ArrayList<Employee>listEmployees =new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelDisplay = new ViewModelProvider(this).get(DisplayFragmentViewModel.class);
        Employee employee1 = new Employee("M","ALBERT","Yann","Directeur","2000",120000);;
        Employee employee2 = new Employee("M","JONES","Jacques","Employé","2010",92000);
        Employee employee3 = new Employee("M","BARTON","Louis","Employé","2010",100000);
        Employee employee4 = new Employee("F","VANDER","Julie","Secretaire","2000",820000);
        viewModelDisplay.addEmployee(employee1,getContext());
        viewModelDisplay.addEmployee(employee2,getContext());
        viewModelDisplay.addEmployee(employee3,getContext());
        viewModelDisplay.addEmployee(employee4,getContext());

    }
    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        //setViewItem();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_display);
        moyenne = view.findViewById(R.id.txt_moyenne);
        btnMoy = view.findViewById(R.id.btnMoyenne);
        btnMoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmployeeRepository.getInstance().moyWages();
                moyenne.setText(String.valueOf(EmployeeRepository.getInstance().moyWages()));

                //EmployeeRepository.getInstance().moyWagesListSearch();


               /* if(isDefaultList==true){
                    EmployeeRepository.getInstance().moyWages();
                    moyenne.setText(String.valueOf(EmployeeRepository.getInstance().moyWages()));
                }else{
                        EmployeeRepository.getInstance().moyWagesListSearch();
                        moyenne.setText(String.valueOf(EmployeeRepository.getInstance().moyWagesListSearch()));
                }*/

            }
        });
        setViewItem();
    }

    public void setViewItem(){
        //recyclerView = view.findViewById(R.id.recyclerview_display);
        //moyenne = view.findViewById(R.id.txt_moyenne);
        //btnMoy = view.findViewById(R.id.btnMoyenne);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        EmployeeRepository.getInstance().employeeAdapter = new AdapterEmployee(new AdapterEmployee.EmployeeAdapterInterface() {
            @Override
            public void delete(Employee employee) {
                viewModelDisplay.deleteEmployee(employee,getContext());
            }
        });
        recyclerView.setAdapter(EmployeeRepository.getInstance().employeeAdapter);

        viewModelDisplay.getEmployees(getContext()).observe(getViewLifecycleOwner(), new Observer<List<Employee>>() {
                    @Override
                    public void onChanged(List<Employee> employees) {
                    EmployeeRepository.getInstance().employeeAdapter.setEmployees(new ArrayList<>(employees));
                    listEmployees= (ArrayList<Employee>) employees;
                    EmployeeRepository.getInstance().setSearchList(listEmployees);
                        Toast.makeText(DisplayFragment.this.getContext(), "list size"+EmployeeRepository.getInstance().getSearchList().size(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu, menu);
        itemMenu=menu.findItem(R.id.menu_icon);
        itemYear = menu.findItem(R.id.search_year);
        itemSkills = menu.findItem(R.id.search_skills);
        itemSurname = menu.findItem(R.id.search_surname);
        itemReboot = menu.findItem(R.id.search_reboot);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_icon:
                return true;

            case R.id.search_year:
                showAlertDialog("year");
                isDefaultList =false;
                return true;

            case R.id.search_skills:
                showAlertDialog("skills");
                isDefaultList =false;
                return true;

            case R.id.search_surname:
                showAlertDialog("surname");
                isDefaultList =false;
                return true;

            case R.id.search_reboot:
                setViewItem();
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }

    public void showAlertDialog(String str) {
        //POUR PASSER LES PARAMETRES A UN FRAGMENTS
        FragmentManager fm = getActivity().getSupportFragmentManager();
        MyAlertDialogFragment alertDialog = new MyAlertDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", str);
        alertDialog.setArguments(args);
        alertDialog.show(fm, "fragment_alert");
    }

    
}
