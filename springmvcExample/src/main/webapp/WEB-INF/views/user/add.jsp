<%--
  Created by IntelliJ IDEA.
  User: renwujie
  Date: 2018/5/9 0009
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
<%-- 文件域，即上传文件时一定记得加enctype属性 --%>
<%--<sf:form action="/user/add" method="post" modelAttribute="user" enctype="multipart/form-data">--%>
<sf:form action="/user/upload" method="post" modelAttribute="user" enctype="multipart/form-data">
    编号：<sf:input path="id" /> <br/>
    用户名：<sf:input path="username" /> <sf:errors path="username"/> <br/>
    昵称：<sf:input path="nickname" /> <sf:errors path="nickname"/> <br/>
    email：<sf:input path="email" /> <sf:errors path="email"/> <br/>
    <input type="file" name="photo" /> <br/>
    <input type="file" name="photo" /> <br/>
    <input type="file" name="photo" /> <br/>
    <sf:button>确定添加用户</sf:button>
</sf:form>
</body>
</html>
