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

<header>Header</header>
<br>
<form action="" method="post">

    <div class="container">
        <label><b>id</b></label>
        <input type="number" name="id" value="${gv.id}">

        <label><b>Ma</b></label>
        <input type="text" name="ma" value="${gv.ma}">

        <label><b>Ten</b></label>
        <input type="text" name="ten" value="${gv.ten}">

        <label><b>Tuoi</b></label>
        <input type="number" name="tuoi" value="${gv.tuoi}">

        <label><b>Dia Chi</b></label>
        <input type="text" name="diaChi" value="${gv.diaChi}">

        <label>Giới tính</label>
        <input type="radio" name="gioiTinh" value=true checked
        ${gv.gioiTinh==true? "checked" : "" }>
        <label>Nam</label>
        <input type="radio" name="gioiTinh" value=false
        ${!gv.gioiTinh==false? "checked" :"" }>
        <label>Nữ</label><br>
        <button type="submit">Update</button>
    </div>
</form>
<br>

<footer>Footer</footer>

</body>
</html>
