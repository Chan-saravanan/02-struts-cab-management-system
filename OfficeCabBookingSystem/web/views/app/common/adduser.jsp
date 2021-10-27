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
	<s:form name="signup" id="signup" method="post" action="/user/create">
		<s:hidden name="actionType" />
		<s:textfield name="signupAccount.username" label="username"/>
		<s:textfield name="signupAccount.firstName" label="firstname"/>
		<s:textfield name="signupAccount.lastName" label="lastname"/>
		<s:textfield name="signupAccount.password" label="password"/>
		<s:textfield name="signupAccount.confirmPassword" label="confirm password"/>
		<s:submit onclick="changeAction();"/>
	</s:form>
</body>
<style>
function changeAction(){
	alert("Submitting the form!");
	document.signup.actionType.value='submit';
	document.signup.submit();
}
</style>
</html>