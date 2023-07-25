<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/04/2023
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section class="container">
    <%-- search--%>
    <form action="/thuc-vat/search" method="get">

        <label>Tên</label>
        <input type="text" name="ten">
        <button type="submit">Search</button>
    </form>

    <%-- Sap Xep--%>
    <form action="/thuc-vat/sort" method="get">

        <label>Sắp Xếp</label>
        <select name="sapXep">
            <option selected value="tuoi">Tuổi</option>
            <option value="ten">Tên</option>
        </select>

        <button type="submit">Sort</button>
    </form>

        <button type="submit"><a href="/thuc-vat/view-add">ADD</a></button>

    <%--  table--%>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Ma</th>
            <th scope="col">Ten</th>
            <th scope="col">Tuoi</th>
            <th scope="col">Gioi Tinh</th>
            <th scope="col">Khu Vuc Song</th>
            <th scope="col">Loai</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listTV}" var="tv">
            <tr>
                <td>${tv.ma}</td>
                <td>${tv.ten}</td>
                <td>${tv.tuoi}</td>
                <td>
                    <c:if test="${tv.gioiTinh==true}">Nam</c:if>
                    <c:if test="${tv.gioiTinh==false}">Nữ</c:if>
                </td>
                <td>${tv.khuVucSong}</td>
                <td>
                    <c:if test="${tv.loai=='loai 1'}">loai 1</c:if>
                    <c:if test="${tv.loai=='loai 2'}">loai 2</c:if>
                    <c:if test="${tv.loai=='loai 3'}">loai 3</c:if>
                    <c:if test="${tv.loai=='loai 4'}">loai 4</c:if>
                </td>
                <td>
                    <button><a href="/thuc-vat/delete?ma=${tv.ma}">Delete</a></button>
                    <button><a href="/thuc-vat/detail?ma=${tv.ma}">Detail</a></button>
                    <button><a href="/thuc-vat/view-update?ma=${tv.ma}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<label style="color: red">${mess}</label>
</section>

</body>
</html>
