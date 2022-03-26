package com.example.employee_mvvm.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;

@Entity
public class Employee  {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name="gender")
    private String gender;
    @ColumnInfo(name="surname")
    private String surname;
    @ColumnInfo(name="name")
    private String name;
    @ColumnInfo(name="poste")
    private String poste;
    @ColumnInfo(name="startYear")
    private String startYear;
    @ColumnInfo(name="wages")
    private int wages;
    @ColumnInfo(name="wagesSum")
    private int wagesSum;

    public Employee(String gender, String surname, String name, String poste, String startYear, int wages) {
        this.gender = gender;
        this.surname = surname;
        this.name = name;
        this.poste = poste;
        this.startYear = startYear;
        this.wages = wages;

    }

    public Employee(){}

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public int getWages() {
        return wages;
    }

    public void setWages(int wages) {
        this.wages = wages;
    }

    public int getWagesSum() {
        return wagesSum;
    }

    public void setWagesSum(int wagesSum) {
        this.wagesSum = wagesSum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
