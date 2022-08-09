package com.learning.app.controller;

import com.learning.app.domain.LoginDTO;
import com.learning.app.domain.inbound.LoginDTOIn;
import com.learning.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/login")
    public LoginDTO login(@Valid @RequestBody LoginDTOIn loginDTOIn) {
        return userService.login(loginDTOIn);
    }

}