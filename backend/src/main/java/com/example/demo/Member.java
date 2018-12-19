package com.example.demo.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    @Id
    @SequenceGenerator(name="address_seq",sequenceName="address_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_seq")
    private  Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Address address ;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date birthdate;

    private String userid ;
    private String password ;
    private String email ;
    private String tel ;
    private String username ;
    private String lastname ;

    public Member(){}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public Date getBirthdate() { return birthdate; }

    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }

    public String getUserid() { return userid; }

    public void setUserid(String userid) { this.userid = userid; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getTel() { return tel; }

    public void setTel(String tel) { this.tel = tel; }


}
