package com.learning.app.services.common.impl;

import com.learning.app.services.IUserService;
import com.learning.app.services.common.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    IUserService userService;

    public Boolean isAdminUser() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();

        String base64Auth = request.getHeader("authorization").substring(6);
        String credential = new String(Base64.getDecoder().decode(base64Auth));
        String email = credential.split(":")[0];
        String password = credential.split(":")[1];
        Boolean validUser = userService.isAdminRole(email, password);

        return validUser;
    }

    @Override
    public Boolean isStudentUser() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();

        String base64Auth = request.getHeader("authorization").substring(6);
        String credential = new String(Base64.getDecoder().decode(base64Auth));
        String email = credential.split(":")[0];
        String password = credential.split(":")[1];
        Boolean validUser = userService.isStudentRole(email, password);

        return validUser;
    }

}
