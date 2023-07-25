<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/03/2023
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">

    <div class="container">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname">
        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw">
        <button type="submit">Login</button>
        <label>${error}</label>
    </div>
</form>
</body>
</html>
