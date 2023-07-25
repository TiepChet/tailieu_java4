<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/03/2023
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section class="container">
    <form action="/giang-vien/add" method="post">

        <label><b>Ma</b></label>
        <input type="text" name="ma">

        <label><b>Ten</b></label>
        <input type="text"  name="ten" >

        <label><b>Tuoi</b></label>
        <input type="number"  name="tuoi" >

        <label><b>Gioi Tinh</b></label>
        <input type="radio"  name="gioiTinh" value="true" checked>Nam
        <input type="radio"  name="gioiTinh" value="false" >Nữ

        <label><b>Dia Chi</b></label>
        <input type="text"  name="diaChi" >

        <button type="submit">Add</button>
        <label></label>

    </form>
</section>

</body>
</html>
