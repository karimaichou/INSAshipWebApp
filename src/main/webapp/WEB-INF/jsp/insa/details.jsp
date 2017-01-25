<%--
  Created by IntelliJ IDEA.
  User: karima
  Date: 14/01/2017
  Time: 01:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty error}">
    <div class="alert alert-danger"> ${error}</div>
</c:if>
<c:if test="${not empty success}">
    <div class="alert alert-danger"> ${success}</div>
</c:if>
<c:if test="${empty error}">
<!--
    <div >
        <div style="float: left;">
            <h3>Student : </h3>
            <div><label>Name: ${student.firstName} ${student.lastName}</label></div>
            <div><label>sex: ${student.sex} </label></div>
            <div><label>Student at the : ${student.scholarYear} Year</label></div>
            <div><label>Email: ${student.email} </label></div>
            <div><label>Name: ${student.telephone}</label></div>
            <div><label>Adress: ${student.address} </label></div>
        </div>
        <div >
            <h3>Company:</h3>
            <div><label>Name: ${company.username} </label></div>
            <div><label>Adress: ${company.address} </label></div>
            <div><label>Phone Number: ${company.telephone} </label></div>
            <div><label>Email: ${company.email} </label></div>
        </div>
    </div>
    <div >
        <h3>Internship Offer : </h3>
        <div><label>Title : ${offer.title} </label></div>
        <div><label>Description : ${offer.description} </label></div>
        <div><label>Start Date : ${offer.startDate} </label></div>
        <div><label><c:if test="${!fsd}"> this Offer does not require an FSD procedure</c:if>
            <c:if test="${fsd}"> this Offer does  require an FSD procedure</c:if></label></div>
    </div>
-->
</c:if>

<div class="row">

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
    <div class="col-md-4">
        <h2>Company</h2>
        <table class="table">
            <tr>
                <td>Name:</td><td style="vertical-align: middle">${company.username} ${application.student.lastName}</td>
            </tr>
            <tr>
                <td>E-mail:</td><td style="vertical-align: middle">${company.email}</td>
            </tr>
            <tr>
                <td>Telephone:</td><td style="vertical-align: middle">${company.telephone}</td>
            </tr>
            <tr>
            <tr>
                <td>Address:</td><td style="vertical-align: middle">${company.address}</td>
            </tr>

        </table>
    </div>
    <div class="col-md-4">
        <h2>Internship</h2>
        <p>${offer.title}</p>
        <div>
            <input type="button" value="Accept application" class="btn btn-success" onclick="location.href='/insa/approve?id=${application.id}'">
            <input type="button" value="Refuse" class="btn btn-danger" onclick="location.href='/insa/refuse?id=${application.id}'">
        </div>
    </div>
</div>