<%--
  Created by IntelliJ IDEA.
  User: Aymene
  Date: 13/01/2017
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Font Awesome -->
<link href="${pageContext.request.contextPath}/resources/styles/font-awesome/css/font-awesome.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="${pageContext.request.contextPath}/resources/styles/custom.css" rel="stylesheet">


FSD welcome page !

<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel" style="background-color: #f8f8f8;" >
            <div class="x_title">
                <%--<h2><input type="button"  onclick="location.href='/details?id=${offer.id}'" value="${offer.title}"/></h2>--%>
                <h4>
                    <%--<a onclick="location.href='/details?id=${offer.id}'"> ${offer.title}</a>--%>
                    Titre
                </h4>
                <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>
                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <form method="post" action="/fsd/index">
                <div class="x_content">
                    <div class="row">
                        <div class="col-md-10 col-sm-10 col-xs-10">
                            <p>
                                <%--${offer.description}--%>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                                    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                                    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                            </p>
                        </div>
                        <div class="col-md-2 col-sm-2 col-xs-2">
                            <input type="radio" name="choix" value="accepter"> Accepter<br>
                            <input type="radio" name="choix" value="rejeter"> Rejeter<br>
                        </div>
                    </div>
                        <button type="submit" class="btn btn-success" onclick="location.href='/details?id=${offer.id}'" style="float:right">Valider</button>
                </div>
            </form>
        </div>
    </div>
</div>

<c:if test="${not empty noApplication}">
    <div class="alert alert-danger"> ${noApplication}</div>
</c:if>

<div>
    <c:if test="${not empty applications}">
        <c:forEach items="${applications}" var="app">

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel" style="background-color: #f8f8f8;" >
                        <div class="x_title">
                                <%--<h2><input type="button"  onclick="location.href='/details?id=${offer.id}'" value="${offer.title}"/></h2>--%>
                            <h4>
                                    <%--<a onclick="location.href='/details?id=${offer.id}'"> ${offer.title}</a>--%>
                                Titre: ${app.student.lastName} (${app.company.username})
                            </h4>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <form method="post" action="/fsd/valider?id=${app.offerId}">
                            <div class="x_content">
                                <div class="row">
                                     <div class="col-md-10 col-sm-10 col-xs-10">
                                        <p>
                                                ${app.message}
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                                            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                                            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                                        </p>
                                    </div>
                                     <div class="col-md-2 col-sm-2 col-xs-2">
                                         <input type="radio" name="choix" value="accepter"> Accepter<br>
                                         <input type="radio" name="choix" value="rejeter"> Rejeter<br>
                                     </div>
                                </div>
                                <button type="submit" class="btn btn-success" style="float:right">Valider</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </c:forEach>
    </c:if>

</div>

<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/resources/styles/js/custom.js"></script>