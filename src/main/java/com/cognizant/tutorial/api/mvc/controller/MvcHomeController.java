package com.cognizant.tutorial.api.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j

@Controller
public class MvcHomeController {

    @GetMapping("/tutorial")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }
}
