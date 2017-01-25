<%--
  Created by IntelliJ IDEA.
  User: karima
  Date: 23/01/2017
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty error}">
    <div class="alert alert-danger"> ${error}</div>
</c:if>
<div>
<center><B><u>Online signing Privacy Policy :</u></B></center>
    This Privacy Policy describes DocuSign, Inc.’s information collection and use practices. This Privacy Policy refers to DocuSign Inc. as “we,” “us,” or “our,” and refers to the reader as “you” or “user.”  If you access or use our websites, including docusign.com and docusign.net, our mobile applications, our Web client or Professional client, and/or any of our other sites, products, or services that link to this Privacy Policy (“Services”), you consent to our collection and use of your information as described in this Privacy Policy, including that your information may be transferred to and stored in the United States.  IF YOU DO NOT AGREE TO THIS PRIVACY POLICY, PLEASE DO NOT USE THE SERVICES.

    The agreement that governs your subscription (or that of your organization) to DocuSign services, such as DocuSign Signature, may include specific information use provisions that are different from or more restrictive than those described within this Privacy Policy.  Please refer to your individual agreement with DocuSign to check for any specific information privacy terms that may also apply to the information you provide to DocuSign in connection with your use of that particular service.
</div>
<form method="post" action="/signAgreement"  modelAttribute="SigningForm">
    <input type="hidden" name="agreement" value="${agreement}">
    <label>Enter your correct Username :</label><input type="text" placeholder="Username" name="username" >
    <input type="submit" class="btn btn-success" value="sign">

</form>
