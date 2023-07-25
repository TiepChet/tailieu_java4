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
    <form action="/sinh-vien/detail" method="get">
        <label>Ma: ${sv.ma}</label>
        <label>Ten: ${sv.ten}</label>
        <label>Tuoi: ${sv.tuoi}</label>
        <label>Gioi Tinh:
            <c:if test="${sv.gioiTinh==true}">Nam</c:if>
            <c:if test="${sv.gioiTinh==false}">Nữ</c:if>
        </label>
        <label>Dia Chi: ${sv.diaChi}</label>
        <label>Học Kỳ:
            <c:if test="${sv.kyHoc==1}">Học kỳ 1</c:if>
            <c:if test="${sv.kyHoc==2}">Học kỳ 2</c:if>
            <c:if test="${sv.kyHoc==3}">Học kỳ 3</c:if>
            <c:if test="${sv.kyHoc==4}">Học kỳ 4</c:if>
        </label>
    </form>
</section>

</body>
</html>
