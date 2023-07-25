<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/04/2023
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section>
    <form action="/khach-hang/update" method="post">
        <label>Ma</label>
        <input type="text" name="ma" value="${kh.ma}">

        <label>Ten</label>
        <input type="text" name="ten" value="${kh.ten}">

        <label>Họ</label>
        <input type="text" name="ho" value="${kh.ho}">

        <label>Ten Dem</label>
        <input type="text" name="tenDem" value="${kh.tenDem}">

        <label>SDT</label>
        <input type="number" name="sdt" value="${kh.sdt}">

        <label>Dia Chi</label>
        <input type="text" name="diaChi" value="${kh.diaChi}">

        <button type="submit">Update</button>
    </form>
</section>

</body>
</html>
