<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/03/2023
  Time: 08:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section class="container">

    <form action="/may-tinh/detail" method="get">
        <label>Ma : ${mt.ma}</label> <br>
        <label>Ten : ${mt.ten}</label> <br>
        <label>Gia : ${mt.gia}</label> <br>
        <label>Bo Nho :${mt.boNho}</label> <br>
        <label>Mau Sac :${mt.mauSac}</label> <br>
        <label>Hang :${mt.hang}</label> <br>
        <label>Mieu Ta :${mt.mieuTa}</label> <br>
    </form>

</section>

</body>
</html>
