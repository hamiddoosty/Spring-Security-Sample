<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Hamid Doosti company Home Page</title>
</head>

<body>
	<h2>Hamid Doosti company Home Page</h2>
	<hr>
	<p>Welcome to Hamid Doosti Company Home Page! m4m4</p>
	
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
			   
	<input type="submit" value="logout" />
		
	</form:form>
</body>
</html>