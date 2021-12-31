<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
	<!--  Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
</body>	
	
</html>