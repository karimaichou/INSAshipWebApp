package com.View;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * Created by karima on 09/01/2017.
 */
public class ApplicationForm implements Serializable {


    private String nom;

    private String prenom;

    private String email;

    private int id;

    private int company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private  List<MultipartFile> files;

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> resume) {
        this.files = resume;
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

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }
}
