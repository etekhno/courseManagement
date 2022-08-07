package com.learning.app.datamodel.repo;

import com.learning.app.datamodel.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepo extends PagingAndSortingRepository<User, String> {

    User findByEmailAndPassword(String email, String password);

}
