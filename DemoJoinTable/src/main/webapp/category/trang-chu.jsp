<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/03/2023
  Time: 03:40
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
    <form action="/category/add" method="post">

        <label><b>Username</b></label>
        <input type="text" name="categoryCode" value="${category.categoryCode}">

        <label><b>Password</b></label>
        <input type="text" name="categoryName" value="${category.categoryName}">

        <button type="submit">Add</button>
    </form>


    <table>
        <tr>
            <th>Id</th>
            <th>Ma</th>
            <th>Name</th>
        </tr>
        <tbody>
        <c:forEach items="${listCategory}" var="cg">
            <tr>
                <td>${cv.id}</td>
                <td>${cg.categoryCode}</td>
                <td>${cg.categoryName}</td>
                <td>
                    <button><a href="/category/delete?id=${cg.id}">Delete</a></button>
                    <button><a href="/category/detail?id=${cg.id}">Detail</a></button>
                    <button><a href="/category/view-update?id=${cg.id}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>
