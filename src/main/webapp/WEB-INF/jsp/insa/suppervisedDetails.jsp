<%--
  Created by IntelliJ IDEA.
  User: karima
  Date: 23/01/2017
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    from :${application.student.firstName} ${application.student.lastName}<br>
    Internship From: ${application.company.username}, Applied the: ${application.creationDate}<br>
    Application Status: ${application.state}<br>

    <c:if test="${application.agreement !=null}">
        <input type="button" value="view the agreement" class="btn btn-danger" onclick="location.href='/download?id=${application.id}'">
        <c:if test="${ ! application.agreement.signedByInsa}">
            <input type="button" value="sign the agreement" class="btn btn-success" onclick="location.href='/insa/signAgreement?id=${application.id}'">
        </c:if>
        <c:if test="${application.agreement.signedByInsa}">
            <label>You already Signed The application</label>
        </c:if>
    </c:if>

</div>