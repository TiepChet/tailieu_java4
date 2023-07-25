<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/03/2023
  Time: 03:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/category/update" method="post">

    <label><b>Username</b></label>
    <input type="text" name="id" value="${category.id}">

    <label><b>Username</b></label>
    <input type="text" name="categoryCode" value="${category.categoryCode}">

    <label><b>Password</b></label>
    <input type="text" name="categoryName" value="${category.categoryName}">

    <button type="submit">Update</button>
</form>

</body>
</html>
