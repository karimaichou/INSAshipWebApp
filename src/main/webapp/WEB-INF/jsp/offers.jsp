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

<div>
    <form method="post" class="form-signin" action="/search-offers">
    <label class="sr-only" > internship keywords, or title</label><input type="text" name="keyword" placeholder="internship keywords, or title" class="form-control" autofocus/>
    <label class="sr-only">Company: </label><input type="text" name="comapny" class="form-control" placeholder="Company" >
    <label class="sr-only">Scholar year: </label><input type="text" name="year" class="form-control" placeholder="Scholar year" >
    <label class="sr-only">Location: </label><input type="text" name="location" class="form-control" placeholder="Location" >
    <button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
</form>
</div>
<c:if test="${not empty noOffer}">
    <div class="alert alert-danger"> ${noOffer}</div>
</c:if>
<c:if test="${not empty success}">
    <div class="alert alert-success"> ${success}</div>
</c:if>
<h2> Neweast Offers:</h2>
<div>
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>title</th>

            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty offers}">
                <c:forEach items="${offers}" var="offer">
                    <tr>
                        <tr><td><input type="button"  onclick="location.href='/details?id=${offer.id}'" value="${offer.title}"/> </td></tr>
                        <tr><td>${offer.description}</td></tr>
                    </tr>
                </c:forEach>
            </c:if>
        </tbody>


    </table>
</div>
