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
<c:forEach items="${cart}" var="product">
    <ul>
        <li>${product.value.productId}</li>
        <li>${product.value.productName}</li>
        <li>${product.value.count}</li>
    </ul>
</c:forEach>
<a href="${pageContext.request.contextPath}/product/createOrder">生成订单</a>
</body>