<%--
  Created by IntelliJ IDEA.
  User: bb aa
  Date: 2020/5/12
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8"%>
<%
  Object uname = session.getAttribute("uname");
  if(uname == null){
    //判断是否已经登录
    response.sendRedirect("login.jsp");
    return;
  }
%>
<html>
<head>
  <title>欢迎光临</title></head>
<body>
<h1>登录成功!:<%=uname.toString() %></h1>
<a href="login.jsp">退出</a>
</body>
</html>

