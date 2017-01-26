<%--
  Created by IntelliJ IDEA.
  User: Aymene
  Date: 13/01/2017
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- Font Awesome -->
<link href="${pageContext.request.contextPath}/resources/styles/font-awesome/css/font-awesome.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="${pageContext.request.contextPath}/resources/styles/custom.css" rel="stylesheet">



<c:if test="${not empty noApplication}">
    <div class="alert alert"> ${noApplication}</div>
</c:if>
<c:if test="${not empty success}">
    <div class="alert alert-success"> ${success}</div>
</c:if>


<div style="padding-left: 50px;padding-right: 50px">
    <c:if test="${not empty applications}">
        <c:forEach items="${applications}" var="app">

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel" style="background-color: #f8f8f8;" >
                        <div class="x_title">
                                <%--<h2><input type="button"  onclick="location.href='/details?id=${offer.id}'" value="${offer.title}"/></h2>--%>
                            <h4>
                                    <%--<a onclick="location.href='/details?id=${offer.id}'"> ${offer.title}</a>--%>
                                Application #${app.id}: ${app.student.lastName} -> (${app.company.username})
                            </h4>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>

                            <div class="x_content">
                                <div class="row">
                                     <div class="col-md-12 col-sm-12 col-xs-12">
                                         <table class="table table-hover">
                                             <tr>
                                                 <th>#</th>
                                                 <td style="vertical-align: middle">${app.id} </td>
                                             </tr>
                                             <tr>
                                                 <th>Student</th>
                                                 <td style="vertical-align: middle">${app.student.firstName} ${app.student.lastName}</td>                                             </tr>
                                             <tr>
                                                 <th>Company</th>
                                                 <td style="vertical-align: middle">${app.company.username}</td>
                                             </tr>
                                             <tr>
                                                 <th>Created</th>
                                                 <td style="vertical-align: middle">${app.creationDate}</td>
                                             </tr>
                                             <tr>
                                                 <th>State</th>
                                                 <td style="vertical-align: middle">${app.state.toString() == 'ValidatedByStudent' ? 'Validated by student' : 'Validated by INSA'}</td>
                                             </tr>
                                         </table>
                                    </div>
                                    <%-- <div class="col-md-2 col-sm-2 col-xs-2">
                                         <input type="radio" name="choix" value="accepter"> Accepter<br>
                                         <input type="radio" name="choix" value="rejeter"> Rejeter<br>
                                     </div>--%>
                                </div>
                                <button type="submit" class="btn btn-success" onclick="location.href='<spring:url value ="/fsd/details?id=${app.id}&offer_id=${app.offer_id}&company=${app.company.id}"/>'" style="float:right">Plus de détails</button>
                            </div>

                    </div>
                </div>
            </div>

        </c:forEach>
    </c:if>

</div>

<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/resources/styles/js/custom.js"></script>