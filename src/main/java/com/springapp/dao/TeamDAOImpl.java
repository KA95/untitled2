package com.springapp.dao;

import com.springapp.domain.Team;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDAOImpl implements TeamDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addTeam(Team Team) {
        sessionFactory.getCurrentSession().save(Team);
    }

    @SuppressWarnings("unchecked")
    public List<Team> listTeam() {

        return sessionFactory.getCurrentSession().createQuery("from Team ")
                .list();
    }

    public void removeTeam(Integer id) {
        Team Team = (Team) sessionFactory.getCurrentSession().load(
                Team.class, id);
        if (null != Team) {
            sessionFactory.getCurrentSession().delete(Team);
        }
    }
}