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
        <label class="col-sm-2 control-label">Documents:</label>
        <div class="col-sm-10">
            <p class="form-control-static">TODO </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label"></label>
        <div class="col-sm-10">

            <button type="button" class="btn btn-primary " onclick="location.href='/company/meeting'">Request meeting</button>
            <button type="button" class="btn btn-danger ${application.state != 'Sent' ? 'disabled':''}" onclick="location.href='/company/reject'">Reject</button>
            <button type="button" class="btn btn-success ${application.state != 'Sent' ? 'disabled':''}" onclick="location.href='/company/accept'">Accept</button>

        </div>
    </div>
</form>