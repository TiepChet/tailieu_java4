<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/04/2023
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section>
    <form action="/thuc-vat/add" method="post">

        <label>Ten</label> <br>
        <input type="text" name="ten"><br>

        <label>Tuoi</label> <br>
        <input type="number" name="tuoi"><br>

        <label>Gioi Tinh</label> <br>
        <input type="radio" name="gioiTinh" value="true" checked>  Nam
        <input type="radio" name="gioiTinh" value="false" >  Nữ

        <br>

        <label>Khu Vuc Song</label> <br>
        <input type="text" name="khuVucSong"><br>

        <label>Loai</label> <br>
        <select name="loai">
            <option selected value="loai 1">loai 1</option>
            <option value="loai 2">loai 2</option>
            <option value="loai 3">loai 3</option>
            <option value="loai 4">loai 4</option>
        </select>

        <br>

        <button type="submit">ADD</button>

    </form>
    <label style="color: red">${mess}</label>

</section>

</body>
</html>
