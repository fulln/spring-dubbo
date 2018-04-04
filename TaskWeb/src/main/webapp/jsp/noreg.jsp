<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/2 0002
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@page session="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>用户权限</title>
</head>
<body><div style="text-align: center">
用户没有权限
<br />
<a href="<c:url value='/home/login'/>" >
    点击这里切换用户</a>
</div>
</body>
</html>