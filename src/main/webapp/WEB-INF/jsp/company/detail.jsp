<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 11/18/2016
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:if test="${not empty error}">
    <div class="alert alert-danger"> ${error}</div>
</c:if>
<c:if test="${not empty success}">
    <div class="alert alert-success"> ${success}</div>
</c:if>


<div class="row">
    <div class="col-md-4">
    <h2>Your Offer</h2>
    <p>${offer.title}</p>
    <button type="button" class="btn btn-primary " onclick="location.href='<spring:url value="/company/meeting" />'">Request meeting</button>

    </div>
    <div class="col-md-4">
        <h2>Student</h2>
        <table class="table">
            <tr>
                <td>Name:</td><td style="vertical-align: middle">${application.student.firstName} ${application.student.lastName}</td>
            </tr>
            <tr>
                <td>Year:</td><td style="vertical-align: middle">${application.student.scholarYear}</td>
            </tr>
            <tr>
            <td>E-mail:</td><td style="vertical-align: middle">${application.student.email}</td>
            </tr>
            <tr>
            <tr>
                <td>Date applied:</td><td style="vertical-align: middle">${application.creationDate}</td>
            </tr>

        </table>
    </div>
    <c:if test="${application.state == 'Sent'}">
    <div class="col-md-4">
        <h2>FSD</h2>
        <p style="${select == 1 ? 'color:red': ''}" >Before acceptation, please choose the apropriate security procedure:</p>
        <form:form action="/company/accept" method="post" commandName="fsd" cssClass="form-signin" data-toggle="validator">
            <form:select path="id" cssClass="form-control">
                <form:options items="${mapFSDs}" />
            </form:select>
            <br/>
            <button type="submit" class="btn btn-success ${application.state != 'Sent' ? 'disabled':''}" value="Submit">Accept Student</button>
            <button type="button" class="btn btn-danger ${application.state != 'Sent' ? 'disabled':''}" onclick="location.href='<spring:url value="/company/reject"/>'">Reject</button>
        </form:form>
    </div>
    </c:if>
    <c:if test="${application.state  == 'AcceptedByCompany' || application.state  == 'AcceptedByStudent' || application.state  == 'AcceptedByINSA' }">
    <div class="col-md-4">
        <h2>In progress</h2>
        <p>The application is in the process of acceptation, you will be notified of further development.</p>
    </div>
    </c:if>
    <c:if test="${application.state  == 'UnderAgreement' }">
        <div class="col-md-4">
            <h2>Agreement</h2>

            <c:if test="${application.agreement !=null}">

                <c:if test="${ ! application.agreement.signedByCompany}">
                    <p>Your are now requested to review application and sign the agreement documenet.</p>
                    <input type="button" value="Sign agreement" class="btn btn-success" onclick="location.href='/company/signAgreement?id=${application.id}'">
                </c:if>
                <c:if test="${application.agreement.signedByCompany}">
                    <p>You have already signed the agreement.</p>

                </c:if>
                <input type="button" value="View agreement" class="btn btn-primary" onclick="location.href='/download?id=${application.id}'">

            </c:if>
        </div>
    </c:if>
</div>