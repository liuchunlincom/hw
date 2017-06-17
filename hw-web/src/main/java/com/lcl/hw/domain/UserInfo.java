package com.lcl.hw.domain;

import java.util.List;

/**
 * Created by Rain on 2017/3/14 19:23.
 */
public class UserInfo {
    private String userid;
    private String password;
    private List<RoleInfo> roleinfos;

    public List<RoleInfo> getRoleinfos() {
        return roleinfos;
    }

    public void setRoleinfos(List<RoleInfo> roleinfos) {
        this.roleinfos = roleinfos;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
