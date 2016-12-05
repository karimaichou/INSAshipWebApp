package com.repositories;


import com.entities.Role;
import com.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by borik on 11/24/2016.
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmailAndPassword(String email, String password);

    User findByRoles(Role role);


}
