package com.springapp.controller;

import com.springapp.service.PrintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {

    @Autowired
    private PrintingService printingService;

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
    public String print(ModelMap map) {
        String printerName= "Bullzip PDF Printer";

//        printingService.printText(textLines, printerName);
        return "print_result";
    }
}
