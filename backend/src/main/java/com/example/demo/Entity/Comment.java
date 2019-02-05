package com.example.demo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Comment {
    @Id
    @SequenceGenerator(name="comment_seq",sequenceName="comment_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comment_seq")
    private  Long id;

    public Comment(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @NotNull
    @Pattern(regexp = "^([ก-ู]|[เ-์])+")
    @Size(min = 5 ,max = 20)
    @Column(unique = true)
    private String comments ;
}
