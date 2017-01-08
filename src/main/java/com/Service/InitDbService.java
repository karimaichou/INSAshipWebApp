package com.Service;

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

   /* @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void init(){

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        Role roleStudent = new Role();
        roleStudent.setName("ROLE_STUDENT");
        roleRepository.save(roleStudent);

        Role roleInsa = new Role();
        roleInsa.setName("ROLE_INSA");
        roleRepository.save(roleInsa);

        Role roleInsaAdmin = new Role();
        roleInsaAdmin.setName("ROLE_INSA_ADMIN");
        roleRepository.save(roleInsaAdmin);

        Role roleCompany = new Role();
        roleCompany.setName("ROLE_COMPANY");
        roleRepository.save(roleCompany);

        Role roleFsd = new Role();
        roleFsd.setName("ROLE_FSD");
        roleRepository.save(roleFsd);



    }*/
}
