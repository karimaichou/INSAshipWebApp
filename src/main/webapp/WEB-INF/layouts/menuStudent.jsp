<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 1/9/2017
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<li class="${current == 'showApplications' ? 'active' : ''}"><a href="<spring:url value ="/showApplications"/>">My applications</a></li>
<li class="${current == 'indexStudent' ? 'active' : ''}"><a href="<spring:url value ="/indexStudent"/>">Profile</a></li>


