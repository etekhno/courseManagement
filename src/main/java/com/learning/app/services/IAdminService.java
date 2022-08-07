package com.learning.app.services;

import com.learning.app.domain.AdminDTO;
import com.learning.app.domain.inbound.AdminDTOIn;

public interface IAdminService {

    AdminDTO createAdmin(AdminDTOIn adminDTOIn);
}
