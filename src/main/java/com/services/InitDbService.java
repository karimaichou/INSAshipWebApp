package com.services;

import com.entities.Role;
import com.entities.User;
import com.repositories.RoleRepository;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by borik on 11/24/2016.
 */
@Service
@Transactional
public class InitDbService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void init(){
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleUser.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleUser);
        roles.add(roleAdmin);
        admin.setRoles(roles);
        userRepository.save(admin);
    }
}
