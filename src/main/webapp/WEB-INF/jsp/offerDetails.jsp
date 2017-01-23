<%--
  Created by IntelliJ IDEA.
  User: karima
  Date: 08/01/2017
  Time: 13:49
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
    <h2><img src="${offer.companyLogoUrl}" height="40px" /></h2>
    <h3>${offer.title}</h3>
    <div>
        ${offer.description}<br>
            <input type="button" value="Apply Now" onclick="location.href='<spring:url value ="/apply?id=${offer.id}&company=${offer.company}"/>'" class="btn btn-success"/>
    </div>
</c:if>

</body>
</html>
