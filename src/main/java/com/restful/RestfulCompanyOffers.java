package com.restful;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by borik on 1/9/2017.
 */
public class RestfulCompanyOffers {
    @JsonProperty("company")
    private RestfulCompany restfulCompany;
    @JsonProperty("offerList")
    private List<RestfulOffer> restfulOffers;

    public RestfulCompany getRestfulCompany() {
        return restfulCompany;
    }

    public void setRestfulCompany(RestfulCompany restfulCompany) {
        this.restfulCompany = restfulCompany;
    }

    public List<RestfulOffer> getRestfulOffers() {
        return restfulOffers;
    }

    public void setRestfulOffers(List<RestfulOffer> restfulOffers) {
        this.restfulOffers = restfulOffers;
    }

    public List<Offer> getOffers()
    {
        List<Offer> offers = new ArrayList<Offer>();
        if (restfulCompany != null && restfulOffers != null) {
            for (RestfulOffer restfulOffer : restfulOffers) {
                if (!(restfulOffer == null)) {
                    Offer newOffer = new Offer();
                    newOffer.setCompany(restfulCompany.getId());
                    newOffer.setId(restfulOffer.getId());
                    newOffer.setTitle(restfulOffer.getTitle());
                    newOffer.setDescription(restfulOffer.getDescription());
                    newOffer.setAvailable(restfulOffer.isAvailable());
                    newOffer.setExpirationDate(restfulOffer.getExpirationDate());
                    newOffer.setStartDate(restfulOffer.getStartDate());
                    offers.add(newOffer);
                }
            }
        }
        return offers;
    }
}
