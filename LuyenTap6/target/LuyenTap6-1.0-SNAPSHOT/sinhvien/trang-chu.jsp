<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/04/2023
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section>
    <%--  Search --%>
    <form action="/sinh-vien/search" method="get">
        <label>Ten</label>
        <input type="text" name="ten">
        <button type="submit">Search</button>
    </form>

    <%--  Sort--%>
    <form action="/sinh-vien/sort" method="get">
        <label>Sap Xep</label>
        <select name="sapXep">
            <option selected value="tuoi">Tuổi</option>
            <option value="ten">Tên</option>
        </select>
        <button type="submit">Search</button>
    </form>

        <button><a href="/sinh-vien/view-add">ADD</a></button>
        <button><a href="/sinh-vien/giang-vien-nu">Sinh Vien Nu</a></button>



    <%--  Table--%>

    <table>
        <tr>
            <th>Ma</th>
            <th>Ten</th>
            <th>Tuoi</th>
            <th>Gioi Tinh</th>
            <th>Dia Chi</th>
            <th>Ky Hoc</th>
            <th>Action</th>
        </tr>
        <tbody>
        <c:forEach items="${listSV}" var="sv">
            <tr>
                <td>${sv.ma}</td>
                <td>${sv.ten}</td>
                <td>${sv.tuoi}</td>
                <td>
                    <c:if test="${sv.gioiTinh==true}">Nam</c:if>
                    <c:if test="${sv.gioiTinh==false}">Nữ</c:if>
                </td>
                <td>${sv.diaChi}</td>
                <td>
                    <c:if test="${sv.kyHoc==1}">Học kỳ 1</c:if>
                    <c:if test="${sv.kyHoc==2}">Học kỳ 2</c:if>
                    <c:if test="${sv.kyHoc==3}">Học kỳ 3</c:if>
                    <c:if test="${sv.kyHoc==4}">Học kỳ 4</c:if>
                </td>
                <td>
                    <button><a href="/sinh-vien/delete?ma=${sv.ma}">Delete</a></button>
                    <button><a href="/sinh-vien/detail?ma=${sv.ma}">Detail</a></button>
                    <button><a href="/sinh-vien/view-update?ma=${sv.ma}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</section>


</body>
</html>
