package com.springapp.dao;

import com.springapp.domain.Team;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDAO extends DAO<Team> {
    public TeamDAO() {
        super(Team.class);
    }
}