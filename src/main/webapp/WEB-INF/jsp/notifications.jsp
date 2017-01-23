<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 21/01/2017
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h4><span style="color:blue">notifications details : </span></h4>
<div class="table-responsive">
    <table class="table">
        <th>
            <tr>
                <td>Date </td>
                <td>Message </td>
                <td>From</td>
            </tr>
        </th>
        <tbody>
        <c:forEach items="${notifdetails}" var="notification">
            <tr>
                <td>
                        ${notification.eventDate}
                </td>
                <td>
                        ${notification.message}
                </td>
                <td>
                        ${notification.application.company.username}
                </td>

            </tr>

        </c:forEach>
        </tbody>

    </table>
</div>