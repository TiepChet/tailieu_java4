<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/04/2023
  Time: 13:11
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
        <form action="/khach-hang/add" method="post">
            <label>Ma</label>
            <input type="text" name="ma" value="${kh.ma}">

            <label>Ten</label>
            <input type="text" name="ten" value="${kh.ten}">

            <label>Họ</label>
            <input type="text" name="ho" value="${kh.ho}">

            <label>Ten Dem</label>
            <input type="text" name="tenDem" value="${kh.tenDem}">

            <label>SDT</label>
            <input type="number" name="sdt" value="${kh.sdt}">

            <label>Dia Chi</label>
            <input type="text" name="diaChi" value="${kh.diaChi}">

            <button type="submit">Add</button>
        </form>

        <button><a href="/khach-hang/hien-thi">Hien Thi</a></button>

        <table>
            <tr>
                <th>STT</th>
                <th>Ho Ten</th>
                <th>SĐT</th>
                <th>Dia Chi</th>
                <th>Action</th>
            </tr>
           <tbody>
           <c:forEach items="${listKH}" var="kh" varStatus="i">
               <tr>
                   <td>${i.index+1}</td>
                   <td>${kh.ho } ${kh.tenDem} ${kh.ten}</td>
                   <td>${kh.sdt}</td>
                   <td>${kh.diaChi}</td>
                   <td>
                       <button type="submit"><a href="/khach-hang/delete?id=${kh.id}">Delete</a></button>
                       <button type="submit"><a href="/khach-hang/detail?id=${kh.id}">Detail</a></button>
                       <button type="submit"><a href="/khach-hang/view-update?id=${kh.id}">Update</a></button>
                   </td>
               </tr>
           </c:forEach>
           </tbody>
        </table>
    <label style="color: red">${mess}</label>
</section>

</body>
</html>
