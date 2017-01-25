<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 21/01/2017
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Notification history : </h2>
<c:if test="${history.size() <= 0}">
    <div class="alert "> You don't have any notifications.</div>
</c:if>
<c:if test="${history.size() > 0}">
    <table class="table">
        <thead>
            <tr>
                <td>Date </td>
                <td>Message </td>

            </tr>
        </thead>
        <tbody>
        <c:forEach items="${history}" var="history">
            <tr>
                <td>
                        ${history.eventDate}
                </td>
                <td>
                        ${history.message}
                </td>

            </tr>

        </c:forEach>
        </tbody>

    </table>
</c:if>