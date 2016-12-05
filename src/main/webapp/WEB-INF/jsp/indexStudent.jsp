<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26/11/2016
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<button class="btn btn-danger" type="button">
   Notifications <span class="badge">8</span>
</button>
<h3><p class="bg-primary">Informations personnelles </p></h3>
<form>
    <img src="http://images.google.fr/imgres?imgurl=http%3A%2F%2Fnordic2015.campusfrance.org%2Fwp-content%2Fuploads%2F2015%2F10%2FINSA-TOULOUSE-LOGO.jpg&imgrefurl=http%3A%2F%2Fnordic2015.campusfrance.org%2FParticipants%2Finsa-toulouse%2F&h=436&w=650&tbnid=QOxBEQC9MBQwVM%3A&vet=1&docid=A30DI9n1I837ZM&ei=1Ko5WO-BCYa3sQGcyIXgDA&tbm=isch&iact=rc&uact=3&dur=526&page=0&start=0&ndsp=30&ved=0ahUKEwjvu4733sbQAhWGWywKHRxkAcwQMwguKAowCg&bih=945&biw=1920" alt="..." class="img-circle">
    <fieldset disabled>
        <div class="form-group">
            <label for="nom">Nom </label>
            <input type="text" id="nom" class="form-control" placeholder="Nom">
        </div>
        <div class="form-group">
            <label for="prenom"> Prénom </label>
            <input type="text" id="prenom" class="form-control" placeholder=" Prenom ">
        </div>
        <div class="checkbox">
            <label> Sexe </label>
            <label>
                <input type="checkbox" disabled> Femme
            </label>
            <label>
                <input type="checkbox" disabled> Homme
            </label>
        </div>
        <div class="form-group">
            <label for="date_naissance">Date de naissance</label>
            <input type="text" id="date_naissance" class="form-control" placeholder="date_naissance">
        </div>
        <div class="form-group">
            <label for="nationalite"> Nationalité  </label>
            <input type="text" id="nationalite" class="form-control" placeholder=" nationalite ">
        </div>
        <div class="form-group">
            <label for="pays_residence"> Pays de résidence  </label>
            <input type="text" id="pays_residence" class="form-control" placeholder=" pays_residence ">
        </div>
        <div class="form-group">
            <label for="adresse_1"> Adresse </label>
            <input type="text" id="adresse_1" class="form-control" placeholder="adresse_1">
        </div>
        <div class="form-group">
            <label for="adresse_2"> Complément d'adresse  </label>
            <input type="text" id="adresse_2" class="form-control" placeholder="adresse_2">
        </div>
        <div class="form-group">
            <label for="codePostal">Code postal</label>
            <input type="text" id="codePostal" class="form-control" placeholder="codePostal">
        </div>
        <div class="form-group">
            <label for="ville"> Ville  </label>
            <input type="text" id="ville" class="form-control" placeholder="ville">
        </div>
        <div class="input-group">
            <label>E-mail</label>
            <span class="input-group-addon" id="basic-addon1">@</span>
            <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
        </div>
        <div class="form-group">
            <label for="telephone"> Téléphone </label>
            <input type="text" id="telephone" class="form-control" placeholder="telephone">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <input type="text" id="description" class="form-control" placeholder="description">
        </div>
        <button type="button" class="btn btn-info">Modifier</button>
    </fieldset>
</form>
<h3><p class="bg-primary">Suivi des Demandes</p></h3>
    </br>
    <table class="table table-striped">
        <tr>
            <td>Intitulé de l'offre</td>
            <td>Entreprise</td>
            <td>Ville</td>
            <td>Sujet (pdf )</td>
            <td>Date de soumission de la demande</td>
            <td>Label</td>
            <td>Statut de la demande</td>
        </tr>
        /* le nombre de ligne va dépondre des demandes de l'etudiant ci-dessus juste un exemple*/
        <tr>
            <td>Stage fin d'étude conception & dev</td>
            <td>Capgemini</td>
            <td>Toulouse</td>
            <td>capgemini.pdf</td>
            <td>15/11/2016</td>
            <td>Intéressée</td>
            <td>En cours de traitement</td>
        </tr>
    </table>
<h3><p class="bg-primary">Chercher les offres </p></h3>
    </br>
    <form class="navbar-form navbar-right inline-form">
        <div class="form-group">
            <input type="search" class="input-sm form-control" placeholder="Recherche">
            <button type="submit" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-eye-open"></span> Chercher</button>
        </div>
    </form>
