<%--
  Created by IntelliJ IDEA.
  User: karima
  Date: 18/01/2017
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty error}">
    <div class="alert alert-danger"> ${error}</div>
</c:if>

agreement content page ${agreementName}

<a href="/download">download</a>