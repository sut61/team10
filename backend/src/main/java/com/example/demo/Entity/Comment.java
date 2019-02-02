package com.example.demo.Entity;

import javax.persistence.*;

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

    private String comments ;
}
