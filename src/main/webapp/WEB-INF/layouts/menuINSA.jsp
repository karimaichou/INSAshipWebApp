<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 1/9/2017
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<li class="${current == 'home' ? 'active' : ''}"><a href="<spring:url value ="/insa/home"/>">Home</a></li>
<li class="${current == 'offers' ? 'active' : ''}"><a href="<spring:url value ="/insa/offers"/>">Student applications</a></li>
