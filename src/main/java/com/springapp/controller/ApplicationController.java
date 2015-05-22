package com.springapp.controller;

import com.springapp.domain.Submission;
import com.springapp.domain.Team;
import com.springapp.service.PrintingService;
import com.springapp.service.SubmissionService;
import com.springapp.service.TeamService;
import com.springapp.view.SubmissionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {
    @Autowired
    private TeamService teamService;

    @Autowired
    private PrintingService printingService;

    @Autowired
    private SubmissionService submissionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails =
                    (UserDetails) authentication.getPrincipal();
            map.addAttribute("userDetails", userDetails);
        }
        return "index";
    }

    @RequestMapping(value = "/print", method = RequestMethod.GET)
    public String printPage(ModelMap map) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails =
                    (UserDetails) authentication.getPrincipal();
            map.addAttribute("userDetails", userDetails);
        }
        return "print";
    }

    @RequestMapping(value = "/print", method = RequestMethod.POST)
    public String print(@ModelAttribute("SubmissionView") SubmissionView submissionView,
                        ModelMap map) {

        String printerName= "Bullzip PDF Printer";

        Submission submission = new Submission();
        submission.setText(submissionView.getText());
        Team team = teamService.getTeam(submissionView.getTeamId());
        submission.setTeam(team);
        submissionService.addSubmission(submission);

        System.out.println(submission.getTeam().getName());
        System.out.println(submission.getText());

        map.addAttribute("submission",submission);
        printingService.printText(submission.getText(), printerName);
        return "print_result";
    }
}
