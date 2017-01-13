<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 11/21/2016
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="taglibs.jsp"%>
<tilesx:useAttribute name="current" />

<!-- Static navbar -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<spring:url value ="/"/>">INSAship</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <security:authorize access=" hasRole('ROLE_STUDENT')">
                <li class="${current == 'index' ? 'active' : ''}"><a href="<spring:url value ="/"/>">Home</a></li>
                <li class="${current == 'example' ? 'active' : ''}"><a href="<spring:url value ="/example"/>">Example</a></li>
                <li class="${current == 'offers' ? 'active' : ''}"><a href="<spring:url value ="/offers"/>">Offers</a></li>

                    <%@include file="menuStudent.jsp"%>
                </security:authorize>
                <security:authorize access=" hasRole('ROLE_COMPANY')">
                    <%@include file="menuCompany.jsp"%>
                </security:authorize>
                <security:authorize access=" hasRole('ROLE_FSD')">
                    <%@include file="menuFSD.jsp"%>
                </security:authorize>
                <security:authorize access=" hasRole('ROLE_INSA')">
                    <%@include file="menuINSA.jsp"%>
                </security:authorize>
                <security:authorize access=" hasRole('ROLE_INSA_ADMIN')">
                    <%@include file="menuINSAAdmin.jsp"%>
                </security:authorize>
                <security:authorize access=" hasRole('ROLE_ADMIN')">
                    <%@include file="menuAdmin.jsp"%>
                </security:authorize>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <security:authorize access="! isAuthenticated()">
                    <li class="${current == 'sign-in' ? 'active' : ''}"><a href="<spring:url value ="/sign-in"/>">Sign in</a></li>
                    <li class="${current == 'register' ? 'active' : ''}"><a href="<spring:url value ="/register"/>">Register</a></li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li><a href="<spring:url value ="/indexStudent"/>">Profil</a></li>
                    <li><a href="<spring:url value ="/logout"/>">Logout</a></li>
                </security:authorize>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>