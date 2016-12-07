<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 11/18/2016
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <thead>
        <tr>
            <th>id</th>
            <th>title</th>

        </tr>
    </thead>
    <tbody>
        <c:forEach items="${offers}" var="offer">
            <tr>
                <td>${offer.id}</td>
                <td>${offer.title}</td>

            </tr>
        </c:forEach>
    </tbody>


</table>