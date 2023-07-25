<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/03/2023
  Time: 00:30
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
    <form action="" method="post">
        <label>Ten</label>
        <input type="text">
        <button>Search</button>
    </form>
    <br>
    <button>Add</button>

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
        <c:forEach items="${listGiangVien}" var="gv">
            <tr>
                <td>${gv.id}</td>
                <td>${gv.ma}</td>
                <td>${gv.ten}</td>
                <td>${gv.tuoi}</td>
                <td>${gv.gioiTinh}</td>
                <td>${gv.diaChi}</td>
                <td>
                    <button>Delete</button>
                    <button>Update</button>
                    <button>Detail</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<footer>Footer</footer>
</body>
</html>
