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
<form action="" method="post">

    <div class="container">
        <label><b>id</b></label>
        <input type="text" placeholder="Enter Username" name="id" >
        <br>
        <label><b>mã</b></label>
        <input type="text" placeholder="Enter Password" name="ma" >
        <br>
        <label><b>tên</b></label>
        <input type="text" placeholder="Enter Password" name="ten">
        <br>
        <label><b>tuổi</b></label>
        <input type="text" placeholder="Enter Password" name="tuoi">
        <br>
        <label><b>Địa chỉ</b></label>
        <input type="text" placeholder="Enter Password" name="diaChi">
        <br>
        <label for="html">Giới tính</label>
        <input type="radio" id="html" name="gioiTinh" value=true checked="checked" >
        <label for="html">Nam</label>
        <input type="radio" id="css" name="gioiTinh" value=false>
        <label for="css">Nữ</label><br>
        <button type="submit">Add</button>
    </div>
</form>
<br>

<footer>Footer</footer>

</body>
</html>
