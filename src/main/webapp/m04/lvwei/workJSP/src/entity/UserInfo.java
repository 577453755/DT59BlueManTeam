/**
 * Project Name:workJSP
 * File Name:UserInfo.java
 * Package Name:entity
 * Date:2018年4月3日下午11:32:36
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package entity;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午11:32:36 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class UserInfo {
    private int id;

    private String name;

    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
