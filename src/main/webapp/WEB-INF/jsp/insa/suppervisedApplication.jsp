<%--
  Created by IntelliJ IDEA.
  User: karima
  Date: 23/01/2017
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty error}">
    <div class="alert alert-danger"> ${error}</div>
</c:if>
<c:if test="${not empty emptyApp}">
    <div class="alert alert-success"> ${emptyApp}</div>
</c:if>

<c:if test="${not empty applications}">
    <table class="table table-hover">
        <thead>
        <tr>
            <td>Student</td>
            <td>Company</td>
            <td>Applied the</td>
        </tr>
        </thead>
        <c:forEach items="${applications}" var="application">
            <tr><td>${application.student.firstName} ${application.student.lastName}</td>
            <td> ${application.company.username}</td><td>${application.creationDate}</td>
            <td class="text-right"><input type="button" value="View details" class="btn btn-success" onclick="location.href='/insa/suppervisedDetails?id=${application.id}'"></td></tr>
        </c:forEach>
    </table>

</c:if>
