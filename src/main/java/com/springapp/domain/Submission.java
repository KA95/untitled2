package com.springapp.domain;

import javax.persistence.*;

/**
* Created by Lenovo on 21.05.2015.
*/

@Entity
@Table(name = "submission")
public class Submission {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "text")
    private String text;

    @ManyToOne(targetEntity = Team.class)
    @JoinColumn(name="team_id")
    private Team team;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
