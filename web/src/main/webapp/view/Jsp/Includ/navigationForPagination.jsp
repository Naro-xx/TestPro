<%--for navigation--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sortFlag eq 'down'}">
    <input type="hidden" name="sortFlag" value="up">
</c:if>
<c:if test="${sortFlag eq 'up'}">
    <input type="hidden" name="sortFlag" value="down">
</c:if>
<div align="center">
    <input type="hidden" value="next" name="page">
<input type="submit" value="<<" name="navBtn"/>
    <input type="hidden" value="next" name="page">
<input type="submit" value="<" name="navBtn"/>
    <input type="hidden" value="next" name="page">
    <input type="number" value="${currentPage}" name="currentPage" MAX="${noOFPages}"/>
    <input type="submit" value="GoTo" />
<input type="hidden" value="next" name="page">
<input type="submit" value=">" name="navBtn"/>
    <input type="hidden" value="next" name="page">
<input type="submit" value=">>" name="navBtn"/>
<h5>Total pages:${currentPage}/${noOFPages}</h5>
</div>