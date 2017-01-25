<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 11/21/2016
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="taglibs.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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

                <li class="${current == 'offers' ? 'active' : ''}"><a href="<spring:url value ="/offers"/>">Search Offers</a></li>


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
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <security:authorize access="! isAuthenticated()">
                    <li class="${current == 'sign-in' ? 'active' : ''}"><a href="<spring:url value ="/sign-in"/>">Sign in</a></li>
                    <li class="${current == 'register' ? 'active' : ''}"><a href="<spring:url value ="/register"/>">Register</a></li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li class="dropdown">
                        <c:if test="${notifications.size() > 0}">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span style="color: #942a25">New notifications ${notifications.size()}</span><span class="caret"></span></a>
                        </c:if>
                        <c:if test="${notifications.size() == 0}">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Notifications history</a>
                        </c:if>
                        <ul class="dropdown-menu">
                            <li><a href="/notifications">View all notifications</a></li>
                            <li role="separator" class="divider"></li>
                            <c:forEach items="${notifications}" var="notification">
                                <li><a href="#">${fn:substring(notification.message, 0, 25)} ...</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                    <li><a href="<spring:url value ="/logout"/>">Logout</a></li>

                </security:authorize>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>