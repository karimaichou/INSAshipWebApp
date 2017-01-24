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


<!--<form class="form-horizontal" >
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
        <label class="col-sm-2 control-label">Documents:</label>
        <div class="col-sm-10">
            <p class="form-control-static">TODO </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label"></label>
        <div class="col-sm-10">

            <button type="button" class="btn btn-primary " onclick="location.href='<spring:url value="/company/meeting" />'">Request meeting</button>
            <button type="button" class="btn btn-danger ${application.state != 'Sent' ? 'disabled':''}" onclick="location.href='<spring:url value="/company/reject"/>'">Reject</button>
            <button type="button" class="btn btn-success ${application.state != 'Sent' ? 'disabled':''}" onclick="location.href='<spring:url value="/company/accept"/>'">Accept</button>

        </div>
    </div>

-->



<div class="row">
    <div class="col-md-4">
    <h2>Your Offer</h2>
    <p>${offer.title}</p>
    <button type="button" class="btn btn-primary " onclick="location.href='<spring:url value="/company/meeting" />'">Request meeting</button>

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
        <h2>FSD</h2>
        <p style="${error == 1 ? 'color:red': ''}" >Before acceptation, please choose the apropriate security procedure:</p>
        <form:form action="/company/accept" method="post" commandName="fsd" cssClass="form-signin" data-toggle="validator">
            <form:select path="id" cssClass="form-control">
                <form:options items="${mapFSDs}" />
            </form:select>
            <br/>
            <button type="submit" class="btn btn-success ${application.state != 'Sent' ? 'disabled':''}" value="Submit">Accept Student</button>
            <button type="button" class="btn btn-danger ${application.state != 'Sent' ? 'disabled':''}" onclick="location.href='<spring:url value="/company/reject"/>'">Reject</button>
        </form:form>
    </div>
</div>