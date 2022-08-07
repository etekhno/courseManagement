package com.learning.app.services.impl;

import com.learning.app.datamodel.User;
import com.learning.app.datamodel.repo.UserRepo;
import com.learning.app.domain.LoginDTO;
import com.learning.app.domain.inbound.LoginDTOIn;
import com.learning.app.services.IUserService;
import com.learning.app.shared.GenericModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public LoginDTO login(LoginDTOIn loginDTOIn) {
        User user = userRepo.findByEmailAndPassword(loginDTOIn.getEmail(), loginDTOIn.getPassword());

        LoginDTO loginDTO = GenericModelMapper.map(loginDTOIn, LoginDTO.class);
        loginDTO.setLogin(false);

        if(user != null)
            loginDTO.setLogin(true);

        return loginDTO;
    }

    @Override
    public Boolean isValidUser(String email, String password) {
        User user = userRepo.findByEmailAndPassword(email, password);

        if(user != null)
            return true;

        return false;
    }

    @Override
    public Boolean isAdminRole(String email, String password) {
        User user = userRepo.findByEmailAndPassword(email, password);

        if(user == null)
            return false;

        if("ADMIN".equalsIgnoreCase(user.getRole()))
            return true;

        return false;
    }

    @Override
    public Boolean isStudentRole(String email, String password) {
        User user = userRepo.findByEmailAndPassword(email, password);

        if(user == null)
            return false;

        if("STUDENT".equalsIgnoreCase(user.getRole()))
            return true;

        return false;
    }
}
