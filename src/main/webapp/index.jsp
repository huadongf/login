<%--
  Created by IntelliJ IDEA.
  User: bb aa
  Date: 2020/5/12
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8"%>
<!-- 登录成功后的页面 -->
<%
  //小脚本:session验证
  Object uname = session.getAttribute("uname");
  if(uname == null){
    //重定向到login.jsp
    response.sendRedirect("login.jsp");
    return;
  }
%>

<html>
<head>

  <title>欢迎光临</title></head>

<body>
<h1>欢迎登录:<%=uname.toString() %></h1>
<a href="index.jsp">退出</a>
</body>
</html>

