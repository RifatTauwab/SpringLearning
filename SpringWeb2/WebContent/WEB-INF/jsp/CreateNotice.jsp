<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
		action="${pageContext.request.contextPath}/CreateNotice" method="get"
		commandName="notice">
		<fieldset>

			<!-- Form Name -->
			<legend>Form created using GET</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="name">Name</label>
				<div class="col-md-6">
					<sf:input id="name" path="name" name="name" type="text"
						placeholder="enter name" class="form-control input-md" />
					<sf:errors path="name" cssClass="alert-danger"></sf:errors>
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
			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="text">Notice</label>
				<div class="col-md-4">
					<sf:textarea class="form-control" id="text" path="text" name="text"></sf:textarea>
					<sf:errors path="text" cssClass="alert-danger"></sf:errors>
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

	<sf:form class="form-horizontal"
		action="${pageContext.request.contextPath}/CreateNotice" method="post"
		commandName="notice">
		<fieldset>

			<!-- Form Name -->
			<legend>Form created using GET</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="name">Name</label>
				<div class="col-md-6">
					<sf:input id="name" path="name" name="name" type="text"
						placeholder="enter name" class="form-control input-md" />
					<sf:errors path="name" cssClass="alert-danger"></sf:errors>
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
			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="text">Notice</label>
				<div class="col-md-4">
					<sf:textarea class="form-control" id="text" path="text" name="text"></sf:textarea>
					<sf:errors path="text" cssClass="alert-danger"></sf:errors>
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

</body>
</html>