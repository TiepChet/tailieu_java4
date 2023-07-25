<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/03/2023
  Time: 06:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section>
    <form action="" method="post">
        <label>Id</label><br>
        <input type="number" name="id" value="${gv.id}"><br>
        <label>Ma</label><br>
        <input type="text" name="ma" value="${gv.ma}"><br>
        <label>Ten</label><br>
        <input type="text" name="ten" value="${gv.ten}"><br>
        <label>Tuoi</label><br>
        <input type="number" name="tuoi" value="${gv.tuoi}"><br>
        <label>Que Quan</label><br>
        <input type="text" name="queQuan" value="${gv.queQuan}"><br>
        <button><a>Update</a></button>
    </form>
</section>


</body>
</html>
