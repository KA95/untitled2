package com.springapp.view;

/**
 * Created by Lenovo on 22.05.2015.
 */
public class SubmissionView {
    private String text;
    private Integer teamId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
