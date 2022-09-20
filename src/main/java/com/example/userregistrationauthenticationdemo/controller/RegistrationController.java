package com.example.userregistrationauthenticationdemo.controller;

import com.example.userregistrationauthenticationdemo.dto.UserDto;
import com.example.userregistrationauthenticationdemo.exception.UserAlreadyExistsException;
import com.example.userregistrationauthenticationdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userData", new UserDto());
        return "account/register";
    }

    @PostMapping("/register")
    public String registerUser(UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("registrationForm", userDto);
            return "account/register";
        }
        try {
            userService.register(userDto);
        } catch (UserAlreadyExistsException e) {
            bindingResult.rejectValue("email", "userData.email","An account already exists for this email.");
            model.addAttribute("registrationForm", userDto);
            return "account/register";
        }
        return "redirect:/starter";
    }
}
