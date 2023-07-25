<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/03/2023
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section class="container">
    <form action="/giang-vien/update" method="post">

        <label><b>Ma</b></label> <br>
        <input type="text" name="ma" value="${gv.ma}"> <br>

        <label><b>Ten</b></label> <br>
        <input type="text" name="ten" value="${gv.ten}"> <br>

        <label><b>Tuoi</b></label> <br>
        <input type="number" name="tuoi" value="${gv.tuoi}"> <br>

        <label><b>Gioi Tinh</b></label> <br>
        <input type="radio" name="gioiTinh" value="true" checked ${gv.gioiTinh==true?"checked":""}> Nam
        <input type="radio" name="gioiTinh" value="false"  ${gv.gioiTinh==false?"checked":""}> Nữ <br>


        <label><b>Quê Quán</b></label> <br>
        <input type="text" name="queQuan" value="${gv.queQuan}"> <br>

        <button type="submit">Update</button>
    </form>
</section>

</body>
</html>
