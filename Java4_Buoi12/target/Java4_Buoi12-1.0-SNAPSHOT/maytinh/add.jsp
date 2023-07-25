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

    <form action="/may-tinh/add" method="post">

        <label><b>Ten</b></label>
        <input type="text" name="ten">

        <label><b>Gia</b></label>
        <input type="number" name="gia">

        <label><b>Bo Nho</b></label>
        <input type="text" name="boNho">

        <label><b>Mau Sac</b></label>
        <input type="radio" name="mauSac" value="den" checked>den
        <input type="radio" name="mauSac" value="bac">bac

        <label><b>Hang</b></label>
        <select name="hang">
            <option selected value="ACER">ACER</option>
            <option value="MSI">MSI</option>
            <option value="DELL">DELL</option>
            <option value="ASUS">ASUS</option>
        </select>

        <label><b>Mieu Ta</b></label>
        <input type="text" name="mieuTa">

        <button type="submit">ADD</button>

    </form>
    <label>${mess}</label>

</section>

</body>
</html>
