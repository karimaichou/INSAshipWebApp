<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 08/01/2017
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="color: red">${error}</div>

<form:form commandName="studenttoken" cssClass="form-horizontal">
    <div class="row">
        <div class="col-xs-6 col-md-4">
            <label class="control-label" for="token">Cle de verification</label>
            <form:input path="token" cssclass="form-control" />
            <button type="submit" class="btn btn-success">save</button>
        </div>
    </div>
</form:form>

