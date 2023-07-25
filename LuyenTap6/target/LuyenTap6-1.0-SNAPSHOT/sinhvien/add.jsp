<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/04/2023
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section>
    <form action="/sinh-vien/add" method="post">
        <label>Tên</label>
        <input type="text" name="ten">

        <label>Tuổi</label>
        <input type="number" name="tuoi">

        <label>Giới Tính</label>
        <input type="radio" name="gioiTinh" value="true" checked>Nam
        <input type="radio" name="gioiTinh" value="false" >Nữ

        <label>Địa Chỉ</label>
        <input type="text" name="diaChi">

        <label>Kỳ Học</label>
        <select name="kyHoc">
            <option selected value="1">Kỳ Học 1</option>
            <option value="2">Kỳ Học 2</option>
            <option value="3">Kỳ Học 3</option>
            <option value="4">Kỳ Học 4</option>
        </select>

        <br>
        <button type="submit">ADD</button>
    </form>
</section>

</body>
</html>
