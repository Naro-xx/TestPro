<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns:c="http://java.sun.com/jsp/jstl/core">
<link rel="stylesheet" type="text/css" href="../../assests/CSS/WEB.css"/>
<head>
    <title>Users</title>
    ${message}<br>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<h3><a href="controller?page=main">Main</a></h3>
<form action="controller" method="post" id="controller">
    <jsp:include page="Includ/selectCountResultInpage.jsp" />
    <div align="center">
<table  border="1">
    <tr>
        <th>
            Name
                <c:url value="controller" var="sort" >
                    <c:param name="sortRow" value="name"/>
                    <c:param name="sortFlag" value="up"/>
                    <c:param name="page" value="users"/>
                    <c:param name="countResult" value="${countResult}"/>
                </c:url>
            <a href="${sort}"><img src="../../assests/sort_down.png"></a>

                <c:url value="controller" var="sort" >
                    <c:param name="sortRow" value="name"/>
                    <c:param name="sortFlag" value="down"/>
                    <c:param name="page" value="users"/>
                    <c:param name="countResult" value="${countResult}"/>

                </c:url>
                <a href="${sort}"><img src="../../assests/sort_up.png"></a>
        </th>
        <th>Surname
            <c:url value="controller" var="sort" >
                <c:param name="sortRow" value="surname"/>
                <c:param name="sortFlag" value="up"/>
                <c:param name="page" value="users"/>
                <c:param name="countResult" value="${countResult}"/>
            </c:url>
            <a href="${sort}"><img src="../../assests/sort_down.png"></a>

            <c:url value="controller" var="sort" >
                <c:param name="sortRow" value="surname"/>
                <c:param name="sortFlag" value="down"/>
                <c:param name="page" value="users"/>
                <c:param name="countResult" value="${countResult}"/>
            </c:url>
            <a href="${sort}"><img src="../../assests/sort_up.png"></a>
        </th>
        <th>Login
            <c:url value="controller" var="sort" >
                <c:param name="sortRow" value="login"/>
                <c:param name="sortFlag" value="up"/>
                <c:param name="page" value="users"/>
                <c:param name="countResult" value="${countResult}"/>
            </c:url>
            <a href="${sort}"><img src="../../assests/sort_down.png"></a>

            <c:url value="controller" var="sort" >
                <c:param name="sortRow" value="login"/>
                <c:param name="sortFlag" value="down"/>
                <c:param name="page" value="users"/>
                <c:param name="countResult" value="${countResult}"/>
            </c:url>
            <a href="${sort}"><img src="../../assests/sort_up.png"></a>
        </th>
        <th>Email
            <c:url value="controller" var="sort" >
                <c:param name="sortRow" value="email"/>
                <c:param name="sortFlag" value="up"/>
                <c:param name="page" value="users"/>
                <c:param name="countResult" value="${countResult}"/>
            </c:url>
            <a href="${sort}"><img src="../../assests/sort_down.png"></a>

            <c:url value="controller" var="sort" >
                <c:param name="sortRow" value="email"/>
                <c:param name="sortFlag" value="down"/>
                <c:param name="page" value="users"/>
                <c:param name="countResult" value="${countResult}"/>
            </c:url>
            <a href="${sort}"><img src="../../assests/sort_up.png"></a>
        </th>
        <th>Number
            <c:url value="controller" var="sort" >
                <c:param name="sortRow" value="number"/>
                <c:param name="sortFlag" value="up"/>
                <c:param name="page" value="users"/>
                <c:param name="countResult" value="${countResult}"/>
            </c:url>
            <a href="${sort}"><img src="../../assests/sort_down.png"></a>

            <c:url value="controller" var="sort" >
                <c:param name="sortRow" value="number"/>
                <c:param name="sortFlag" value="down"/>
                <c:param name="page" value="users"/>
                <c:param name="countResult" value="${countResult}"/>
            </c:url>
            <a href="${sort}"><img src="../../assests/sort_up.png"></a>
        </th>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.login}</td>
            <td>${user.email}</td>
            <td>${user.number}</td>
        </tr>
    </c:forEach>
</table>
    </div>
    <jsp:include page="Includ/navigationForPagination.jsp"/>
</form>
</body>
</html>
