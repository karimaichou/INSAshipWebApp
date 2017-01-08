package com.Service;

import com.entities.Student;
import com.repositories.StudentRepository;
import org.apache.commons.lang.RandomStringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Date;
import  java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Created by karima on 04/12/2016.
 */

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public static void envoyerMailSMTP()  throws Exception{

        String smtpHost = "smtp.xyz.com";
        String from = "c.azzam@uhp.ac.ma";
        String to = "azzam.chaimaa88@gmail.com";
        String username = "";
        String password = "";

        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "552");
        props.put("mail.smtp.socketFactory.port", "552");
        props.put("mail.smtp.starttls.enable","false");

        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Hello");
        message.setText("Hello World");

        Transport tr = session.getTransport("smtp");
        tr.connect(smtpHost, username, password);
        message.saveChanges();

        // tr.send(message);
        /** Genere l'erreur. Avec l authentification, oblige d utiliser sendMessage meme pour une seule adresse... */

        tr.sendMessage(message,message.getAllRecipients());
        tr.close();


    }

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
        student.setPassword(hashPassword(student.getPassword()));
        String cle = RandomStringUtils.randomAlphanumeric(20).toUpperCase();
        student.setToken(cle);
        try {
            envoyerMailSMTP();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
