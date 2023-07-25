<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/04/2023
  Time: 23:19
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
    <form action="/thuc-vat/detail" method="get">
        <label>Tên: ${tv.ten} </label> <br>
        <label>Tuổi: ${tv.tuoi}</label> <br>
        <label>Giới tính:
            <c:if test="${tv.gioiTinh==true}">Nam</c:if>
            <c:if test="${tv.gioiTinh==false}">Nữ</c:if>
        </label> <br>
        <label>Khu vực sống: ${tv.khuVucSong}</label> <br>
        <label>loại: ${tv.loai}</label> <br>
    </form>
</section>


</body>
</html>
