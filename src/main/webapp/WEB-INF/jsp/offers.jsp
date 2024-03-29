<%--
  Created by IntelliJ IDEA.
<<<<<<< Updated upstream
  User: borik
  Date: 11/18/2016
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- Font Awesome -->
<link href="${pageContext.request.contextPath}/resources/styles/font-awesome/css/font-awesome.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="${pageContext.request.contextPath}/resources/styles/custom.css" rel="stylesheet">


    <form method="post" class="form-inline" action="<spring:url value ="/search-offers"/>" modelAttribute="SearchForm" style="text-align: center">
            <label class="sr-only" > internship keywords, or title</label><input type="text" name="keyword" placeholder="internship keywords, or title" class="form-control" autofocus/>
            <button class="btn btn-primary" type="submit">Search</button>
    </form>

<c:if test="${not empty noOffer}">
    <div class="alert alert-danger"> ${noOffer}</div>
</c:if>
<c:if test="${not empty Error}">
    <div class="alert alert-danger"> ${Error}</div>
</c:if>
<c:if test="${not empty success}">
    <div class="alert alert-success"> ${success}</div>
</c:if>
<h2> Available offers (${offers.size()}):</h2>
<div>
                <c:if test="${not empty offers}">
                <c:forEach items="${offers}" var="offer">

                    <%--<tr><td><input type="button"  onclick="location.href='/details?id=${offer.id}'" value="${offer.title}"/> </td></tr>--%>
                    <%--<tr><td>${offer.description}</td></tr>--%>

                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel" style="background-color: #f8f8f8;" >
                                <div class="x_title">
                                    <%--<h2><input type="button"  onclick="location.href='/details?id=${offer.id}'" value="${offer.title}"/></h2>--%>
                                    <a class="lead" onclick="location.href='<spring:url value ="/details?id=${offer.id}&company=${offer.company}"/>'"><img src="${offer.companyLogoUrl}" height="40px" /> ${offer.title}</a>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content" style="display: none;">
                                    <p>${offer.description}</p>
                                </div>
                                <button type="submit" class="btn btn-success" onclick="location.href='<spring:url value ="/details?id=${offer.id}&company=${offer.company}"/>'" style="float:right">View Details</button>
                            </div>
                        </div>
                    </div>


                </c:forEach>
            </c:if>

</div>

<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/resources/styles/js/custom.js"></script>