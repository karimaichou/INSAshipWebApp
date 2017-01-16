<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 11/18/2016
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- Font Awesome -->
<link href="${pageContext.request.contextPath}/resources/styles/font-awesome/css/font-awesome.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="${pageContext.request.contextPath}/resources/styles/custom.css" rel="stylesheet">


<c:if test="${not empty success}">
    <div class="alert alert-success"> ${success}</div>
</c:if>
<h2> Student applications:</h2>
<c:if test="${not empty noApplication}">
    <div class="alert "> ${noApplication}</div>
</c:if>
<div>
    <c:if test="${not empty applications}">
    <table class="table table-hover">
        <thead>
            <tr>
                <td>#</td>
                <td>Student</td>
                <td>Created</td>
                <td>State</td>
                <td></td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${applications}" var="application">
            <tr>
                <td style="vertical-align: middle">${application.id} </td>
                <td style="vertical-align: middle">${application.student.firstName} ${application.student.lastName}</td>
                <td style="vertical-align: middle">${application.creationDate}</td>
                <td style="vertical-align: middle">${application.state == 'Sent' ? 'Waiting for evaluation' : 'Accepted'}</td>
                <td class="text-right"><button class="btn btn-success" type="submit" onclick="location.href='/company/detail?id=${application.id}'">View Details</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

        <c:forEach items="${applications}" var="application">

        </c:forEach>
    </c:if>

</div>

<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/resources/styles/js/custom.js"></script>