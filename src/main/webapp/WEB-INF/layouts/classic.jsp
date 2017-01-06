<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 11/18/2016
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <link href="${pageContext.request.contextPath}/resources/styles/stickyFooter.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/resources/styles/signIn.css" rel="stylesheet" >


        <title><tiles:getAsString name="title"/></title>

    </head>
    <body>
    <%@ taglib  uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilex"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <tiles:insertAttribute name="header"/>
    <tilex:useAttribute name="current"/>
    <div class="container">

        <!--static navbar-->
        <div class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="<spring:url value="/"/>"></a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/"/>'>HOME</a></li>
                        <li class="${current == 'sign-in' ? 'active' : ''}"><a href='<spring:url value="/sign-in"/>'>log in</a></li>
                        <li class="${current == 'example' ? 'active' : ''}"><a href='<spring:url value="/example"/>'>Example</a></li>
                        <li class="${current == 'user-register' ? 'active' : ''}"><a href='<spring:url value="/user-register"/>'>Registration</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <tiles:insertAttribute name="body"/>
    </div>


    </body>
    <tiles:insertAttribute name="footer"/>
</html>
