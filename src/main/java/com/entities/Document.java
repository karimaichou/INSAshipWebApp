package com.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by karima on 20/11/2016.
 */

@Entity
public class Document {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    private String fileUrl;

    private String fileType;


    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @ManyToOne
    private Application application;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
