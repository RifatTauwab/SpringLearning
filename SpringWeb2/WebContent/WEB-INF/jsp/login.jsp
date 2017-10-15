<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Login Page</title>
<link
	href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
</head>
<body onload='document.f.j_username.focus();'>
	<h3>Login with Username and Password</h3>
	<div class="col-md-6 col-md-offset-3">
		<form class="form-horizontal"
			action='${pageContext.request.contextPath}/j_spring_security_check'
			method='post'>
			<fieldset>

				<!-- Form Name -->
				<legend>Login</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="j_username">Username</label>
					<div class="col-md-6">
						<input id="j_username" name="j_username" type="text"
							placeholder="Username" class="form-control input-md">

					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="j_password">Password</label>
					<div class="col-md-6">
						<input id="j_password" name="j_password" type="password"
							placeholder="" class="form-control input-md">

					</div>
				</div>
				
				<div class="alert-danger">
					<c:if test="${param.error != null}">
				        Incorrect Username or Password !!
				    </c:if>
				</div>
				
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">
						<button id="submit" name="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>

			</fieldset>
		</form>
		
		<p><a href="<c:url value='/AccountForm'/>">create new account</a></p>
	</div>
</body>
</html>