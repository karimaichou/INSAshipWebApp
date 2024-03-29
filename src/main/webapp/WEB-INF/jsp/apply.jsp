<%--
  Created by IntelliJ IDEA.
  User: karima
  Date: 08/01/2017
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<style>
    .btn-file {
        position: relative;
        overflow: hidden;
    }
    .btn-file input[type=file] {
        position: absolute;
        top: 0;
        right: 0;
        min-width: 100%;
        min-height: 100%;
        font-size: 100px;
        text-align: right;
        filter: alpha(opacity=0);
        opacity: 0;
        outline: none;
        background: white;
        cursor: inherit;
        display: block;
    }

</style>
<div>
    <form method="post" class="form-signin" action="<spring:url value ="/apply"/>" modelAttribute="ApplicationForm" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${offer.id}">
        <input type="hidden" name="company" value="${offer.company}">
        <input type="email" name="email" value="${email}"  class="form-control" >
        <input type="text" name="prenom" value="${prenom}" class="form-control">
        <input type="text" name="nom" value="${nom}" class="form-control">
        <input type="file"  class="form-control" name="files[0]">
        <input type="file"  class="form-control" name="files[1]">
        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Apply">
    </form>


</div>