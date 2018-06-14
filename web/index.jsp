<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 7025
  Date: 2017/10/19
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
<shiro:hasPermission name="user:login">
  user:login
</shiro:hasPermission>
<shiro:hasRole name="root">
  root
</shiro:hasRole>

  <shiro:hasPermission name="admin:login">
    admin:login
  </shiro:hasPermission>
  <shiro:hasRole name="admin">
    admin
  </shiro:hasRole>
  </body>
</html>
