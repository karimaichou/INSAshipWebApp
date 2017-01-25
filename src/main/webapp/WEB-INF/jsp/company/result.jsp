<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 11/18/2016
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>${result}
</h2>

<p>${message}</p>

<form class="form-horizontal" >
<div class="form-group">
<label class="col-sm-2 control-label">Student:</label>
<div class="col-sm-10">
<p class="form-control-static">${application.student.firstName} ${application.student.lastName}</p>
</div>
</div>
<div class="form-group">
<label class="col-sm-2 control-label">Year:</label>
<div class="col-sm-10">
<p class="form-control-static">${application.student.scholarYear}</p>
</div>
</div>
<div class="form-group">
<label class="col-sm-2 control-label">Created:</label>
<div class="col-sm-10">
<p class="form-control-static">${application.creationDate} </p>
</div>
</div>
</form>