package com.springapp.service;

import com.springapp.dao.TeamDAO;
import com.springapp.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamService{

    @Autowired
    private TeamDAO TeamDAO;

    public void addTeam(Team Team) {
        TeamDAO.add(Team);
    }

    public Team getTeam(Integer id) {
        return TeamDAO.get(id);
    }

    public void updateTeam(Team Team) {
        TeamDAO.update(Team);
    }

    public List<Team> listTeam() {
        return TeamDAO.list();
    }

    public void removeTeam(Integer id) {
        TeamDAO.remove(id);
    }
}