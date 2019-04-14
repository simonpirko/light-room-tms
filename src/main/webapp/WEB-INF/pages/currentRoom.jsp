<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Room ${room.id}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <c:if test="${!room.bulb.light}">
        <style>
            body {
            background-color: black;
            }
            .display-1 {
               color: white;
            }
            .display-4 {
                color: white;
            }
        </style>
    </c:if>
</head>
<body class="container w-25">
<div class="row justify-content-center">
    <h1 class="display-4 mt-5 mb-5">Room ${room.id}</h1>
</div>
<div class="row justify-content-center">
    <h1 class="display-1 mt-5 mb-5">${room.bulb.light ? "LIGHT" : "DARK"}</h1>
</div>
<c:choose>
    <c:when test="${room.bulb.light}">
        <div class="row justify-content-center">
            <form class="mt-5" action="${pageContext.request.contextPath}/room" method="post">
                <input type="hidden" name="light" value="${0}">
                <input type="hidden" name="id" value="${room.id}">
                <button class="btn btn-dark rounded-pill">OFF</button>
            </form>
        </div>
    </c:when>
    <c:otherwise>
        <div class="row justify-content-center">
            <form class="mt-5" action="${pageContext.request.contextPath}/room" method="post">
                <input type="hidden" name="light" value="${1}">
                <input type="hidden" name="id" value="${room.id}">
                <button class="btn btn-light rounded-pill">ON</button>
            </form>
        </div>
    </c:otherwise>
</c:choose>
<div class="row justify-content-center mt-5">
    <a href="${pageContext.request.contextPath}/">Back</a>
</div>
</body>
</html>
