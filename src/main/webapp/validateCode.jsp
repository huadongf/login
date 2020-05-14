<%--
  Created by IntelliJ IDEA.
  User: bb aa
  Date: 2020/5/12
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8"%>
<!-- 展示验证码的页面 -->
<html>
<head>
    <title>验证码</title>
    <!-- 鼠标移入图片,变成手状 -->
    <style type="text/css">
        .s1{
            cursor:pointer;
        }
    </style>
</head>
<body>
<img src="code" onclick="this.src='code?'+Math.random();"
     class="s1" title="点击更换" alt=""/>
</body>
</html>
