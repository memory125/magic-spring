<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>拦截器</title>
  </head>
  <body>
    <a href="${pageContext.request.contextPath}/i1">拦截器测试</a>

    <h1>用户登陆测试</h1>
    <a href="${pageContext.request.contextPath}/user/main">首页</a>
    <a href="${pageContext.request.contextPath}/user/tologin">登录</a>
  </body>
</html>
