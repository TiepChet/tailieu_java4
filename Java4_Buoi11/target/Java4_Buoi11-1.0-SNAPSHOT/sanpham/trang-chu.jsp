<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/03/2023
  Time: 08:03
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

    <%-- Search--%>
    <form action="/san-pham/search" method="get">
        <label>Ten</label>
        <input type="text" name="ten">
        <button type="submit">Search</button>
    </form>

    <%-- Input--%>
    <form action="/san-pham/add" method="post">
        <label>Ma</label>
        <input type="text" name="ma" value="${sp.ma}">

        <label>Ten</label>
        <input type="text" name="ten" value="${sp.ten}">

        <label>Loai</label>
        <select name="loai">
            <option selected value="loai 1" ${sp.loai=='loai 1'?"selected":""}>loai 1</option>
            <option value="loai 2" ${sp.loai=='loai 2'?"selected":""}>loai 2</option>
            <option value="loai 3" ${sp.loai=='loai 3'?"selected":""}>loai 3</option>
            <option value="loai 4" ${sp.loai=='loai 4'?"selected":""}>loai 4</option>
        </select>

        <label>Gia</label>
        <input type="number" name="gia" value="${sp.gia}">

        <button type="submit">ADD</button>
    </form>

    <%-- Table--%>
    <table>
        <tr>
            <th>ID</th>
            <th>MA</th>
            <th>TEN</th>
            <th>LOAI</th>
            <th>GIA</th>
            <th>ACTION</th>

        </tr>
        <tbody>
        <c:forEach items="${listSP}" var="sp">
            <tr>
                <td>${sp.id}</td>
                <td>${sp.ma}</td>
                <td>${sp.ten}</td>
                <td>
                    <c:if test="${sp.loai =='loai 1'}">loai 1</c:if>
                    <c:if test="${sp.loai =='loai 2'}">loai 2</c:if>
                    <c:if test="${sp.loai =='loai 3'}">loai 3</c:if>
                    <c:if test="${sp.loai =='loai 4'}">loai 4</c:if>
                </td>
                <td>${sp.gia}</td>
                <td>
                    <button><a href="/san-pham/delete?id=${sp.id}">Delete</a></button>
                    <button><a href="/san-pham/detail?id=${sp.id}">Detail</a></button>
                    <button><a href="/san-pham/view-update?id=${sp.id}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        <label>${mess}</label>
</section>

</body>
</html>
