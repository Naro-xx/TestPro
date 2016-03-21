<%--
  Created by IntelliJ IDEA.
  User: Narek
  Date: 12/11/2015
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Wellcome</title>
</head>
<link rel="stylesheet" type="text/css" href="../../assests/CSS/WEB.css"/>
<body>
<h2 align="center">WELLCOME</h2>
<h1><div id="bottom-panel" align="center">
    <form  action="controller" method="post"/>
        <input type="submit" name="page" value="users"/>
        <input type="submit" name="page" value="importCvs"/>
    <form/>
</div>
</h1>
</body>
</html>
