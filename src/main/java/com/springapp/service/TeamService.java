package com.springapp.service;

import com.springapp.domain.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {

    public void addTeam(Team Team);

    public void updateTeam(Team Team);

    public List<Team> listTeam();

    public void removeTeam(Integer id);
}