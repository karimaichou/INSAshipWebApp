package com.controllers;

import com.View.OfferForm;
import com.View.StudentLoginForm;
import com.restful.Offer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by karima on 11/12/2016.
 */
@Controller
public class OfferController {

    @RequestMapping(value = "/offers",method = RequestMethod.GET)
    public String offers(Model model){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Offer[]> responseEntity = restTemplate.getForEntity("http://127.0.0.1:8888/enterprise1jobsofferws-0.0.1-SNAPSHOT/api/v1/offers", Offer[].class);
        Offer[] offerList = responseEntity.getBody();
        model.addAttribute("offers",offerList);
        return "offers";
    }

    @RequestMapping(value = "/search-offers",method = RequestMethod.POST)
    public String getOffers(@ModelAttribute("OfferForm")OfferForm form)
    {
        //filter part

        return "offers";
    }
}
