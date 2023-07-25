<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/03/2023
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>Header</header>
<section>
    <form action="/login" method="post">
        <div class="container">
            <label for="uname"><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="uname">

            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw">

            <button type="submit">Login</button>
            <label>${error}</label>
        </div>
    </form>
</section>
<header>Footer</header>
</body>
</html>
