<%--
  Created by IntelliJ IDEA.
  User: karima
  Date: 13/01/2017
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2> Student applications:</h2>
<c:if test="${not empty error}">
    <div class="alert alert"> ${error}</div>
</c:if>
<c:if test="${not empty applications}">
    <table class="table table-hover">

        <thead>
            <tr>
                <td>Student</td>
                <td>Company</td>
                <td>Created</td>
                <td></td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${applications}" var="application">
        <tr>
            <td style="vertical-align: middle">${application.student.firstName} ${application.student.lastName}</td>
            <td style="vertical-align: middle">${application.company.username}</td><td>${application.creationDate}</td>
            <td class="text-right"><input type="button" value="Details" class="btn btn-success" onclick="location.href='/insa/details?id=${application.id}'"></td>
        </tr>
        </tbody>

        </c:forEach>
    </table>

</c:if>


