<%@page isELIgnored="false" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<c:forEach items="${productVO.data}" var="categoryVO">
    <ul>
        <li>${categoryVO.name}</li>
        <li>${categoryVO.type}</li>
        <c:forEach items="${categoryVO.foods}" var="product">
            <ul>
                <li>${product.productId}</li>
                <li>${product.productName}</li>
                <li>${product.productDescription}</li>
                <li>${product.productPrice}</li>
                <li>${product.productIcon}</li>
                <li><a href="${pageContext.request.contextPath}/product/addCart?id=${product.productId}">添加购物车</a></li>
            </ul>
        </c:forEach>
    </ul>
</c:forEach>
</body>