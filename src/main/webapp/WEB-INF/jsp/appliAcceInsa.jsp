<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23/01/2017
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h4><span style="color:blue">Accepted Applications : </span></h4>
<div class="table-responsive">
    <table class="table">
        <th>
            <tr>
                <td>Offer Id </td>
                <td>Company Id</td>
                <td>Details </td>
                <td>Meeting request</td>
                <td>Is_FSD</td>
                <td>Creation Date</td>
            </tr>
        </th>
        <tbody>
        <c:forEach items="${applicationsAccepted}" var="application">
            <tr>
                <td>
                        ${application.offer_id}
                </td>
                <td>
                        ${application.company.username}
                </td>
                <td>
                        ${application.message}
                </td>
                <td>
                        ${application.meetingRequest}
                </td>
                <td>
                        ${application.FSDProcedure}
                </td>
                <td>
                        ${application.creationDate}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
