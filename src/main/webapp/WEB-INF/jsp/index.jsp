<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 11/18/2016
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<p>
    How to add a new page:
</p>
<ul>
    <li>create page content in /WEB-INF/jsp/example.jsp</li>
    <li>include /WEB-INF/layouts/taglibs.jsp if you need taglibs</li>
    <li>place new taglibs into /WEB-INF/layouts/taglibs.jsp</li>
    <li>create page tile definition in /WEB-INF/definitions/tiles.xml</li>
    <li>create controller method in @Controller anotated class</li>
    <li>setup proper url mapping and target view (returnValue := viewName)</li>
    <li>create menu item link in /WEB-INF/layouts/menu.jsp</li>
    <li>redeploy and admire your new beautiful page!</li>
</ul>