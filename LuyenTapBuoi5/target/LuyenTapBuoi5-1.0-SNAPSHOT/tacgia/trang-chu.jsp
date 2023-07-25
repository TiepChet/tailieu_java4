<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/04/2023
  Time: 15:29
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

    <%--Search--%>
    <form action="/tac-gia/search" method="get">
        <label>Tên</label>
        <input type="text" name="ten">
        <button type="submit">Search</button>
    </form>
    <%--Sap Xep--%>
    <form action="/tac-gia/sort" method="get">
        <label>Sắp Xếp</label>
        <select name="sapXep">
            <option selected value="tuoi">Tuổi</option>
            <option value="ten">Tên</option>
        </select>
        <button type="submit">Sắp Xếp</button>
    </form>

    <%-- Input--%>
    <form action="/tac-gia/add" method="post">
        <label>Tên</label>
        <input type="text" name="ten" value="${tg.ten}">

        <label>Tuổi</label>
        <input type="number" name="tuoi" value="${tg.tuoi}">

        <label>Giới Tính</label>
        <input type="radio" name="gioiTinh" value="true" ${tg.gioiTinh==true?"checked":""} checked>Nam
        <input type="radio" name="gioiTinh" value="false" ${tg.gioiTinh==false?"checked":""} >Nữ

        <label>Loại</label>
        <select name="loaiSachViet">
            <option selected value="tre em" ${tg.loaiSachViet=="tre em"?"selected":""} >Trẻ em</option>
            <option value="truyen"  ${tg.loaiSachViet=="truyen"?"selected":""}>Truyện</option>
            <option value="giao duc"  ${tg.loaiSachViet=="giao duc"?"selected":""}>Giáo Dục</option>
        </select>

        <button type="submit">Add</button>
    </form>

    <%--   Table --%>
    <table>
        <tr>
            <th>Ma</th>
            <th>Ten</th>
            <th>Tuoi</th>
            <th>Gioi Tinh</th>
            <th>Loai</th>
            <th>Action</th>
        </tr>
        <tbody>
        <c:forEach items="${listTG}" var="tg">
            <tr>
                <td>${tg.ma}</td>
                <td>${tg.ten}</td>
                <td>${tg.tuoi}</td>
                <td>
                    <c:if test="${tg.gioiTinh==true}">Nam</c:if>
                    <c:if test="${tg.gioiTinh==false}">Nữ</c:if>
                </td>
                <td>
                    <c:if test="${tg.loaiSachViet=='tre em'}">tre em</c:if>
                    <c:if test="${tg.loaiSachViet=='truyen'}">truyen</c:if>
                    <c:if test="${tg.loaiSachViet=='giao duc'}">giao duc</c:if>

                </td>
                <td>
                    <button><a href="/tac-gia/delete?ma=${tg.ma}">Delete</a></button>
                    <button><a href="/tac-gia/detail?ma=${tg.ma}">Detail</a></button>
                    <button><a href="/tac-gia/view-update?ma=${tg.ma}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</section>

</body>
</html>
