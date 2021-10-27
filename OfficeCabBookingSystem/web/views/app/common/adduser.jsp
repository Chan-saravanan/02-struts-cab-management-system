<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create user</title>
</head>
<body>
	<h3>Create user</h3>
	<s:form method="post" action='/user/create'>
		<s:textfield name="signupAccount.username" label="username"/>
		<s:textfield name="signupAccount.firstname" label="firstname"/>
		<s:textfield name="signupAccount.lastname" label="lastname"/>
		<s:textfield name="signupAccount.password" label="password"/>
		<s:textfield name="signupAccount.confirmPassword" label="confirm password"/>
		<s:submit/>
	</s:form>
</body>
</html>