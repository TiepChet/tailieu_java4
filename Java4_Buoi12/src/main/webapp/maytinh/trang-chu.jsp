<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/03/2023
  Time: 08:40
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

    <button><a href="/may-tinh/view-add">Add</a></button>

    <%-- Sort--%>
    <form action="/may-tinh/sort" method="get">

        <label><b>Sắp Xếp</b></label>
        <select name="sort">
            <option value="gia">Gia</option>
            <option value="boNho">Bo Nho</option>
        </select>
        <button type="submit">Sắp Xếp</button>
    </form>

    <%-- Table--%>
    <table>
        <tr>
            <th>Ma</th>
            <th>Ten</th>
            <th>Gia</th>
            <th>Bo Nho</th>
            <th>Mau Sac</th>
            <th>Hang</th>
            <th>Mieu Ta</th>
            <th>Action</th>
        </tr>
        <tbody>
        <c:forEach items="${listMT}" var="mt">
            <tr>
                <td>${mt.ma}</td>
                <td>${mt.ten}</td>
                <td>${mt.gia}</td>
                <td>${mt.boNho}</td>
                <td>
                    <c:if test="${mt.mauSac=='den'}">den</c:if>
                    <c:if test="${mt.mauSac=='bac'}">bac</c:if>
                </td>
                <td>
                    <c:if test="${mt.hang=='MSI'}">MSI</c:if>
                    <c:if test="${mt.hang=='ACER'}">ACER</c:if>
                    <c:if test="${mt.hang=='DELL'}">DELL</c:if>
                    <c:if test="${mt.hang=='ASUS'}">ASUS</c:if>
                </td>
                <td>${mt.mieuTa}</td>
                <td>
                    <button><a href="/may-tinh/delete?ma=${mt.ma}">Delete</a></button>
                    <button><a href="/may-tinh/view-update?ma=${mt.ma}">Update</a></button>
                    <button><a href="/may-tinh/detail?ma=${mt.ma}">Detail</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <label>${mess}</label>

</section>


</body>
</html>
