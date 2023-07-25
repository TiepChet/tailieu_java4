<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/03/2023
  Time: 07:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<section class="container">

    <%--Search--%>
    <form action="/giang-vien/search" method="get">
        <label><b>Ten</b></label>
        <input type="text" placeholder="Enter Username" name="ten">
        <button type="submit">Search</button>
    </form>

    <button type="submit"><a href="/giang-vien/giang-vien-nu">Giảng Viên Nữ</a></button>
    <button type="submit"><a href="/giang-vien/sort">Sort Tuoi</a></button>
    <button type="submit"><a href="/giang-vien/view-add">Add</a></button>



        <table>
        <tr>
            <th>Id</th>
            <th>Ma</th>
            <th>Ten</th>
            <th>Tuoi</th>
            <th>Gioi Tinh</th>
            <th>Dia Chi</th>
            <th>Action</th>
        </tr>
        <tbody>
        <c:forEach items="${listGV}" var="gv">
            <tr>
                <td>${gv.id}</td>
                <td>${gv.ma}</td>
                <td>${gv.ten}</td>
                <td>${gv.tuoi}</td>
                <td>
                    <c:if test="${gv.gioiTinh==true}">Nam</c:if>
                    <c:if test="${gv.gioiTinh==false}">Nữ</c:if>
                </td>
                <td>${gv.diaChi}</td>
                <td>
                    <button><a href="/giang-vien/detail?id=${gv.id}">Detail</a></button>
                    <button><a href="/giang-vien/delete?id=${gv.id}">Delete</a></button>
                    <button><a href="/giang-vien/view-update?id=${gv.id}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        <label style="color: red">${error}</label>
</section>

</body>
</html>
