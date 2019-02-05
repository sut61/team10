package com.example.demo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Member {

    @Id
    @SequenceGenerator(name="member_seq",sequenceName="member_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="member_seq")
    private  Long id;

    @ManyToOne
    private Address address ;

    @ManyToOne
    private Gender gender ;

    @ManyToOne
    private Title title ;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date birthdate;

    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]+")
    @Column(unique = true)
    private String userid ;

    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]+")
    private String password ;

    @NotNull
    @Pattern(regexp = "^[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email ;



    @NotNull
    @Pattern(regexp = "[0-9]{10}")
    private String tel ;

    @NotNull(message="name must not be null to be valid")
    @Pattern(regexp = "[a-zA-Z]+")
    @Size(min = 2 ,max = 20)
    private String name ;

    @NotNull(message="lastname must not be null to be valid")
    @Pattern(regexp = "[a-zA-Z]+")
    @Size(min = 2 ,max = 20)
    private String lastname ;

    public Member(){}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    public String getName() { return name; }

    public void setName(String username) { this.name = username; }

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


    public Gender getGender() { return gender; }

    public void setGender(Gender gender) { this.gender = gender; }

    public Title getTitle() { return title; }

    public void setTitle(Title title) { this.title = title; }


}
