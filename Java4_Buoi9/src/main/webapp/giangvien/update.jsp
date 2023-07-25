<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/03/2023
  Time: 07:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<section class="container">
    <form action="/giang-vien/update" method="post">

        <label><b>Id</b></label>
        <input type="number" name="id" value="${gv.id}">

        <label><b>Ma</b></label>
        <input type="text" name="ma" value="${gv.ma}">

        <label><b>Ten</b></label>
        <input type="text" name="ten" value="${gv.ten}">

        <label><b>Tuoi</b></label>
        <input type="number" name="tuoi" value="${gv.tuoi}">

        <label><b>Gioi Tinh</b></label>
        <input type="radio" name="gioiTinh" value="true" checked ${gv.gioiTinh==true?"checked":""}>Nam
        <input type="radio" name="gioiTinh" value="false" ${gv.gioiTinh==false?"checked":""} >Nữ

        <label><b>Dia Chi</b></label>
        <input type="text" name="diaChi" value="${gv.diaChi}">

        <button type="submit">Update</button>

    </form>
</section>

</body>
</html>
