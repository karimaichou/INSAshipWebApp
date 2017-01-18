
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26/11/2016
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
<div class="col-md-6 col-md-offset-3">

                <img src="http://images.google.fr/imgres?imgurl=https://vide-dressing.org/images/picture/traitementPhoto.png&imgrefurl=https://vide-dressing.org/33-Gironde/Bordeaux&h=240&w=320&tbnid=gY7EJqbpuNxanM:&vet=1&tbnh=123&tbnw=164&docid=i-OPqJuNM8KtBM&client=firefox-b-ab&usg=__7Ywo4IvQ8bn31eQDaOFQep4eiYc=&sa=X&ved=0ahUKEwjT6NWG9cbRAhUDthQKHXV0DIYQ9QEILjAI"  class="img-responsive">
                <p>Last Name : <span>${studentlastname}</span></p>
                <p>First Name : <span >${studentFirstName}</span></p>
                <p>Gender: <span class="">${studentSex}</span></p>
                <p>Date of birth : <span class="">${studentDateofbirth}</span></p>
                <p>Adress: <span class="">${studentAdress}</span></p>
                <p>Telephone : <span class="">${studenttelephone}</span></p>
                <p>Email : <span class="">${studentEmail}</span></p>
                <p>Inscription date: <span class="">${studentDateInscription}</span></p>
                <p>Description : <span class="">${studentDescription}</span></p>
                <p>Scolar Year: <span class="">${studentScolarYear}</span></p>
    <a href="/offers" class="btn btn-primary btn-sm active" role="button">Show offers</a>
    <a href="/manage" class="btn btn-success btn-sm active" role="button">Edit Profil</a>
    <a href="/showApplications" class="btn btn-danger btn-sm active" role="button">Show Application</a>

</div>
</div>