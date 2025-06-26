<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <title>Perfume Search Results</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            padding: 10px;
            border: 1px solid #aaa;
            text-align: center;
        }
        th {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>

<h2 style="text-align:center;">Search Results</h2>

<c:if test="${not empty dataList}">
    <table>
        <tr>
            <th>Perfume Name</th>
            <th>Brand</th>
            <th>Simple - Complex</th>
            <th>Fresh - Sweet</th>
            <th>Light - Heavy</th>
            <th>Male - Women</th>
            <th>Mild - Spicy</th>
        </tr>

        <c:forEach var="item" items="${dataList}">
            <tr>
                <td>${item.perfume.perfume_name}</td>
                <td>${item.perfume.brand_name}</td>
                <td>${item.scrollbar.simple_complex}</td>
                <td>${item.scrollbar.fresh_sweet}</td>
                <td>${item.scrollbar.light_heavy}</td>
                <td>${item.scrollbar.male_women}</td>
                <td>${item.scrollbar.mild_spicy}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty dataList}">
    <p style="text-align:center; color:red;">No results found.</p>
</c:if>

</body>
</html>