<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 11/18/2016
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty errorRegister}">
    <div class="alert alert-danger"> ${errorRegister}</div>
</c:if>

<c:if test="${not empty creationConfirmation}">
    <div class="alert alert-success"> ${creationConfirmation}</div>
</c:if>

<form:form commandName="student" cssClass="form-horizontal">

    <div class="row">
    <div class="col-md-9 .col-md-push-3">
    <div class="form-group">
        <label for="lastName" class="col-sm-6 control-label">Last Name</label>
        <div class="col-sm-6">
            <form:input path="lastName" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="firstName" class="col-sm-6 control-label">FirstName</label>
        <div class="col-sm-6">
            <form:input path="firstName" cssClass="form-control"/>
        </div>
    </div>
        <div class="form-group">
            <label class="col-sm-6 control-label">Gender</label>
            <div class="col-sm-6">
                <form:radiobutton path="sex" value="Male" label="Male" />

                <form:radiobutton path="sex" value="Female" label="Female" />
            </div>
        </div>
        <div class="form-group">
            <label for="dateOfBirth" class="col-sm-6 control-label">Date Of Birth (jj/mm/aaaa)</label>
            <div class="col-sm-6">
                <form:input path="dateOfBirth" cssClass="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="address" class="col-sm-6 control-label">Address</label>
            <div class="col-sm-6">
                <form:textarea path="address" cssClass="form-control"/>
            </div>
        </div>
    <div class="form-group">
        <label for="telephone" class="col-sm-6 control-label">Telephone</label>
        <div class="col-sm-6">
            <form:input path="telephone" cssClass="form-control"/>
        </div>
    </div>
        <div class="form-group">
            <label for="email" class="col-sm-6 control-label">Email</label>
            <div class="col-sm-6">
                <form:input path="email" cssClass="form-control"/>
            </div>
        </div>
    <div class="form-group">
        <label for="scholarYear" class="col-sm-6 control-label">ScholarYear</label>
        <div class="col-sm-6">
            <form:input path="scholarYear" cssClass="form-control"/>
        </div>
    </div>
        <div class="form-group">
            <label for="username" class="col-sm-6 control-label">Username</label>
            <div class="col-sm-6">
                <form:input path="username" cssClass="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-6 control-label">Password</label>
            <div class="col-sm-6">
                <form:password path="password" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label for="description" class="col-sm-6 control-label">Description</label>
            <div class="col-sm-6">
                <form:textarea path="description" cssClass="form-control"/>
            </div>
        </div>
        <input type="submit" value="save" class="btn btn-primary btn-sm active"/>
    </div>
    </div>
</form:form>


