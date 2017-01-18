<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 08/01/2017
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form class="confirmation" name='confirmation' action="<spring:url value ="/confirmation-compte"/>" method='POST'>
    <!--<h4 class="confirmation-heading">Entrer le code de confirmation que vous avez reçu sur votre adresse email:</h4>-->
    <div class="form-group has-success has-feedback">
        <label class="control-label" for="token">Cle de verification</label>
        <input type="text" class="form-control" id="token" aria-describedby="inputSuccess4Status">
        <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        <span id="inputSuccess4Status" class="sr-only">(success)</span>
    </div>
    <div class="form-group">
        <div class="col-sm-4">
            <button type="submit" class="btn btn-success">save</button>
        </div>
    </div>
</form>