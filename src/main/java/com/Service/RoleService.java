package com.Service;

import com.entities.Role;
import com.entities.Student;
import com.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by karima on 04/12/2016.
 */

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(String name)
    {
        return roleRepository.findByName(name);
    }
}
