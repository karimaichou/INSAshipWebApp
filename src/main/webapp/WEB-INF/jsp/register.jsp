<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 11/18/2016
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="${pageContext.request.contextPath}/resources/styles/register.css" rel="stylesheet" >

<div class="box">
    <h1 id="logintoregister">Register</h1>
    <div class="group">
        <input class="inputMaterial" type="text" required>
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>Username</label>
    </div>
    <div class="group">
        <input class="inputMaterial" type="password" required>
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>Password</label>
    </div>
    <div class="group show">
        <input class="inputMaterial" type="password" required>
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>Confirm Password</label>
    </div>
    <div class="group show">
        <input class="inputMaterial" type="text" required>
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>Nom</label>
    </div>
    <div class="group show">
        <input class="inputMaterial" type="text" required>
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>Prénom</label>
    </div>
    <div class="group show">
        <input class="inputMaterial" type="text" required>
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>Email</label>
    </div>

    <button id="buttonlogintoregister">Register</button>
</div>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
