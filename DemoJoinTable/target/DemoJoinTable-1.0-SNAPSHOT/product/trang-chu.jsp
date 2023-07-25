<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/03/2023
  Time: 09:38
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
    <form action="/product/add/add" method="post">


        <label><b>CategoryId</b></label>
        <select>
            <c:forEach items="${listCategory}" var="sp">
                <option name="name" value="${sp.id}"  >${sp.categoryName}</option>
            </c:forEach>
        </select>


        <button type="submit">Add</button>
    </form>


    <table>
        <tr>
            <th>Id</th>
            <th>CategoryId</th>
            <th>ProductCode</th>
            <th>ProductName</th>
            <th>Price</th>
            <th>Description</th>
            <th>Action</th>

        </tr>
        <tbody>
        <c:forEach items="${listProduct}" var="pd">
            <tr>
                <td>${pd.id}</td>
                <td>${pd.category.categoryName}</td>
                <td>${pd.productCode}</td>
                <td>${pd.productName}</td>
                <td>${pd.price}</td>
                <td>${pd.description}</td>
                <td>
                    <button><a href="/product/delete?id=${pd.id}">Delete</a></button>
                    <button><a href="/product/detail?id=${pd.id}">Detail</a></button>
                    <button><a href="/category/view-update?id=${pd.id}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

</body>
</html>
