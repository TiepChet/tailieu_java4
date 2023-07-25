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

    <form action="/may-tinh/update" method="post">

        <label><b>Ma</b></label>
        <input type="text" name="ma" value="${mt.ma}">

        <label><b>Ten</b></label>
        <input type="text" name="ten" value="${mt.ten}">

        <label><b>Gia</b></label>
        <input type="number" name="gia" value="${mt.gia}">

        <label><b>Bo Nho</b></label>
        <input type="text" name="boNho" value="${mt.boNho}">

        <label><b>Mau Sac</b></label>
        <input type="radio" name="mauSac" value="den" checked ${mt.mauSac=="den"?"checked":""}>den
        <input type="radio" name="mauSac" value="bac" ${mt.mauSac=="bac"?"checked":""}>bac

        <label><b>Hang</b></label>
        <select name="hang">
            <option selected value="ACER" ${mt.hang=="ACER"?"selected":""}>ACER</option>
            <option value="MSI" ${mt.hang=="MSI"?"selected":""}>MSI</option>
            <option value="DELL" ${mt.hang=="DELL"?"selected":""}>DELL</option>
            <option value="ASUS" ${mt.hang=="ASUS"?"selected":""}>ASUS</option>
        </select>

        <label><b>Mieu Ta</b></label>
        <input type="text" name="mieuTa" value="${mt.mieuTa}">

        <button type="submit">UPDATE</button>

    </form>
</section>

</body>
</html>
