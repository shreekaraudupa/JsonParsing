package com.example.shree.jsonparsing;

/**
 * Created by shree on 27-03-2018.
 */

public class Contacts {
    private String Name,Des,id;

    public Contacts(String name,String des,String id){
        this.setName(name);
        this.setDes(des);
        this.setId(id);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
