package com.springapp.controller;

import com.springapp.domain.Team;
import com.springapp.service.TeamService;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

/**
 * Created by Lenovo on 21.05.2015.
 */
@Controller
@RequestMapping("admin")
@Secured({"ROLE_ADMINISTRATOR"})
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String admin(ModelMap map) {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<? extends GrantedAuthority> securedMessage = userService.getAuthorities(userDetails);
        map.addAttribute("userDetails", userDetails);
        map.addAttribute("userAuthorities", securedMessage);
        return "admin";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showTeams(ModelMap map) {

        List<Team> teams = teamService.listTeam();
        map.addAttribute("teams",teams);
        return "list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTeamPost(@ModelAttribute("Team") Team Team,
                              BindingResult result) {
        teamService.addTeam(Team);
        return "redirect:show";
    }

    @RequestMapping("/delete/{TeamId}")
    public String deleteTeam(@PathVariable("TeamId") Integer TeamId) {

        teamService.removeTeam(TeamId);
        return "redirect:show";
    }
}
