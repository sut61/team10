package com.example.demo.Entity;


import javax.persistence.*;

@Entity
public class Admin {

    @Id
    @SequenceGenerator(name="admin_seq",sequenceName="admin_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="admin_seq")
    private  Long id;

    public Admin(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    private String userid ;
    private String password ;
}
