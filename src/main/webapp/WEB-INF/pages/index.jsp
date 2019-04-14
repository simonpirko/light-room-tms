<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="container w-25">
<div class="list-group mt-5">
    <c:forEach items="${rooms}" var="room">
        <c:choose>
            <c:when test="${room.bulb.light}"><a href="/room/${room.id}"
                                                 class="list-group-item list-group-item-action list-group-item-info">Room
                 ${room.id}</a></c:when>
            <c:otherwise> <a href="/room/${room.id}" class="list-group-item list-group-item-action">Room
                 ${room.id}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>
<form class="mt-2 text-center" action="${pageContext.request.contextPath}/" method="post">
    <button class="btn btn-light">+</button>
</form>
</body>
</html>
