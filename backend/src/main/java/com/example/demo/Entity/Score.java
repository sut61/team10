package com.example.demo.Entity;
import lombok.NonNull;
import lombok.*;
import javax.persistence.*;
@Entity
public class Score {

    @Id
    @SequenceGenerator(name="score_seq",sequenceName="score_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="score_seq")
    private @NonNull Long score_id;

    public Long getScore_id() {
        return score_id;
    }

    public void setScore_id(Long score_id) {
        this.score_id = score_id;
    }

    @NonNull
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Score(){}

}

