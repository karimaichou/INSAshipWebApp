package com.Service;

import com.entities.User;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * Created by karima on 04/12/2016.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    public String hashPassword(String password)
    {
        String result = BCrypt.hashpw(password, BCrypt.gensalt(12));
        return result;
    }
}
