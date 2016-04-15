package com.yuzhi.fine.mybeans;

import java.io.Serializable;

/**
 * Created by ZNE on 2016/4/14.
 */
public class TenantInfoBean implements Serializable{
    private String name ;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public TenantInfoBean(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
