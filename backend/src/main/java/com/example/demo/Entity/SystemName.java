package com.example.demo.Entity;

import lombok.NonNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class SystemName {


    public Long getSystemstudio_id() {
        return systemstudio_id;
    }

    public void setSystemstudio_id(Long systemstudio_id) {
        this.systemstudio_id = systemstudio_id;
    }

    public String getSytemstudio_name() {
        return sytemstudio_name;
    }

    public void setSytemstudio_name(String sytemstudio_name) {
        this.sytemstudio_name = sytemstudio_name;
    }

    @Id
    @SequenceGenerator(name="systemstudio_seq",sequenceName="systemstudio_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="systemstudio_seq")
    private @NonNull Long systemstudio_id;
    @NotNull
    @Size(min = 5)
    private String sytemstudio_name;

    public SystemName(String sytemstudio_name){
        this.sytemstudio_name = sytemstudio_name;
    }


    public SystemName(){}




}

