package com.Service;

import com.restful.Offer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Created by borik on 12/16/2016.
 */

@Service
public class OfferService {
    private String url = "http://localhost:8088/enterprise1jobsofferws-0.0.1-SNAPSHOT/api/v1/offers";
    public List<Offer> findAll()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Offer[]> responseEntity = restTemplate.getForEntity(url, Offer[].class);
        return new ArrayList<Offer>(Arrays.asList(responseEntity.getBody()));
    }
    public Offer findById(Integer id)
    {
        List<Offer> offers = findAll();
        for(Offer offer : offers) {
            if(offer.getId().equals(id) ){
                return offer;
            }
        }
        return null;
    }

    public List<Offer> findByKeyword(String keyword)
    {
        List<Offer> offers = findAll();
        List<Offer> matching = new ArrayList<Offer>();
        String regex = "^.*" + keyword + ".*$";
        for(Offer offer : offers) {
            if(offer.getTitle().matches(regex) | offer.getDescription().matches(regex) ){
                matching.add(offer);
            }
        }
        return matching;
    }
}
