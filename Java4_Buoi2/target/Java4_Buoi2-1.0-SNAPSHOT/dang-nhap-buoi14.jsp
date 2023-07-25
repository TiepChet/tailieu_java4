<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06/04/2023
  Time: 07:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/ket-qua" method="post">

    <div class="container">
        <label ><b>Username</b></label>
        <input type="text" name="uname">

        <label ><b>Password</b></label>
        <input type="password" name="psw">

        <button type="submit">Login</button>
        <span>${error}</span>

    </div>

</form>

</body>
</html>
