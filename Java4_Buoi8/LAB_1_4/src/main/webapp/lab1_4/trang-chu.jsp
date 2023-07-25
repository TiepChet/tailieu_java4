<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 14/03/2023
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<section class="container">

    <%--search--%>
    <form action="/giang-vien/search" method="get">

        <label><b>Ten</b></label>
        <input type="text" placeholder="ten" name="ten">

        <label><b>Tuoi</b></label>
        <input type="number" placeholder="min" name="min">
        <input type="number" placeholder="max" name="max">

        <button type="submit">Search</button>
    </form>

    <%--input--%>
    <form action="/giang-vien/add" method="post">

        <label><b>Ma</b></label> <br>
        <input type="text" name="ma" value="${gv.ma}"> <br>

        <label><b>Ten</b></label> <br>
        <input type="text" name="ten" value="${gv.ten}"> <br>

        <label><b>Tuoi</b></label> <br>
        <input type="number" name="tuoi" value="${gv.tuoi}"> <br>

        <label><b>Gioi Tinh</b></label> <br>
        <input type="radio" name="gioiTinh" value="true" checked ${gv.gioiTinh==true?"checked":""}> Nam
        <input type="radio" name="gioiTinh" value="false"  ${gv.gioiTinh==false?"checked":""}> Nữ <br>


        <label><b>Quê Quán</b></label> <br>
        <input type="text" name="queQuan" value="${gv.queQuan}"> <br>

        <button type="submit">Add</button>
        <label style="color: red">${error}</label>
    </form>

    <%--    <button type="submit"><a href="">Hien Thi</a></button>--%>
    <button type="submit"><a href="/giang-vien/sort">Sort Tuoi</a></button>
    <button type="submit"><a href="/giang-vien/giang-vien-nu">Giang Vien Nu</a></button>


    <%--table--%>
    <table>
        <tr>
            <th>Ma</th>
            <th>Ten</th>
            <th>Tuoi</th>
            <th>Gioi Tinh</th>
            <th>Que Quan</th>
            <th>Action</th>
        </tr>
        <tbody>
        <c:forEach items="${listGV}" var="gv">
            <tr>
                <td>${gv.ma}</td>
                <td>${gv.ten}</td>
                <td>${gv.tuoi}</td>
                <td>
                    <c:if test="${gv.gioiTinh==true}">Nam</c:if>
                    <c:if test="${gv.gioiTinh==false}">Nữ</c:if>
                </td>
                <td>${gv.queQuan}</td>
                <td>
                    <button><a href="/giang-vien/detail?ma=${gv.ma}">Detail</a></button>
                    <button><a href="/giang-vien/delete?ma=${gv.ma}">Delete</a></button>
                    <button><a href="/giang-vien/view-update?ma=${gv.ma}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>