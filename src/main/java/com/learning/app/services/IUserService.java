package com.learning.app.services;

import com.learning.app.domain.LoginDTO;
import com.learning.app.domain.inbound.LoginDTOIn;

public interface IUserService {

    LoginDTO login(LoginDTOIn loginDTOIn);
    Boolean isValidUser(String email, String password);
    Boolean isAdminRole(String email, String password);
    Boolean isStudentRole(String email, String password);
}
