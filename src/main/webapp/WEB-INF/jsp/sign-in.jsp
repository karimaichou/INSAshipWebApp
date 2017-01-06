<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 11/21/2016
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty errorLogin}">
<div class="alert alert-danger"> ${errorLogin}</div>
</c:if>

    <form class="form-signin" name='f' action="/j_spring_security_check" method='POST'>
        <h3 class="form-signin-heading">Please sign in:</h3>
        <input type="text" name="j_username" id="inputUsername" value="${username}" class="form-control" placeholder="User Name" required autofocus>
        <input type="password" name="j_password" id="inputPassword" value="${password}" class="form-control" placeholder="Password" required>
        <input type="checkbox" name="remember"/>Remeber me!<br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>



