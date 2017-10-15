<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
<title>Notices</title>
</head>
<body>
 
    <table class="table table-striped table-inverse">
    	<tr><th>id</th><th>name</th><th>email</th><th>text</th></tr>
    <c:forEach var="notice" items="${notices}">
        <tr>
            <td>${notice.id}</td>
            <td>${notice.name}</td>
            <td>${notice.email }</td>
            <td>${notice.text }</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>