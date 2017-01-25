<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23/01/2017
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="form-horizontal" >
<h4>${application.student.firstName}</h4> <p>Are you sure you want to validate this application</p>
<button type="button" class="btn btn-danger"  onclick="location.href='<spring:url value="/showApplications"/>'">Return</button>
<button type="button" class="btn btn-success"  onclick="location.href='<spring:url value="/accept"/>'">Accept</button>
</form>