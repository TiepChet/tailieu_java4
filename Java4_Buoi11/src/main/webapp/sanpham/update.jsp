<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/03/2023
  Time: 08:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section class="container">
    <form action="/san-pham/update" method="post">

        <label>Id</label>
        <input type="number" name="id" value="${sp.id}">

        <label>Ma</label>
        <input type="text" name="ma" value="${sp.ma}">

        <label>Ten</label>
        <input type="text" name="ten" value="${sp.ten}">

        <label>Loai</label>
        <select name="loai">
            <option selected value="loai 1" ${sp.loai=='loai 1'?"selected":""}>loai 1</option>
            <option value="loai 2" ${sp.loai=='loai 2'?"selected":""}>loai 2</option>
            <option value="loai 3" ${sp.loai=='loai 3'?"selected":""}>loai 3</option>
            <option value="loai 4" ${sp.loai=='loai 4'?"selected":""}>loai 4</option>
        </select>

        <label>Gia</label>
        <input type="number" name="gia" value="${sp.gia}">

        <button type="submit">Update</button>
    </form>
</section>
</body>
</html>
