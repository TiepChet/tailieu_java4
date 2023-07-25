<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/04/2023
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section>
    <form action="/thuc-vat/update" method="post">

        <label>Ten</label> <br>
        <input type="text" name="ten" value="${tv.ten}"><br>

        <label>Tuoi</label> <br>
        <input type="number" name="tuoi" value="${tv.tuoi}"><br>

        <label>Gioi Tinh</label> <br>
        <input type="radio" name="gioiTinh" value="true" ${tv.gioiTinh==true?"checked":""} checked> Nam
        <input type="radio" name="gioiTinh" value="false" ${tv.gioiTinh==false?"checked":""}> Nữ

        <br>

        <label>Khu Vuc Song</label> <br>
        <input type="text" name="khuVucSong" value="${tv.khuVucSong}"><br>

        <label>Loai</label> <br>
        <select name="loai">
            <option selected value="loai 1" ${tv.loai=="loai 1"?"selected":""} >loai 1</option>
            <option value="loai 2" ${tv.loai=="loai 2"?"selected":""}>loai 2</option>
            <option value="loai 3" ${tv.loai=="loai 3"?"selected":""}>loai 3</option>
            <option value="loai 4" ${tv.loai=="loai 4"?"selected":""}>loai 4</option>
        </select>

        <br>

        <button type="submit">UPDATE</button>

    </form>
</section>

</body>
</html>
