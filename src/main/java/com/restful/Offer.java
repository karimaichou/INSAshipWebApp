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
    private long startDate;
    private Integer id;
    private Integer company;
    private String companyName;
    private String companyLogoUrl;

    public int getCompany_id() {
        return company;
    }

    public void setCompany_id(int company) {
        this.company = company;
    }

    public Offer(){}
    public Offer(int id, int company)
    {
        this.id=id;
        this.company = company;
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

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLogoUrl() {
        return companyLogoUrl;
    }

    public void setCompanyLogoUrl(String companyLogoUrl) {
        this.companyLogoUrl = companyLogoUrl;
    }

    public boolean equals(Object offer)
    {
        return this.id==((Offer)offer).getId() && this.company==((Offer)offer).getCompany();
    }
}
