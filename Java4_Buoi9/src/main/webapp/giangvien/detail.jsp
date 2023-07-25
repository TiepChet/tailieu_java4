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
</head>
<body>

<section class="container">
    <form action="/giang-vien/detail" method="get">
        <label><b> Id: </b>${gv.id}</label> <br>
        <label><b> Ma: </b>${gv.ma}</label> <br>
        <label><b> Ten: </b>${gv.ten}</label> <br>
        <label><b> Tuoi: </b>${gv.tuoi}</label> <br>
        <label><b> Gioi Tinh:</b><c:if test="${gv.gioiTinh==true}">Nam</c:if>
            <c:if test="${gv.gioiTinh==false}">Nữ</c:if></label> <br>
        <label><b>Địa Chỉ: </b>${gv.diaChi}</label> <br>
    </form>
</section>

</body>
</html>
