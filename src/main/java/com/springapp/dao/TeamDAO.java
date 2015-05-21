package com.springapp.dao;

import com.springapp.domain.Team;

import java.util.List;

public interface TeamDAO {

    public void addTeam(Team contact);

    public List<Team> listTeam();

    public void removeTeam(Integer id);
}