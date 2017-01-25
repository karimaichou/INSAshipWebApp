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
        //return receiveOffers(urlAll);

        ArrayList<Offer> simulated=new ArrayList<Offer>();


        String company1Name = "Airbus";
        String company1Logo = "http://www.airbus.com/fileadmin/templates/airbusv5/images/logo-airbus-gray-180px.png";

        String company2Name = "Orange";
        String company2Logo = "http://c.orange.fr/logo-orange.png";

        Offer offer1=new Offer();
        offer1.setId(1);
        offer1.setCompany_id(3);
        offer1.setCompanyName(company1Name);
        offer1.setCompanyLogoUrl(company1Logo);
        offer1.setStartDate(01012017);
        offer1.setTitle("\uFEFFInternship / Multi-windows heavy client based upon new web technologies");
        offer1.setDescription("\uFEFF<b>Description of the job</b>\n" +
                "<br>\n" +
                "<br>Airbus Defence and Space (Toulouse) is looking for an intern for a 6-month internship.\n" +
                "<br>\n" +
                "<br>The mission of Earth Observation satellites is to acquire data (image, radar acquisition…) in response to requests coming from various users.\n" +
                "<br>Mission planning consists in computing the set of actions to be performed by the satellite at all times, according to the request properties and the systems limitations: kinematics, on-board memory, download capacity... Mission planning is therefore a constrained optimisation problem with multiple objectives, one of them being to maximise the amount of data acquired while respecting system and user constraints.\n" +
                "<br>In addition to the development of operational software (for Mission Planning Centres), several simulation tools are being developed within the department to assess Earth Observation systems performances. Based on the satellite characteristics and the targeted acquisitions, those tools simulate the various stages of the mission chain: calculation of acquisitions opportunities followed by the elaboration of the mission plan and the download plans.\n" +
                "<br>\n" +
                "<br>The purpose of your internship is to evaluate the maturity of cutting edge web technologies for a multi-windowed heavy client with 3D virtual globe and production level quality target. Application ergonomics must be taken into account through material design.\n" +
                "<br>Based on an existing web portal, the trainee must evaluate the ability to integrate this approach in production grade build chain: continuous integration and delivery, testing and code quality metrics.\n" +
                "<br>\n" +
                "<br>This internship will start on 3rd April 2017 (subject to some flexibility).\n" +
                "<br>\n" +
                "<br>\n" +
                "<b>Tasks & accountabilities</b>\n" +
                "<br>\n" +
                "<br>Your responsibilities will include:\n" +
                "<br>\n" +
                "<br>Understanding the context of mission chain: image order deposit, image order follow-up, image catalogue browsing, mission plan elaboration, mission planning follow-up,\n" +
                "<br>Conducting several assessments:\n" +
                "<br>* Building from scratch multi-windowed Electron application with both virtual 3D globe and appliance windows,\n" +
                "<br>* Building reusable and extensible components (plugin system to study) for each mission-chain activities eg: order deposit, order browsing, catalogue browsing, mission planning and mission follow-up…\n" +
                "<br>* Defining testing strategy for unit, integration and end-to-end tests,\n" +
                "<br>* Defining code quality and coverage strategy,\n" +
                "<br>* Applying continuous integration (eg Jenkins 2) and delivering practices (eg Nexus 3).\n" +
                "<br>\n" +
                "<br><b>Required skills</b>\n" +
                "<br>\n" +
                "<br>You are in the final year of a Master’s degree, Engineering School or equivalent specialised in Aerospace.\n" +
                "<br>You ideally have initial experience and you have software development skills : Javascript and derived, WebComponents, Electron, NodeJS, object programming, continuous integration and delivery.\n" +
                "<br>You ideally have international experience, and diversity of experiences.\n" +
                "<br><br>A knowledge of:\n" +
                "<br>Polymer 1, AngularJS 2,\n" +
                "<br>Background in applied mathematics,Java skills,\n" +
                "<br>Generic background in space systems and Earth-observation missionswould be a plus.\n" +
                "<br>\n" +
                "<br>You are a good team player and have excellent interpersonal skills.\n" +
                "<br>\n" +
                "<br>English: negotiation level,\n" +
                "<br>French: negotiation level.");

        Offer offer2=new Offer();
        offer2.setId(2);
        offer2.setCompany_id(3);
        offer2.setCompanyName(company1Name);
        offer2.setCompanyLogoUrl(company1Logo);
        offer2.setStartDate(01012017);
        offer2.setTitle("\uFEFFInternship / Creation of a Web Portal for the Toulouse Satellite Operations Centre");
        offer2.setDescription("\uFEFF<b>Description of the job</b>\n" +
                "<br>\n" +
                "<br>Airbus Defence and Space is a division of the Airbus Group formed by combining the business activities of Cassidian, Astrium and Airbus Military. This new division is Europe’s number one defence and space enterprise, the second largest space business worldwide and among the top ten global defence enterprises. It employs some 40,000 employees, generating revenues of approximately €14 billion per year.\n" +
                "<br>Airbus Group is a global leader in aeronautics, space and related services. In 2015, the Group - comprising Airbus, Airbus Defence and Space and Airbus Helicopters - generated revenues of € 64.5 billion and employed a workforce of around 136,600.\n" +
                "<br>Our people work with passion and determination to make the world a more connected, safer and smarter place. Taking pride in our work, we draw on each other's expertise and experience to achieve excellence. Our diversity and teamwork culture propel us to accomplish the extraordinary - on the ground, in the sky and in space.\n" +
                "<br>\n" +
                "<br>Airbus Defence and Space (Toulouse) is looking for an intern (m/f) for a 6-month internship.\n" +
                "<br>\n" +
                "<br>As part of this internship, you will join the Customer Support and Satellite Operations group of the telecommunication satellites management in Toulouse.\n" +
                "<br>You will join the Ground Means team that is in charge of the definition, implementation and exploitation of all ground means used in operations and the follow-up of Airbus Defence and Space telecommunication satellites.\n" +
                "<br>The set of these ground means forms the Toulouse Satellite Operations Centre (TSOC) and supports the following departments:\n" +
                "<br>\n" +
                "<br>Inserting Airbus DS satellites in orbit (LEOP: Launch & Early Orbit Phases)\n" +
                "<br>Following up the in-flight satellite fleet (IFSS: In Flight Satellite Support)\n" +
                "<br>Performing satellite station-keeping as a backup for our customers (OST: On Station)\n" +
                "<br>Producing and validating operational products (ENG/VAL: Engineering & Validation).\n" +
                "<br>This internship will start on 1st February 2017 (subject to some flexibility).\n" +
                "<br>\n" +
                "<br><b>Tasks & accountabilities</b>\n" +
                "<br>\n" +
                "<br>Within this group, you will be requested to work on the development and implementation of a web portal designed for TSOC users.\n" +
                "<br>\n" +
                "<br>The internship will be composed of several phases:\n" +
                "<br>\n" +
                "<br>Familiarising yourself with TSOC activities and gathering needs from users, as well as TSOC managers,\n" +
                "<br>Preparing and presenting one or several designs answering to the needs, as well as the selected technologies,\n" +
                "<br>Developing and launching a first version of the web portal.\n" +
                "<br><br><b>Required skills</b>\n" +
                "<br>\n" +
                "<br>You are in the final year of an engineering school, completing a Master's degree or in the 5th year of university, specialising in IT or General Engineering with a focus on IT. You have already carried out development activities for websites (during internships, practical work or personal work) and you have a strong interest in new technologies (web portal for mobile access).\n" +
                "<br>\n" +
                "<br>You ideally have initial experience in this field.\n" +
                "<br>You are a team player, independent and are willing to make suggestions.\n" +
                "<br>\n" +
                "<br>English: intermediate level,\n" +
                "<br>French: advanced level.");

        Offer offer3=new Offer();
        offer3.setId(3);
        offer3.setCompany_id(3);
        offer3.setCompanyName(company1Name);
        offer3.setCompanyLogoUrl(company1Logo);
        offer3.setStartDate(01012017);
        offer3.setTitle("\uFEFFInternship / Design of the C# WPF Function Application Management Interface");
        offer3.setDescription("\uFEFF<br>Airbus Helicopters, formerly Eurocopter, is a division of the Airbus Group, a global pioneer in aerospace and defence related services. Employing approximately 22,000 people worldwide, Airbus Helicopters is the world's number one helicopter manufacturer with a turnover of €6.5 billion. The company’s in-service fleet includes some 12,000 helicopters operated by more than 3,000 customers in approximately 150 countries. Airbus Helicopters’ international presence is ensured by its subsidiaries and participation in 21 countries, and its worldwide network of maintenance centres, training centres, distributors and certified agents.\n" +
                "<br>Airbus Group is a global leader in aeronautics, space and related services. In 2015, the Group - comprising Airbus, Airbus Defence and Space and Airbus Helicopters - generated revenues of € 64.5 billion and employed a workforce of around 136,600.\n" +
                "<br>Our people work with passion and determination to make the world a more connected, safer and smarter place. Taking pride in our work, we draw on each other's expertise and experience to achieve excellence. Our diversity and teamwork culture propel us to accomplish the extraordinary - on the ground, in the sky and in space.\n" +
                "<br>\n" +
                "<br><b>Description of the job</b>\n" +
                "<br><br>Airbus Helicopters (Marignane) is looking for an intern (m/f) for a 6-month internship.\n" +
                "<br>This internship will start on 1st March 2017 (subject to some flexibility).\n" +
                "<br>\n" +
                "<br><b>Tasks & accountabilities</b>\n" +
                "<br>\n" +
                "<br>Your tasks will include:\n" +
                "<br>\n" +
                "<br>1/ Design\n" +
                "<br>Designing, building and developing a C# WPF interface in compliance with the provided coding standards, \n" +
                "<br>Drafting the associated documentation,\n" +
                "<br>Customising the user, \n" +
                "<br>Performing the automatic updates of the function application versions, \n" +
                "<br>Managing the right of access,\n" +
                "<br>\n" +
                "<br>2/ Modification of a 3D library\n" +
                "<br>Managing the 3D library structures,\n" +
                "<br>Moving 3D objects,\n" +
                "<br>Integrating the 3D library into the function application,\n" +
                "<br>Designing and independently creating a C# WPF application.\n" +
                "<br><br><b>Required skills</b>\n" +
                "<br>\n" +
                "<br>You are in the final year of business school, university or equivalent (5-year degree), specialising in IT.\n" +
                "<br>You ideally have initial experience in this field.\n" +
                "<br>You are recognised for your meticulousness and your ability to observe the rules applied.\n" +
                "<br>You have good knowledge of the C# WPF language.\n" +
                "<br>You are a good team player and have excellent interpersonal skills.\n" +
                "<br>\n" +
                "<br>English: intermediate level,\n" +
                "<br>French: fluent level.");


        Offer offer4=new Offer();
        offer4.setCompany_id(2);
        offer4.setId(1);
        offer4.setCompanyName(company2Name);
        offer4.setCompanyLogoUrl(company2Logo);
        offer4.setStartDate(03052017);
        offer4.setTitle("\uFEFFStage - Ingénieur développeur base de données (data quality)");
        offer4.setDescription("\uFEFF<b>Votre rôle</b>\n" +
                "<br>L’amélioration de l’expérience client est un des enjeux majeurs d’Orange France. Dans le cadre de la stratégie Essentiels 2020, la priorité est d’offrir une expérience client incomparable. La qualité des données clients est un des éléments clefs de l’expérience client. De nombreuses actions sont lancées à la DSI dans le cadre du programme « qualité des référentiels et cohérence des données du SI Orange France (OF) » , par exemple: mise en place d’un outil de cartographie des données et d’analyse des données du SI Orange France, mise en place d’un espace de partage et de communication pour capitaliser et communiquer sur les données du SI OF.\n" +
                "<br>\n" +
                "<br><b>Vos activités:</b>\n" +
                "<br>- Vous développez du code autour de l’outillage permettant de cartographie, analyser et fiabiliser les données du SI. \n" +
                "<br>- Vous contribuez à la mise en place du produit de cartographie des données Data Quality/Data Governance de l’éditeur Informatica.\n" +
                "<br>- Vous élaborez, administrez la gestion de contenus et publiez via des sites web ou documentaires type WIKI les différents résultats d’analyse de données, les règles de gouvernance de ces données.\n" +
                "<br>- Vous animez la communauté et assurez l'activité de webmaster.\n" +
                "<br>- Vous gérez la publication et la communication autour des fiabilisations de données du SI.\n" +
                "<br>\n" +
                "<br><b>Votre profil</b>\n" +
                "<br>Vous êtes en dernière année d'école ingénieurs en informatique ou préparez un Master 2 en informatique.\n" +
                "<br>\n" +
                "<br>- Compétence en informatique : développement & conception\n" +
                "<br>- Compétence en urbanisme/conception de données de systèmes d’informations\n" +
                "<br>- Compétence en développement Web , Microsoft ….\n" +
                "<br>- Connaissance en outils bureautiques comme Powerpoint/Excel\n" +
                "<br>- Aptitude personnelle : bon relationnel et autonomie\n" +
                "<br>\n" +
                "<br><b>Le plus de l'offre</b>\n" +
                "<br>Vous travaillez dans un environnement stratégique de données SI et d'analyse de données autour d’environnements Teradata et BigData et autres produits du marché de Data Quality.\n" +
                "<br>\n" +
                "<br><b>Entité</b>\n" +
                "<br>Au sein d’Orange France, la Direction du Système d’Information (DSI) fait partie de la Direction Technique et du Système d’Information. Cette direction est composée de 3200 personnes réparties sur plus de 26 sites géographiques et a pour mission principale de concevoir, développer et intégrer les systèmes d’information d’Orange afin de mieux répondre aux attentes des besoins Business et mieux satisfaire les clients.\n" +
                "<br>À la croisée de la relation client, du réseau et des plateformes de service, ainsi que des partenaires externes d'Orange, la DSI gère et développe un patrimoine de plus de 3400 applications. Elles communiquent entre elles pour construire la connaissance des clients et soutenir les processus de l’entreprise comme la commande, livraison, l’activation des services et la facturation.\n" +
                "<br>La DSI développe des nouvelles applications informatiques nationales dans les domaines porteurs et stratégiques pour Orange tels que les contenus pour l’internet mobile, les offres multiservices (TV, VoIP..), le développement de la fibre et les portails (portails clients, CRM, business intelligence..), les applications embarquées (Livebox, set top box etc…) et celles des terminaux communicants (smartphones, tablettes, M2M etc…).\n" +
                "<br>\n" +
                "<br><b>Contrat</b>\n" +
                "<br>Stage\n" +
                "<br>\n" +
                "<br>Durée du stage : 6 mois\n" +
                "<br>Niveau d'études préparées pendant ce stage : Bac+5, Bac+4" );


        Offer offer5=new Offer();
        offer5.setCompany_id(2);
        offer5.setId(1);
        offer5.setCompanyName(company2Name);
        offer5.setCompanyLogoUrl(company2Logo);
        offer5.setStartDate(03052017);
        offer5.setTitle("\uFEFFStage - Ingénieur d'étude sur les APIs");
        offer5.setDescription("\uFEFF<b>Votre rôle</b>\n" +
                "<br>Vous travaillez sur la raison d'être du cercle salariés-managers en vue de simplifier et orchestrer le parcours de l'utilisateur dans le cadre des processus RH et de sa vie au quotidien.\n" +
                "<br>\n" +
                "Cette simplification & orchestration nécessite de définir des APIs à faire valider par le métier, de les concevoir, avant de les faire chiffrer pour implémentation dans le SI actuel par les sous-traitants.\n" +
                "<br>\n" +
                "<br>A l'écoute des métiers, MOA et salariés, vous identifiez les processus à simplifier pour les utilisateurs,\n" +
                "<br>Vous analysez ces processus RH afin de mieux comprendre les problématiques opérationnelles et traduire les enjeux Métier en solutions d'interfaçage (API, Webservice…),\n" +
                "<br>Vous partagez vos propositions avec l'urbaniste/architecte fonctionnel et les métiers concernés,\n" +
                "<br>Vous vous appropriez la méthode de modélisation, définition, outils, normes API appliquées chez Orange en vue de réaliser la conception et la modélisation des APIs,\n" +
                "<br>Vous partagez vos propositions avec le sous-traitant que vous lui demandez de chiffrer,\n" +
                "<br>Vous suivez la réalisation des APIs.\n" +
                "<br><br><b>Votre profil</b>\n" +
                "<br>Vous préparez une formation de niveau Bac +4/5 dans le domaine de l'informatique.\n" +
                "<br>Connaissances techniques: Web service, SOAP, REST, SWAGGER.\n" +
                "<br>Votre sens de l'écoute, et votre esprit de synthèse vous permettent de comprendre les problématiques des utilisateurs.\n" +
                "<br>Vous faîtes preuve de proactivité, d'une grande rigueur, et vous avez le sens du service.\n" +
                "<br>Vous avez de bonnes capacités rédactionnelles.\n" +
                "<br><br><b>Le plus de l'offre</b>\n" +
                "<br>Mission située au coeur de la stratégie SI d'Orange.\n" +
                "<br>\n" +
                "<br><b>Entité</b>\n" +
                "<br>La Direction du Système d'Information Groupe conduit la stratégie du groupe en matière de Système d'Information. Elle aide chaque pays du Groupe à se doter du système d'information permettant croissance et transformation du business, offrant la meilleure expérience client et utilisateur et fournissant la meilleure efficacité opérationnelle.\n" +
                "\n" +
                "<br>Elle fournit aux Fonctions Groupe (achat, finance, rh…) le système d'Information répondant à leurs besoins.\n" +
                "\n" +
                "<br>Dans le cadre d'Essentiels 2020, des priorités ont été définies, notamment la simplification et l'orchestration des services pour les salariés managers.\n" +
                "\n" +
                "<br>Le stage se déroule au sein de l'équipe CIS/DO RH/DP SAMAPROS, responsable des projets et de la maintenance d'une quinzaine d'applications dans les domaines libre-service salariés-manageurs, production, social du système d'information ressources humaines périmètre France.\n" +
                "<br>\n" +
                "<br><b>Contrat</b>\n" +
                "<br>Stage\n" +
                "<br>\n" +
                "<br>Durée du stage : 6 mois\n" +
                "<br>Niveau d'études préparées pendant ce stage : Bac+5, Bac+4" );

        Offer offer6=new Offer();
        offer6.setCompany_id(2);
        offer6.setId(1);
        offer6.setCompanyName(company2Name);
        offer6.setCompanyLogoUrl(company2Logo);
        offer6.setStartDate(03052017);
        offer6.setTitle("\uFEFFStage - Analyse des performances d'un serveur web en environnement cloud");
        offer6.setDescription("\uFEFF<b>Votre rôle</b>\n" +
                "<br>Sous la responsabilité d’un pilote de métrologie, vous contribuez à déployer un environnement de test complet en mode cloud : serveur, injecteurs, outils de mesure. \n" +
                "<br>Vous intervenez de la conception de la solution (étude besoin, architecture) à sa réalisation. \n" +
                "<br>Vous développez une solution qui permettra ensuite d’automatiser ce déploiement en utilisant un ou plusieurs outils opensource. \n" +
                "<br>Vous développez les sondes permettant de mesurer les performances (CPU, mémoire, disque…).\n" +
                "<br>Vous mettez en place un serveur web donnant accès à ces outils.\n" +
                "<br>\n" +
                "<br><b>Votre profil</b>\n" +
                "<br>De niveau Bac+5 - Ecole ingénieur informatique / développement web.\n" +
                "<br>Vous avez des bases en développement web (php, apache, javascript...) et des notions de systèmes unix.\n" +
                "<br>Votre curiosité et votre capacité à travailler en équipe seront des atouts indispensables à votre réussite sur ce poste.\n" +
                "<br>\n" +
                "<br><b>Le plus de l'offre</b>\n" +
                "<br>Ce stage de 6 mois peut se poursuivre par une thèse d'une durée de 3 ans visant à obtenir un doctorat.\n" +
                "<br>\n" +
                "<br><b>Entité</b>\n" +
                "<br>Orange Labs Products and Services (OLPS) mobilise désormais l’expertise de plus de 3300 personnes réparties sur 14 villes en France et à l’international dans 11 pays. Elles porteront la responsabilité technique globale des produits et services proposés par notre Groupe, de la stratégie à la maintenance des solutions mises en œuvre partout dans le monde. Un challenge de taille que nous relevons tous ensemble dans une logique de maîtrise des coûts et des délais, avec un environnement de travail centré autour du client et de l’innovation au service des pays. \n" +
                "<br>L'équipe Intégration et Validation de Toulouse travaille sur les tests de performance de plusieurs services phare d'Orange (IoT, TV, VoIP). Les challenges à relever par l’équipe portent en particulier sur l’automatisation des tests pour les services tournant dans le Cloud et sur des plate-formes tournant sous OpenStack.\n" +
                "<br>\n" +
                "<br><b>Contrat</b>\n" +
                "<br>Stage\n" +
                "<br>\n" +
                "<br>Durée du stage : 6 mois\n" +
                "<br>Niveau d'études préparées pendant ce stage : Bac+5" );

        Offer offer7=new Offer();
        offer7.setCompany_id(2);
        offer7.setId(1);
        offer7.setCompanyName(company2Name);
        offer7.setCompanyLogoUrl(company2Logo);
        offer7.setStartDate(03052017);
        offer7.setTitle("\uFEFFStage - Faciliter le déploiement et le positionning d'API hébergées dans un environnement Openstack");
        offer7.setDescription("\uFEFF<b>Votre rôle</b>\n" +
                "<br>Vous identifiez les freins, les opportunités et les attentes des développeurs d'API.\n" +
                "<br>Vous proposez des solutions facilitant l'intégration d'API dans le Cloud.\n" +
                "<br>Après avoir établi un état des lieux et une collecte des besoins des différentes parties prenantes, vous proposez des solutions permettant de faciliter le déploiement et l'utilisation d'interfaces de\n" +
                "<br>Programmation applicatives (API) dans un environnement d'hébergement de type OpenStack.\n" +
                "<br>\n" +
                "<br><b>Votre profil</b>\n" +
                "<br>De niveau Bac+4/5 - Ecole d'ingénieur en informatique avec une spécialisation dans le domaine du développement logiciel.\n" +
                "<br>Vous maîtrisez la conception de logiciels (API) et le développement en langage Python.\n" +
                "<br>\n" +
                "<br>Vous connaissez Openstack, Ansible, Swagger.\n" +
                "<br>La connaissance d'UML serait appréciée.\n" +
                "<br>\n" +
                "<br><b>Entité</b>\n" +
                "<br>Orange Labs Products and Services (OLPS) mobilise désormais l'expertise de plus de 3300 personnes réparties sur 14 villes en France et à l'international dans 11 pays. Elles porteront la responsabilité technique globale des produits et services proposés par notre Groupe, de la stratégie à la maintenance des solutions mises en oeuvre partout dans le monde. Un challenge de taille que nous relevons tous ensemble dans une logique de maîtrise des coûts et des délais, avec un environnement de travail centré autour du client et de l'innovation au service des pays.\n" +
                "<br>Au sein d'un département d'Orange Labs spécialisé sur les architectures de services, vous intégrez une équipe travaillant sur le domaine des architectures orientées services.\n" +
                "<br>\n" +
                "<br><b>Contrat</b>\n" +
                "<br>Stage\n" +
                "<br>\n" +
                "<br>Durée du stage : 6 mois\n" +
                "<br>Niveau d'études préparées pendant ce stage : Bac+5, Bac+4" );

        Offer offer8=new Offer();
        offer8.setCompany_id(2);
        offer8.setId(1);
        offer8.setCompanyName(company2Name);
        offer8.setCompanyLogoUrl(company2Logo);
        offer8.setStartDate(03052017);
        offer8.setTitle("\uFEFFStage - ingénieur développement logiciel - méthode DevOps");
        offer8.setDescription("\uFEFF<b>Votre rôle</b>\n" +
                "<br>Sous la responsabilité du responsable outillage du programme DEVOPS, vous collaborez à l’étude des nouveaux outils DEVOPS et à la réalisation de POC (Proof Of Concept).\n" +
                "<br>Vous intégrez une équipe de développement logiciel pour étudier et réaliser des outils qui pourront servir aux futurs utilisateurs des solutions de déploiement automatique.\n" +
                "<br>\n" +
                "<br><b>Vos missions sont :</b>\n" +
                "<br>l'étude des outils pour l’automatisation des déploiements logiciels (jenkins, ansible, …)\n" +
                "<br>l'étude sur la mise en place d’API pour le pilotage d’ansible\n" +
                "<br>la mise en place d’un portail d’administration du service de déploiement\n" +
                "<br>l'étude sur l’exploitation des logs ansible\n" +
                "<br>la mise en place d’un service de consultation des logs\n" +
                "<br>l'étude sur la conteneurisation de slave jenkins (LXD ou Docker)\n" +
                "<br><br><b>Votre profil</b>\n" +
                "<br>Vous préparez une formation de niveau Bac +4/5 (école d'ingénieur ou master) dans le domaine du développement logiciel.\n" +
                "<br>Vous avez aimez la technique et le développement.\n" +
                "<br>Vous avez des connaissances système (scripting, linux, …).\n" +
                "<br>Vous connaissez les outils utilisés pour du déploiement continu (jenkins, ansible, maven, …).\n" +
                "<br>Vous êtes à l’aise pour communiquer et partager.\n" +
                "<br>Vous êtes autonome sur vos tâches.\n" +
                "<br>\n" +
                "<br><b>Le plus de l'offre</b>\n" +
                "<br>Vous travaillez sur les nouveaux outils du SI Orange. Vous découvrez et participez à la mise en place du déploiement continu au sein d’un groupe international.\n" +
                "<br>\n" +
                "<br><b>Entité</b>\n" +
                "<br>Au sein de la DESI (Direction de l’Exploitation du SI), le programme DevOps a été créé en janvier 2015 pour coordonner et synchroniser toutes les initiatives liées au DevOps, tant au niveau technique que fonctionnel ou organisationnel, sur le périmètre du SI France (1 200 applications).\n" +
                "<br>\n" +
                "<br>Ses missions sont de :\n" +
                "<br>structurer la démarche globale pour étendre le déploiement continu.\n" +
                "<br>accompagner et coordonner le lancement de projets dans les entités partenaires.\n" +
                "<br>définir une ambition à fin 2018.\n" +
                "<br>préconiser et mettre à disposition des méthodes et outils associés à chaque étape du déploiement continu (intégration continue, automatisation des tests, automatisation des déploiements, gestion de configuration, mise en place de métriques ...), étendre le catalogue d’offres existant si nécessaire.\n" +
                "<br>monter le plan de communication et de formation nécessaire pour les différents acteurs.\n" +
                "<br>accompagner les équipes Build/Run dans leur transformation.\n" +
                "<br><br><b>Contrat</b>\n" +
                "<br>Stage\n" +
                "<br>\n" +
                "<br>Durée du stage : 6 mois\n" +
                "<br>Niveau d'études préparées pendant ce stage : Bac+5, Bac+4" );

        simulated.add(offer1);
        simulated.add(offer2);
        simulated.add(offer3);
        simulated.add(offer4);
        simulated.add(offer5);
        simulated.add(offer6);
        simulated.add(offer7);
        simulated.add(offer8);
        return simulated;


        //

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
        //return receiveSingleOffer(urlByCompany + company);

        List<Offer> offers=findAll();
        List<Offer> newOffers = new ArrayList<Offer>();
        for(Offer offer:offers)
        {
            if (offer.getCompany() == company) newOffers.add(offer);
        }
        return newOffers;
    }

    public List<Offer> findByKeyword(String keyword)
    {
        //return receiveOffers(urlByKeyword + keyword);

        List<Offer> offers = findAll();
        List<Offer> matching = new ArrayList<Offer>();
        String regex = "^.*(?i)" + keyword + ".*$";
        for(Offer offer : offers) {
            if(offer.getTitle().matches(regex) | offer.getDescription().matches(regex) ){
                matching.add(offer);
            }
        }
        return matching;
    }
}
