<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 21/01/2017
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h3><strong><span style="color: #0077b3">${stlastname} ${stFirstName} </span></strong></h3>
    <hr>
    <div class="row">
        <!-- left column -->
        <div class="col-md-3">
            <div class="text-center">
                <img src="//placehold.it/100" class="avatar img-circle" alt="avatar">
                <h6>Upload a different photo...</h6>

                <input class="form-control" type="file">
            </div>
        </div>

        <!-- edit form column -->
        <div class="col-md-9 personal-info">
            <div class="alert alert-info alert-dismissable">
                <a class="panel-close close" data-dismiss="alert">×</a>
                <i class="fa fa-coffee"></i>
                 <strong>Alert</strong>  Please , review the form before validating.
            </div>
       <form:form commandName="studentupdate" cssClass="form-horizontal">
                <div class="form-group">
                    <label class="col-lg-3 control-label" for="lastName">First name:</label>
                    <div class="col-lg-8">
                        <form:input path="lastName" cssClass="form-control" value="${stlastname}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Last name:</label>
                    <div class="col-lg-8">

                        <form:input path="firstName" cssClass="form-control" value="${stFirstName}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Date of birth:</label>
                    <div class="col-lg-8">
                        <fmt:formatDate pattern="MM/dd/yyyy" value="${stDateofbirth}" var="parsedDate" />
                        <form:input path="dateOfBirth" cssClass="form-control" value="${parsedDate}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Adress:</label>
                    <div class="col-lg-8">
                        <form:input path="address" cssClass="form-control" value="${stAdress}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Telephone:</label>
                    <div class="col-lg-8">

                        <form:input path="telephone" cssClass="form-control" value="${sttelephone}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Email:</label>
                    <div class="col-lg-8">

                        <form:input path="email" cssClass="form-control" value="${stEmail}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Scholar Year:</label>
                    <div class="col-md-8">

                        <form:input path="scholarYear" cssClass="form-control" value="${stScolarYear}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label"></label>
                    <div class="col-md-8">
                        <input type="submit" value="save changes" class="btn btn-primary btn-sm active"/>
                        <span></span>
                    </div>
                </div>
 </form:form>
        </div>
    </div>
</div>
<hr>