package com.springapp.domain;

/**
 * Created by Lenovo on 21.05.2015.
 */
public class Submission {

    private Integer id;
    private String text;
    private Team Team;

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
        return Team;
    }

    public void setTeam(Team team) {
        Team = team;
    }
}
