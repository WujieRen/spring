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
</head>
<body>
<c:forEach var="user" items="${users}">
    ${user.value.id} -- ${user.value.username} -- ${user.value.nickname} -- ${user.value.email} <br/>
</c:forEach>
</body>
</html>
