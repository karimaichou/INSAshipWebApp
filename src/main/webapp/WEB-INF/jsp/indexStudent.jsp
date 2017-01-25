<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

                  <c:if test="${studentSex == 'female'}">
                             <img alt="User Pic" src="https://pickaface.net/gallery/avatar/aparna0015296f059126bb.png" class="img-circle img-responsive">
                  </c:if>
                  <c:if test="${studentSex == 'Male'}">
                      <img alt="User Pic" src="https://pickaface.net/gallery/avatar/20110418_045300_4057_si_enthon9.png" class="img-circle img-responsive">
                  </c:if>

                </br>
                <p><strong>Last Name :</strong> <span style="color:blue">${studentlastname}</span></p>
                <p><strong>First Name :</strong> <span style="color:blue">${studentFirstName}</span></p>
                <p><strong>Gender:</strong> <span class="">${studentSex}</span></p>
                <p><strong>Date of birth : </strong><span class="">${studentDateofbirth}</span></p>
                <p><strong>Adress:</strong> <span class="">${studentAdress}</span></p>
                <p><strong>Telephone :</strong> <span class="">${studenttelephone}</span></p>
                <p><strong>Email : </strong><span class="">${studentEmail}</span></p>
                <p><strong>Inscription date:</strong><span class="">${studentDateInscription}</span></p>
                <p><strong>Description : </strong><span class="">${studentDescription}</span></p>
                <p><strong>Scolar Year:</strong> <span class="">${studentScolarYear}</span></p>
    <a href="/offers" class="btn btn-primary btn-sm active" role="button">Apply</a>
    <a href="/manage" class="btn btn-success btn-sm active" role="button">Edit Profil</a>
    <a href="/showApplications" class="btn btn-danger btn-sm active" role="button">Show Application</a>

</div>
</div>