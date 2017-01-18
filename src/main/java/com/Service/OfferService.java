package com.Service;

import com.restful.Offer;
import com.restful.RestfulCompany;
import com.restful.RestfulCompanyOffers;
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
    private static final String urlAll = "http://localhost:8181/api/alloffers";
    private static final String urlById = "http://localhost:8181/api/singleoffer?";
    private static final String urlByKeyword = "http://localhost:8181/api/search?keyword=";
    private static final String urlByCompany = "http://localhost:8181/api/companyoffers?cpnId=";

    private List<Offer> receiveOffers(String url){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RestfulCompanyOffers[]> responseEntity = restTemplate.getForEntity(url, RestfulCompanyOffers[].class);
        List<Offer> offers = new ArrayList<Offer>();
        for (RestfulCompanyOffers restfulCompanyOffers:responseEntity.getBody())
        {
            if (restfulCompanyOffers != null) offers.addAll(restfulCompanyOffers.getOffers());
        }
        return offers;
    }

    private List<Offer> receiveSingleOffer(String url){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RestfulCompanyOffers> responseEntity = restTemplate.getForEntity(url, RestfulCompanyOffers.class);
        List<Offer> offers = new ArrayList<Offer>();
        RestfulCompanyOffers restfulCompanyOffers = responseEntity.getBody();
        if (restfulCompanyOffers != null) offers.addAll(restfulCompanyOffers.getOffers());

        return offers;
    }

    public List<Offer> findAll()
    {
        return receiveOffers(this.urlAll);
        /*
        ArrayList<Offer> simulated=new ArrayList<Offer>();
        Offer offer1=new Offer();
        offer1.setAvailable(true);
        offer1.setDescription("De formation Bac +2 minimum, en informatique de préférence, vous avez 7 à 10 années d'expérience dans le domaine de l'assistance clients, idéalement en support applicatifs métiers et technique. Vous avez démontré vos qualités de manager et votre capacité à analyser et gérer les priorités. Vous avez le souci d'améliorer la satisfaction clientèle, la qualité du service rendu et avez la volonté de comprendre les métiers des clients. Vous avez envie de vous investir dans une entreprise à taille humaine qui fait de la satisfaction client son objectif principal. La connaissance du monde du spectacle vivant ou de la billetterie serait un plus.");
        offer1.setId(1);
        offer1.setCompany_id(3);
        offer1.setStartDate(01012017);
        offer1.setTitle("internship Bac+2: computer science student in database administration team");
        offer1.setExpirationDate(01032017);

        Offer offer2=new Offer();
        offer2.setAvailable(true);
        offer2.setCompany_id(2);
        offer2.setDescription("A la recherche d'un stage responsabilisant et challengeant au sein d'une banque performante et à taille humaine ?\n" +
                "Ancrée dans l'économie locale, la BRED Banque Populaire est un acteur majeur sur son territoire.\n" +
                "Elle bénéficie des moyens du Groupe BPCE, 2ème groupe bancaire français qui donnera un sens à votre parcours professionnel et les moyens de vos ambitions.\n" );
        offer2.setId(2);
        offer2.setStartDate(03052017);
        offer2.setTitle("Stage Assistant(e) Commercial(e) en centre d'affaires (H/F) chez BRED Banque Populaire\n" +
                "Paris 75001, Île-De-France France");
        offer2.setExpirationDate(10112017);
        simulated.add(offer1);
        simulated.add(offer2);
        return simulated;
        //
        */
    }
    public Offer findById(Integer offerId,Integer company)
    {
        /*List<Offer> offers = receiveOffers(urlById + "cpnId=" + companyId + "offerId=" + offerId);
        if (offers != null && !offers.isEmpty()) return offers.get(0);
        else return null;*/

        //karima's code : just to simulate search for ID: don't worry Borek :D

        List<Offer> offers=findAll();
        return offers.get(offers.indexOf(new Offer(offerId, company)));

    }
    public List<Offer> findByCompanyId(Integer company)
    {
        return receiveSingleOffer(urlByCompany + company);
    }

    public List<Offer> findByKeyword(String keyword)
    {
        return receiveOffers(urlByKeyword + keyword);
    }
}
