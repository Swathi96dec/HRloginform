package com.example.API;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class apiclass {
    @SerializedName("status")
    private String status;
    public List<data> data=null;


    public static class data {
        @SerializedName("employee_name")
         String name;
        @SerializedName("employee_salary")
        int salary;
        @SerializedName("employee_age")
         int age;
        @SerializedName("id")
        Integer id;

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
}
