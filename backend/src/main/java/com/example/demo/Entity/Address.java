package com.example.demo.Entity;


import javax.persistence.*;


@Entity
public class Address {

    @Id
    @SequenceGenerator(name="address_seq",sequenceName="address_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_seq")
    private  Long id;
    private String address ;
    private String tambon ;
    private String amphoe ;
    private String province ;
    private String postcode ;

    public Address(){}


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getTambon() { return tambon; }

    public void setTambon(String tambon) { this.tambon = tambon; }

    public String getAmphoe() { return amphoe; }

    public void setAmphoe(String amphoe) { this.amphoe = amphoe; }

    public String getProvince() { return province; }

    public void setProvince(String province) { this.province = province; }

    public String getPostcode() { return postcode; }

    public void setPostcode(String postcode) { this.postcode = postcode; }




}
