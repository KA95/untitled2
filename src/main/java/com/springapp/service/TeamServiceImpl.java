package com.springapp.service;

import com.springapp.dao.TeamDAO;
import com.springapp.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDAO TeamDAO;

    @Transactional
    public void addTeam(Team Team) {
        TeamDAO.addTeam(Team);
    }

    @Transactional
    public List<Team> listTeam() {

        return TeamDAO.listTeam();
    }

    @Transactional
    public void removeTeam(Integer id) {
        TeamDAO.removeTeam(id);
    }
}