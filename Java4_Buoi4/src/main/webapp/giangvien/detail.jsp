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

<label>id: ${gv.id}</label>
<br>
<label>mã: ${gv.ma}</label>
<br>
<label>tên: ${gv.ten}</label>
<br>
<label>tuổi: ${gv.tuoi}</label>
<br>
<label>Địa chỉ: ${gv.diaChi}</label>
<br>
<label>Giới tính: ${gv.gioiTinh?"Nam":"Nữ"}</label>

<br>
<footer>Footer</footer>

</body>
</html>
