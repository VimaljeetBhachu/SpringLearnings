<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Vjsb Company Home Page</title>
</head>

<body>
	<h2>Vjsb Company Home Page -- HeHeHe</h2>
	<hr>

	<p>Welcome to the Vjsb company home page!</p>

	<!-- Add a logout button -->

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout"/>
		
	</form:form>

</body>

</html>