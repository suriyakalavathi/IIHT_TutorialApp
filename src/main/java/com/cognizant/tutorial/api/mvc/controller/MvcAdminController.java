package com.cognizant.tutorial.api.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j

@Controller
@RequestMapping("/tutorial")
public class MvcAdminController {

    @GetMapping("/admin")
    public ModelAndView admin() {
        return new ModelAndView("admin");
    }

    @GetMapping("/update")
    public ModelAndView update() {
        return new ModelAndView("update");
    }
}
