package com.restful;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by borik on 12/5/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Offer {

    private String title;
    private String description;
    private boolean available;
    private long startDate;
    private long expirationDate;
    private Integer id;

    public Offer(){}
    public Offer(int id)
    {
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean equals(Object offer)
    {
        return this.id==((Offer)offer).getId();
    }
}
