package com.restful;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by borik on 1/9/2017.
 */
public class RestfulOffer {
    private String title;
    private String description;
    private boolean available;
    private long startDate;
    private long expirationDate;
    private Integer id;

    public RestfulOffer(){}

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

    @JsonProperty("titre")
    public String getTitre() {
        return title;
    }
    @JsonProperty("titre")
    public void setTitre(String title) {
        this.title = title;
    }
    @JsonProperty("contenu")
    public String getContenu() {
        return description;
    }
    @JsonProperty("contenu")
    public void setContenu(String description) {
        this.description = description;
    }
}
