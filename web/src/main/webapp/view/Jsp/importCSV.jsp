<%--
  Created by IntelliJ IDEA.
  User: Narek
  Date: 12/11/2015
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
</head>
<link rel="stylesheet" type="text/css" href="../../assests/CSS/WEB.css"/>
<body>
<h3><a href="controller?page=main">Main</a></h3>
    <h2 align="center">Upload file Hear</h2>
    <div align="center">
<form action="controller"  enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td >
                <input type="file" name="file" value="" width="100"/>
            </td>
        </tr>
   <tr>
       <td colspan="2">
           <input type="submit" name="page" value="upload"/>
       </td>
   </tr>
    </table>
</form>
    </div>
</body>
</html>
