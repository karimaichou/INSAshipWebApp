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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>






<div class="row">
    <div class="col-md-4">
    <h2>Your Offer</h2>
    <p>${offer.title}</p>


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
    <div class="col-md-4">
        <h2>Agreement</h2>
            <button type="button" class="btn btn-danger ${application.state != 'Sent' ? 'disabled':''}" onclick="location.href='<spring:url value="/company/reject"/>'">Reject</button>
    </div>
</div>