<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23/01/2017
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty error}">
    <div class="alert alert-danger"> ${error}</div>
</c:if>
<c:if test="${not empty success}">
    <div class="alert alert-success"> ${success}</div>
</c:if>

<div class="row">
    <div class="col-md-4">
        <h2>Internship offer</h2>
        <table class="table">
            <tr>
                <td>Title:</td><td style="vertical-align: middle">${offer.title}</td>
            </tr>
            <tr>
                <td>Company:</td><td style="vertical-align: middle">${application.company.username}</td>
            </tr>
            <tr>
                <td>Address:</td><td style="vertical-align: middle">${application.company.address}</td>
            </tr>

        </table>

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
    <c:if test="${application.state == 'AcceptedByCompany'}">
        <div class="col-md-4">
            <h2>Confirmation</h2>
            <p> Finalise you choice of internship.</p>
            <input type="button" value="Confirm internhip" class="btn btn-success" onclick="location.href='/accept?id=${application.id}'">

        </div>
    </c:if>
    <c:if test="${application.state  == 'Sent' || application.state  == 'AcceptedByStudent' || application.state  == 'AcceptedByINSA' }">
        <div class="col-md-4">
            <h2>In progress</h2>
            <p>The application is in the process of acceptation, you will be notified of further development.</p>
        </div>
    </c:if>
    <c:if test="${application.state  == 'UnderAgreement' }">
        <div class="col-md-4">
            <h2>Agreement</h2>

            <c:if test="${application.agreement !=null}">

                <c:if test="${ ! application.agreement.signedByStudent}">
                    <p>Your are now requested to review application and sign the agreement documenet.</p>
                    <input type="button" value="Sign agreement" class="btn btn-success" onclick="location.href='/signAgreement?id=${application.id}'">
                </c:if>
                <c:if test="${application.agreement.signedByStudent}">
                    <p>You have already signed the agreement.</p>

                </c:if>
                <input type="button" value="View agreement" class="btn btn-primary" onclick="location.href='/download?id=${application.id}'">

            </c:if>
        </div>
    </c:if>
    <c:if test="${application.state  == 'Done' }">
    <div class="col-md-4">
        <h2>Agreement</h2>
        <p>The agreement document is signed by all parties. Internship application proccess is successfully finished.</p>
        <input type="button" value="View agreement" class="btn btn-primary" onclick="location.href='/download?id=${application.id}'">
    </div>
    </c:if>

</div>