<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head> 
<title>Hamid Doosti company Home Page</title>
</head>

<body>
	<h2>Hamid Doosti company Home Page</h2>
	<hr>
	<p>Welcome to Hamid Doosti Company Home Page! </p>
	<hr>
	<!-- display username and role -->
	
	<p>
		User:<security:authentication property="principal.username"  />
		<br><br>
		Role(s):<security:authentication property="principal.authorities"  />
	</p>
	<hr>
		<p>
			<a href="${pageContext.request.contextPath}/leaders"> LeaderShip Meeting</a>
			(only for manager peeps)
		</p>
	<hr>
	<br><br>
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
			   
	<input type="submit" value="logout" />
		
	</form:form>
</body>
</html>