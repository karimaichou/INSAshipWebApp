<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24/01/2017
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h4><span style="color:blue">Validated Applications : </span></h4>

<div class="table-responsive">
    <table class="table">
        <th>
            <tr>
                <td>Offer Id </td>
                <td>Company Id</td>
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
                        ${application.creationDate}
                </td>
                <td>
                <td>
                <td class="text-right"><button class="btn btn-success" type="submit" onclick="location.href='<spring:url value="/#?id=${application.offer_id}"/>'">Agrement</button></td>
                </td>

            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>

