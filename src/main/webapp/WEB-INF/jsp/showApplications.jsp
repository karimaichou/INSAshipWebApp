<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 16/01/2017
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<h2>All applications : </h2>
<c:if test="${applications.size() <= 0}">
    <div class="alert "> You don't have any applilcations.</div>
</c:if>
<c:if test="${applications.size() > 0}">
    <a href="/appliAcceCompany" class="btn btn-primary btn-sm active" role="button">Accepted by company</a>
    <a href="/appliAcceInsa" class="btn btn-primary btn-sm active" role="button">Accepted by Insa</a>
    <a href="/validatedBystudent" class="btn btn-primary btn-sm active" role="button">Validated Applications</a>

    <table class="table">
        <thead>
        <tr>
            <td>Offer Id </td>
            <td>Details </td>
            <td>Meeting request</td>
            <td>Is_FSD</td>
            <td>Creation Date</td>
            <td>State </td>
            <td>Company Id</td>
            </tr>
        </thead>
       <tbody>
           <c:forEach items="${applications}" var="application">
               <tr>
                    <td>
                        ${application.offer_id}
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
                           ${application.state}
                   </td>
                   <td>
                           ${application.company.username}
                   </td>
               </tr>

           </c:forEach>
       </tbody>
    </table>

</c:if>