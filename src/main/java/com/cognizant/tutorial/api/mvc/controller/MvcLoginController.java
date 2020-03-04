package com.cognizant.tutorial.api.mvc.controller;

import com.cognizant.tutorial.api.mvc.mapper.MvcUserMapper;
import com.cognizant.tutorial.api.mvc.model.MvcLoginRequest;
import com.cognizant.tutorial.api.mvc.model.MvcRoleRequest;
import com.cognizant.tutorial.api.mvc.model.MvcUserRequest;
import com.cognizant.tutorial.api.mvc.model.MvcUserResponse;
import com.cognizant.tutorial.service.api.LoginService;
import com.cognizant.tutorial.service.api.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;

@Slf4j

@Controller
@RequestMapping("/tutorial")
public class MvcLoginController {

    @Autowired
    private MvcUserMapper mvcUserMapper;

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    private boolean isCaptchaMatching() {
    //    log.debug("Verifying the captcha...");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Object generatedCaptcha = request.getSession().getAttribute("captchaSecurityCode");

        String userEnteredCaptcha = request.getParameter("captcha");
        boolean successfulMatch = userEnteredCaptcha.equals(generatedCaptcha);
    //    log.debug("Captcha is " + (successfulMatch ? "MATCHING" : "NOT matching"));

        return successfulMatch;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register", "register", new MvcUserRequest());
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("register") MvcUserRequest mvcUserRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", "Error - " + bindingResult.getFieldErrors().get(0).getDefaultMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/tutorial/register";
        }

        if (!isCaptchaMatching()) {
            redirectAttributes.addFlashAttribute("message", "Error - Captcha entered is incorrect");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/tutorial/register";
        }

 //       log.debug("MVC User Request: " + mvcUserRequest);

        mvcUserRequest.setRoles(new HashSet<MvcRoleRequest>(Arrays.asList(new MvcRoleRequest("USER"))));
        userService.addUser(mvcUserMapper.toUser(mvcUserRequest));

        redirectAttributes.addFlashAttribute("message", "Successfully registered");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/tutorial/register";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login", "login", new MvcLoginRequest());
    }

    @PostMapping(value = "/auth")
    public String auth(@Valid @ModelAttribute("login") MvcLoginRequest mvcLoginRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
       // log.debug("MVC Login Request: " + mvcLoginRequest);

        if (!isCaptchaMatching()) {
            redirectAttributes.addFlashAttribute("message", "Error - Captcha entered is incorrect");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/tutorial/login";
        }

        try {
            MvcUserResponse mvcUserResponse = mvcUserMapper.toUserResponse(loginService.authUser(mvcUserMapper.toUser(mvcLoginRequest)));
            redirectAttributes.addFlashAttribute("name", mvcUserResponse.getName());
        } catch (Throwable t) {
            redirectAttributes.addFlashAttribute("message", t.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/tutorial/login";
        }

        return "redirect:/tutorial/main";
    }

    @GetMapping("/logout")
    public ModelAndView homePage() {
        return new ModelAndView("logout");
    }
}
