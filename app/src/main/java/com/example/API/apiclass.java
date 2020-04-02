package com.example.API;

import com.google.gson.annotations.SerializedName;

public class apiclass {
    @SerializedName("name")
    private String name;
    @SerializedName("salary")
    private int salary;
    @SerializedName("age")
    private int age;
    @SerializedName("id")
    private Integer id;

    public apiclass(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public apiclass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
