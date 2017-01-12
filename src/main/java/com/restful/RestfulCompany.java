package com.restful;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by borik on 1/9/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestfulCompany {
    private Integer id;
    private String name;
    private String logoUrl;

    public Integer getId() {
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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
