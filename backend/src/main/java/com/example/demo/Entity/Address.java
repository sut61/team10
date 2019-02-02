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

    private String postcode ;



    public Address(){}

    public com.example.demo.Entity.Province getProvince() {
        return Province;
    }

    public void setProvince(com.example.demo.Entity.Province province) {
        Province = province;
    }

    @ManyToOne
    private Province Province ;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getTambon() { return tambon; }

    public void setTambon(String tambon) { this.tambon = tambon; }

    public String getAmphoe() { return amphoe; }

    public void setAmphoe(String amphoe) { this.amphoe = amphoe; }



    public String getPostcode() { return postcode; }

    public void setPostcode(String postcode) { this.postcode = postcode; }




}
