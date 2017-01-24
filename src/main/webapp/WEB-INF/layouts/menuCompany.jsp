<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 1/9/2017
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<li class="${current == 'index' ? 'active' : ''}"><a href="<spring:url value ="/company/index"/>">Home Company</a></li>
<li class="${current == 'offers' ? 'active' : ''}"><a href="<spring:url value ="/company/offers"/>">Offers</a></li>
<li class="${current == 'accepted' ? 'active' : ''}"><a href="<spring:url value ="/company/accepted"/>">Accepted Applications</a></li>
