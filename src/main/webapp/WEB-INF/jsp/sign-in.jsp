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

    <form class="form-signin" name='f' action='/sign-in' method='POST'>
        <h3 class="form-signin-heading">Please sign in:</h3>
        <label for="inputUsername" class="sr-only">User Name</label>
        <input type="text" name="username" id="inputUsername" value="${username}" class="form-control" placeholder="User Name" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" value="${password}" class="form-control" placeholder="Password" required>
        <input type="checkbox" name="remember"/>Remeber me!<br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>



