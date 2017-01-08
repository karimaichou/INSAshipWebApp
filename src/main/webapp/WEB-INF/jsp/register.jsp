<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 11/18/2016
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form:form commandName="student" cssClass="form-horizontal">
    <div class="form-group">
        <label for="lastName" class="col-sm-2 control-label">Last Name</label>
        <div class="col-sm-6">
                <form:input path="lastName" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="username" class="col-sm-2 control-label">username</label>
        <div class="col-sm-6">
            <form:input path="username" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">password</label>
        <div class="col-sm-6">
            <form:password path="password" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">email</label>
        <div class="col-sm-6">
            <form:input path="email" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="telephone" class="col-sm-2 control-label">téléphone</label>
        <div class="col-sm-6">
            <form:input path="telephone" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="description" class="col-sm-2 control-label">description</label>
        <div class="col-sm-6">
            <form:textarea path="description" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="dateOfBirth" class="col-sm-2 control-label">dateOfBirth(jj/mm/aaaa)</label>
        <div class="col-sm-6">
            <form:input path="dateOfBirth" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="dateInscription" class="col-sm-2 control-label">dateInscription(jj/mm/aaaa)</label>
        <div class="col-sm-6">
            <form:input path="dateInscription" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="address" class="col-sm-2 control-label">address</label>
        <div class="col-sm-6">
            <form:textarea path="address" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="firstName" class="col-sm-2 control-label">firstName</label>
        <div class="col-sm-6">
            <form:input path="firstName" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="scholarYear" class="col-sm-2 control-label">scholarYear</label>
        <div class="col-sm-6">
            <form:input path="scholarYear" cssClass="form-control"/>
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-10">
            <input type="submit" value="save" class="btn btn-lg btn-primary"/>
        </div>
    </div>
</form:form>

