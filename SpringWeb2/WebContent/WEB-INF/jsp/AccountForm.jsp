<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
</head>
<body>

	<sf:form class="form-horizontal"
		action="${pageContext.request.contextPath}/CreateAccount"
		method="post" commandName="user">
		<fieldset>

			<!-- Form Name -->
			<legend>Create User Acoount</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="name">Username</label>
				<div class="col-md-6">
					<sf:input id="username" path="username" name="username" type="text"
						placeholder="enter username" class="form-control input-md" />
					<sf:errors path="username" cssClass="alert-danger"></sf:errors>
				</div>
			</div>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="email">Email</label>
				<div class="col-md-6">
					<sf:input id="email" path="email" name="email" type="text"
						placeholder="enter valid email" class="form-control input-md" />
					<sf:errors path="email" cssClass="alert-danger"></sf:errors>
				</div>
			</div>
			<!-- password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="password">Password</label>
				<div class="col-md-6">
					<sf:input id="password" path="password" name="password" type="text"
						placeholder="" class="form-control input-md" />
					<sf:errors path="password" cssClass="alert-danger"></sf:errors>
				</div>
			</div>
			<!-- confirm password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="password">confirm
					password</label>
				<div class="col-md-6">
					<input id="confirmpassword" name="confirmpassword" type="text"
						placeholder="" class="form-control input-md" />
				</div>
			</div>
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="submit"></label>
				<div class="col-md-4">
					<button id="submit" name="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</fieldset>
	</sf:form>
	<script>
		var password1 = document.getElementById('password');
		var password2 = document.getElementById('confirmpassword');

		var checkPasswordValidity = function() {
			if (password1.value != password2.value) {
				password1.setCustomValidity('');
			} else {
				password1.setCustomValidity("<fmt:message key='UnmatchedPassword.user.password' />");
			}
		};

		password1.addEventListener('change', checkPasswordValidity, false);
		password2.addEventListener('change', checkPasswordValidity, false);

		var form = document.getElementById('user');
		form.addEventListener('submit', function() {
			checkPasswordValidity();
			if (!this.checkValidity()) {
				event.preventDefault();
				//Implement you own means of displaying error messages to the user here.
				password1.focus();
			}
		}, false);
	</script>
</body>
</html>