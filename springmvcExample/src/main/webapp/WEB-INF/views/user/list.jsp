<%--
  Created by IntelliJ IDEA.
  User: renwujie
  Date: 2018/5/8 0008
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>userList</title>
    <link rel="stylesheet" type="text/css" href="/statics/css/style.css" />
</head>
<br>
<h1>欢迎【${curUser}】登录!</h1>
<a href="/user/add">新增>></a> </br>
<c:forEach var="user" items="${users}">
    ${user.value.id} -- ${user.value.username} -- ${user.value.nickname} -- ${user.value.email}
    <a href="/user/${user.value.username}/show">查看</a>
    | <a href="/user/${user.value.username}/update">修改</a>
    | <a href="/user/${user.value.username}/delete">删除</a><br/>
</c:forEach>
</body>
</html>
