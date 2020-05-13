<%--
  Created by IntelliJ IDEA.
  User: bb aa
  Date: 2020/5/12
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="utf-8"%>
<!-- 登录显示的页面 -->
<%
    Object msg = request.getAttribute("msg");
    if(msg!=null){
%>
<%=msg.toString() %>
<%} %>
<html>
<head>

</head>

<body>
<form action="login.do" method="post">
    用户名:<input name="uname"/></br>
    密码:<input name = "pwd" type="password"/> </br>
    验证码:<input name="vcode"/>
    <img src="code" onclick="this.src='code?'+Math.random();"
         class="s1" title="点击更换"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
