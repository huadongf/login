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
    <title>登录</title>
    <link rel="stylesheet" media="all" href="./css/ak.css" />
    <link rel="stylesheet" media="all" href="./css/ac.css" />
</head>
<body class="no-padding reader-black-font" lang="zh-CN">
<div class="sign">
    <div class="main">
        <div class="js-sign-in-container">
            <form  action="/session/login.do" method="post" />
                <!-- 正常登录登录名输入框 -->
                <div class="input-prepend restyle js-normal">
                    <input placeholder="用户名"  name="uname"  />
                    <i class="iconfont ic-user"></i>
                </div>
                <div class="input-prepend">
                    <input placeholder="密码" type="password" name="pwd"  />
                    <i class="iconfont ic-password"></i>
                </div>
                <input placeholder="验证码" name="vcode"  />
                <img src="code" onclick="this.src='code?'+Math.random();"
                     class="s1" title="点击更换（验证码区分大小写)"/><br/>
                <button class="sign-in-button" id="sign-in-form-submit-btn" type="submit">
                    <span id="sign-in-loading"></span>
                    登录
                </button>
        </div>
    </div>
</div>
</body>