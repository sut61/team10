package com.example.demo.Entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = "Member")
@Getter
@Setter
public class Member {


    public Long getMember_id() {
        return Member_id;
    }
    public void setMember_id(Long member_id) {
        Member_id = member_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    @Id
    @SequenceGenerator(name="member_seq",sequenceName="member_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="member_seq")

    private @NonNull Long Member_id;
    private @NonNull String name;
    private @NonNull String email;


    public Member(String email,String name){
        this.email = email;
        this.name = name;
    }
    public Member(){ }

}
