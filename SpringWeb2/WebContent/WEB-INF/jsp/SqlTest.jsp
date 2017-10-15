<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sql Test</title>
</head>
<body>
    <sql:query var="rs" dataSource="jdbc/spring">
        select id, name, email from notices
    </sql:query>
    <c:forEach var="row" items="${rs.rows}">
        id : ${row.id}<br/>
        name : ${row.name}<br/>
        email : ${row.email }<br/>
    </c:forEach>
</body>
</html>