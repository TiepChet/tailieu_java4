<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/03/2023
  Time: 06:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<header>Header</header>

<section>

    <%--    Search--%>
    <form action="/giang-vien/search" method="get">
        <label>Ten</label><br>
        <input type="text" placeholder="ten" name="ten"><br>
        <label>Tuoi</label><br>
        <input type="text" placeholder="min" name="min"> <br>
        <input type="text" placeholder="max" name="max"> <br>
        <button><a>Search</a></button>
    </form>


    <%--Input--%>
    <form action="/giang-vien/add" method="post">
        <label>Id</label><br>
        <input type="number" name="id" value="${gv.id}"><br>
        <label>Ma</label><br>
        <input type="text" name="ma" value=" ${gv.ma}"><br>
        <label>Ten</label><br>
        <input type="text" name="ten" value="${gv.ten}"><br>
        <label>Tuoi</label><br>
        <input type="number" name="tuoi" value="${gv.tuoi}"><br>
        <label>Que Quan</label><br>
        <input type="text" name="queQuan" value="${gv.queQuan}"><br>
        <button><a>Add</a></button>
        <label>${error}</label>
    </form>
    <br>
    <button><a href="/giang-vien/que-quan">Que Thai Binh</a></button>
    <button><a href="/giang-vien/sort">Sap Xep Tuoi</a></button>

    <table>
        <tr>
            <th>Id</th>
            <th>Ma</th>
            <th>Ten</th>
            <th>Tuoi</th>
            <th>Que Quan</th>
            <th>Action</th>
        </tr>
        <tbody>
        <c:forEach items="${listGV}" var="gv">
            <tr>
                <td>${gv.id}</td>
                <td>${gv.ma}</td>
                <td>${gv.ten}</td>
                <td>${gv.tuoi}</td>
                <td>${gv.queQuan}</td>
                <td>
                    <button><a href="/giang-vien/remove?id=${gv.id}">Remove</a></button>
                    <button><a href="/giang-vien/detail?id=${gv.id}">Detail</a></button>
                    <button><a href="/giang-vien/view-update?id=${gv.id}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<footer>Footer</footer>

</body>
</html>
