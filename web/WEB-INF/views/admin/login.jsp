<%--
  Created by IntelliJ IDEA.
  User: 7025
  Date: 2017/10/20
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%=path %>/admin/login" method="post">
        <input type="text" name="name" >
        <input type="password" name="password">
        <input type="submit" value="登录" />
    </form>
</body>
</html>
