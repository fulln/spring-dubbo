<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>跳转验证</title>

</head>
<body style="text-align: center;margin-top: 300px;">
<form method="post" action="/TaskWeb/login">
    <h4>登录模块</h4>
    <div>
        <input type="text" name="username" placeholder="用户名">
        <input type="password" name="password" placeholder="密码">
        <input type="submit" value="登录" name="submit">
    </div>
</form>
</body>
<script src="<%=basePath %>js/jquery.min.js" ></script>
<script>
    //获得url数据
    function getUrlItem(){

    var args = {},
    urls = window.location.href;

    if(urls.indexOf('?') > 0){

    var thisDay = urls.substring(urls.indexOf('?')+1,urls.length),
    args = {},
    items = thisDay.split("&"),
    name = null,
    value = null,
    item = null;

    for(var i=0,len=items.length;i<len;i++){

    item = items[i].split("=");
    name = decodeURIComponent(item[0]);
    value = decodeURIComponent(item[1]);
    args[name]=value;

    }
    }
    return args;
    }

</script>
</html>