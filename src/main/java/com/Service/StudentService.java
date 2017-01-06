package com.Service;

import com.entities.Student;
import com.repositories.StudentRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by karima on 04/12/2016.
 */

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student findByEmailAndPassword(String email,String password)
    {
        String passHash=hashPassword(password);
        return studentRepository.findByEmailAndPassword(email,passHash);
    }

    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }

    public void save(Student student)
    {
        //student.setPassword(hashPassword(student.getPassword()));
        studentRepository.save(student);
        String cle = RandomStringUtils.randomAlphanumeric(20).toUpperCase();
        student.setToken(cle);
        studentRepository.save(student);
    }

    public void update(Student student)
    {
        studentRepository.save(student);
    }

    public List<Student> findByYear(int year)
    {
        return studentRepository.findByScholarYearOrderByScholarYearAsc(year);
    }

    List<Student> getAll()
    {
        return studentRepository.findAll();
    }


    //utility function to hash password
    public String hashPassword(String password)
    {
        String result = BCrypt.hashpw(password, BCrypt.gensalt(12));
        return result;
    }

}
