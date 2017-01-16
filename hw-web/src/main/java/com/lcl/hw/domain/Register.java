package com.lcl.hw.domain;

/**
 * Created by Rain on 2016/12/14 16:57.
 */
public class Register {
    private String name;
    private String loginid;
    private String password;
    private String sex;
    private String department;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Register{" +
                "name='" + name + '\'' +
                ", loginid='" + loginid + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
