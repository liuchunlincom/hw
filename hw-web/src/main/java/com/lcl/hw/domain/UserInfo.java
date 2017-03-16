package com.lcl.hw.domain;

import java.util.List;

/**
 * Created by Rain on 2017/3/14 19:23.
 */
public class UserInfo {
    private String user_id;
    private String user_name;
    private String user_pwd;
    private String user_email;
    private String user_tel;
    private String user_sex;
    private Department department;
    private List<JobInfo> jobInfos;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<JobInfo> getJobInfos() {
        return jobInfos;
    }

    public void setJobInfos(List<JobInfo> jobInfos) {
        this.jobInfos = jobInfos;
    }
}
