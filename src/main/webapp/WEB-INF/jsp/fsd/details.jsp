<%--
  Created by IntelliJ IDEA.
  User: Aymene
  Date: 23/01/2017
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>${offer.title}</title>
</head>
<body>
<c:if test="${not empty errorDetails}">
    <div class="alert alert-danger"> ${errorDetails}</div>
</c:if>
<c:if test="${empty errorDetails}">

    <form class="form-horizontal" >
        <div class="form-group">
            <label class="col-sm-2 control-label">Student:</label>
            <div class="col-sm-10">
                <p class="form-control-static">${application.student.firstName} ${application.student.lastName}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Year:</label>
            <div class="col-sm-10">
                <p class="form-control-static">${application.student.scholarYear}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">E-mail:</label>
            <div class="col-sm-10">
                <p class="form-control-static">${application.student.email}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Created:</label>
            <div class="col-sm-10">
                <p class="form-control-static">${application.creationDate} </p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Offer:</label>
            <div class="col-sm-10">
                <p class="form-control-static">${offer.title}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Offer description:</label>
            <div class="col-sm-10">
                <p class="form-control-static">${offer.description}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label"></label>
            <div class="col-sm-10">

                <button type="button" class="btn btn-danger" onclick="location.href='<spring:url value="/fsd/valider?choix=accepter"/>'">Reject</button>
                <button type="button" class="btn btn-success" onclick="location.href='<spring:url value="/fsd/valider?choix=rejeter"/>'">Accept</button>

            </div>
        </div>
    </form>

</c:if>

</body>
</html>
