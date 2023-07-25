<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/03/2023
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--Cach goi session truc tiep trong jsp - sessionScope--%>
<p> C1: Goi truc tiep JSP ${sessionScope.name}</p>
<p> C2: Goi thong qua servlet ${ten}</p>

<header>Header</header>

<br>
<form action="/giang-vien/search" method="post">
    <label>Tên</label>
    <input type="text" name="tenSearch">
    <button type="submit">Search</button>
</form>
<a href="/giang-vien/view-add" type="submit">Add Student</a>
<button type="submit">Giảng viên nữ</button>
<table>
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>GT</th>
        <th>Địa chỉ</th>
        <th>Action</th>
    </tr>
    <tr>
        <tbody>
        <c:forEach items="${listGiangVien}" var="gv" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${gv.id}</td>
                <td>${gv.ma}</td>
                <td>${gv.ten}</td>
                <td>${gv.tuoi}</td>
                <td>${gv.gioiTinh?"Nam":"Nữ"}</td>
                <td>${gv.diaChi}</td>
                <td>
                    <a href="/giang-vien/detail?id=${i.index}">Detail</a>
                    <a href="/giang-vien/remove?id=${i.index} ">Delete</a>
                    <a href="/giang-vien/view-update?id=${i.index}">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </tr>
</table>
<br>

<a href="/dang-xuat">Dang Xuat</a>

<footer>Footer</footer>


</body>
</html>
