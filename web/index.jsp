<%--
  Created by IntelliJ IDEA.
  User: xiezh
  Date: 2018/2/24
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/api/item/add" method="post" enctype="multipart/form-data">

    <input type="file" name="photos"/></br>
    <input type="file" name="photos"/></br>
    username:<input type="text" name="username"/></br>
    createbyid:<input type="text" name="createbyid"/></br>
    remark:<input type="text" name="remark"/></br>
    type:<input type="text:" name="type"/></br>
    <input type="submit"/></br>
</form>

</body>
</html>
