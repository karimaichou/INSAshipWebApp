<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 16/01/2017
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- Font Awesome -->
<link href="${pageContext.request.contextPath}/resources/styles/font-awesome/css/font-awesome.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="${pageContext.request.contextPath}/resources/styles/custom.css" rel="stylesheet">


<h2> Student applications:</h2>
<c:if test="${applications.size() <= 0}">
    <div class="alert "> You don't have any applilcations.</div>
</c:if>
<c:if test="${applications.size() > 0}">
<div>
        <table class="table table-hover">
            <thead>
            <tr>
                <td>#</td>
                <td>Creation Date</td>
                <td>Meeting request</td>
                <td>State </td>
                <td>Company </td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${applications}" var="application">
                <tr>
                    <td>${application.offer_id}</td>
                    <td>${application.creationDate}</td>
                    <td>${application.meetingRequest}</td>
                    <td>${application.state}</td>
                    <td>${application.company.username}</td>
                    <td class="text-right"><button class="btn btn-primary btn-sm active" type="submit" onclick="location.href='<spring:url value="/detail?id=${application.id}"/>'"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>

</div>

<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/resources/styles/js/custom.js"></script>
