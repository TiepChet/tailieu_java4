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
    <form action="/sinh-vien/update" method="post">
        <label>Tên</label>
        <input type="text" name="ten" value="${sv.ten}">

        <label>Tuổi</label>
        <input type="number" name="tuoi" value="${sv.tuoi}">

        <label>Giới Tính</label>
        <input type="radio" name="gioiTinh" value="true" ${sv.gioiTinh==true?"checked":""} checked>Nam
        <input type="radio" name="gioiTinh" value="false" ${sv.gioiTinh==false?"checked":""}>Nữ

        <label>Địa Chỉ</label>
        <input type="text" name="diaChi" value="${sv.diaChi}">

        <label>Kỳ Học</label>
        <select name="kyHoc">
            <option selected value="1" ${sv.kyHoc==1?"selected":""}>Kỳ Học 1</option>
            <option value="2" ${sv.kyHoc==2?"selected":""}>Kỳ Học 2</option>
            <option value="3" ${sv.kyHoc==3?"selected":""}>Kỳ Học 3</option>
            <option value="4" ${sv.kyHoc==4?"selected":""}>Kỳ Học 4</option>
        </select>

        <br>
        <button type="submit">Update</button>
    </form>
</section>


</body>
</html>
