<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/03/2023
  Time: 07:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<section class="container">
    <form action="/login/hien-thi" method="post">
        <div class="container">
            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="username">

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password">

            <button type="submit">Login</button>
            <label>${error}</label>
        </div>
    </form>
</section>

</body>
</html>
