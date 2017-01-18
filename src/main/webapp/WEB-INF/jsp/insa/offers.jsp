<%--
  Created by IntelliJ IDEA.
  User: karima
  Date: 13/01/2017
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty error}">
    <div class="alert alert-danger"> ${error}</div>
</c:if>
<c:if test="${not empty applications}">
    <table border>
        <c:forEach items="${applications}" var="application">
            <tr><td>from :${application.student.firstName} ${application.student.lastName}</td> </tr>
            <tr><td>Internship From: ${application.company.username}</td><td>, Applied the: ${application.creationDate}</td></tr>
            <tr><td><input type="button" value="more details" class="btn btn-success" onclick="location.href='/insa/details?id=${application.id}'"></td></tr>
        </c:forEach>
    </table>

</c:if>


