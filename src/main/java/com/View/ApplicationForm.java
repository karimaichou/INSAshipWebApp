package com.View;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Created by karima on 09/01/2017.
 */
public class ApplicationForm implements Serializable {

   private MultipartFile resume;

   private MultipartFile coverLetter;

    private String nom;

    private String prenom;

    private String email;

    public MultipartFile getResume() {
        return resume;
    }

    public void setResume(MultipartFile resume) {
        this.resume = resume;
    }

    public MultipartFile getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(MultipartFile coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
