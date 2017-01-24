<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23/01/2017
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${not empty noApplication}">
    <div class="alert "> ${noApplication}</div>
</c:if>

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
                <td></td>
            </tr>
        </th>
        <tbody>
        <c:forEach items="${applications}" var="application">
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
                <td>
                <td>
                <td class="text-right"><button class="btn btn-success" type="submit" onclick="location.href='<spring:url value="/detail?id=${application.offer_id}"/>'">Validate</button></td>
                </td>

                </tr>

        </c:forEach>
        </tbody>
    </table>
    </div>
