package com.Service;

import com.entities.Role;
import com.entities.Student;
import com.repositories.RoleRepository;
import com.repositories.StudentRepository;
import org.apache.commons.lang.RandomStringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Created by karima on 04/12/2016.
 */

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MessageService messageService;

    public void sendmail(String destinataire,String cle) {

        final String username = "insaship@gmail.com";
        final String password = "admin2017";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("insaship@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinataire));
            message.setSubject("Confirmation de création de compte");
            message.setText("Bonjour,"
                    + "\n\n Vous trouvez ci-joint la clé de confirmation de votre compte!"
                    +"le lien pour l'activation de votre compte http://localhost:5050/confirmation-compte "
                    +"\n\n"+cle);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
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
        //student.setPassword(hashPassword(student.getPassword()));
        Role role = roleRepository.findByName("ROLE_STUDENT");
        System.out.print(role.getName());
        List<Role> roles = new  ArrayList();
        roles.add(role);
        student.setRoles(roles);
        Date date = new Date();
        String cle = RandomStringUtils.randomAlphanumeric(20).toUpperCase();
        student.setToken(cle);
        student.setDateInscription(date);
        try {
            // Send mail through ESB
            //messageService.sendCodeConfirmMessage(student);

            sendmail(student.getEmail(),student.getToken());

        } catch (Exception e) {
            e.printStackTrace();
        }
        studentRepository.save(student);
    }
    public Student findByToken(String token){

        return studentRepository.findByToken(token);

    }

    public void update(Student student)
    {

        studentRepository.save(student);
    }

    public List<Student> findByYear(int year)
    {
        return studentRepository.findByScholarYearOrderByScholarYearAsc(year);
    }

    public List<Student> getAll()
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
