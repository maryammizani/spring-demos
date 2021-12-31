<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<title>Company Homepage</title>
</head>
<body>
	<h2>Company Homepage</h2>
	<hr>
	<p>
		Welcome to Company Homepage
	</p>
	<hr>
	<!--  Display username and role -->
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s):<security:authentication property="principal.authorities" />
	</p>
	
	<hr>
	<!--  Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
</body>	
	
</html>