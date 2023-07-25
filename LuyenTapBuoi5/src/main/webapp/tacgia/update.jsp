<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/04/2023
  Time: 15:29
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
    <form action="/tac-gia/update" method="post">
        <label>Tên</label>
        <input type="text" name="ten" value="${tg.ten}">

        <label>Tuổi</label>
        <input type="number" name="tuoi" value="${tg.tuoi}">

        <label>Giới Tính</label>
        <input type="radio" name="gioiTinh" value="true" ${tg.gioiTinh==true?"checked":""} checked>Nam
        <input type="radio" name="gioiTinh" value="false" ${tg.gioiTinh==false?"checked":""} >Nữ

        <label>Loại</label>
        <select name="loai">
            <option selected value="tre em" ${tg.loaiSachViet=="tre em"?"selected":""} >Trẻ em</option>
            <option value="truyen"  ${tg.loaiSachViet=="truyen"?"selected":""}>Truyện</option>
            <option value="giao duc"  ${tg.loaiSachViet=="giao duc"?"selected":""}>Giáo Dục</option>
        </select>

        <button type="submit">Update</button>
    </form>
</section>

</body>
</html>
