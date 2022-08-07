package com.learning.app.services.impl;

import com.learning.app.datamodel.User;
import com.learning.app.datamodel.repo.UserRepo;
import com.learning.app.domain.AdminDTO;
import com.learning.app.domain.StudentDTO;
import com.learning.app.domain.inbound.AdminDTOIn;
import com.learning.app.services.IAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    UserRepo userRepo;

    @Override
    public AdminDTO createAdmin(AdminDTOIn adminDTOIn) {
        ModelMapper mm = new ModelMapper();
        User user = mm.map(adminDTOIn, User.class);
        user.setRole("ADMIN");

        user = userRepo.save(user);
        AdminDTO adminDTO = mm.map(user, AdminDTO.class);
        return adminDTO;
    }

}
