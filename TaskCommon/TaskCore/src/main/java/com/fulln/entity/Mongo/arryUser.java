package com.fulln.entity.Mongo;


import com.fulln.entity.BaseModel;

import javax.persistence.Id;

public class arryUser extends BaseModel {

    @Id
    private Long id;
    private String username;
    private String password;
    private Integer sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
