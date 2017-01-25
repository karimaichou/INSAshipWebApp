<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23/01/2017
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-4">
        <h2>Your Application detail:</h2>
        <p>${application.company.username}</p>

    </div>
    <div class="col-md-4">
        <h2>Student</h2>
        <table class="table">
            <tr>
                <td>Name:</td><td style="vertical-align: middle">${application.student.firstName} ${application.student.lastName}</td>
            </tr>
            <tr>
                <td>Year:</td><td style="vertical-align: middle">${application.student.scholarYear}</td>
            </tr>
            <tr>
                <td>E-mail:</td><td style="vertical-align: middle">${application.student.email}</td>
            </tr>
            <tr>
            <tr>
                <td>Date applied:</td><td style="vertical-align: middle">${application.creationDate}</td>
            </tr>
            <tr>
                <td>Documents:</td><td>TODO</td>
            </tr>

        </table>
    </div>
    <c:if test="${application.state == 'AcceptedByCompany'}">
        <div class="col-md-4">
            <h2>Confirm application </h2>
            <form class="form-horizontal" >
                <h4>${application.student.firstName}</h4> <p>Are you sure you want to validate this application</p>
                <button type="button" class="btn btn-danger"  onclick="location.href='<spring:url value="/showApplications"/>'">Return</button>
                <button type="button" class="btn btn-success"  onclick="location.href='<spring:url value="/accept"/>'">Accept</button>
            </form>
        </div>
    </c:if>
    <c:if test="${application.state == 'UnderAgreement'}">
        <div class="col-md-4">
            <h2>Internship Agreement </h2>
            <form class="form-horizontal" >
                <h4>${application.student.firstName}</h4> <p>Are you sure you want to generate thea agreement ?</p>
                <button type="button" class="btn btn-danger"  onclick="location.href='<spring:url value="/agreement"/>'">generate Agreement</button>
            </form>
        </div>
    </c:if>

</div>

