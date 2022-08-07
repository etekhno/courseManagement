package com.learning.app.controller;

import com.learning.app.domain.AdminDTO;
import com.learning.app.domain.inbound.AdminDTOIn;
import com.learning.app.services.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    IAdminService adminService;

    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminDTO createAdmin(@RequestBody AdminDTOIn adminDTOIn) {
        return adminService.createAdmin(adminDTOIn);
    }
}
