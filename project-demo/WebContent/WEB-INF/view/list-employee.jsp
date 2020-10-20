<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>Employee List</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
		<div class="heading_div">
			<h2>Employee Details</h2>
		</div>
			<div class="button-container">
			
				<input type="button" value="Add Employee"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" />
			</div>
		</div>
	</div>

	<div id="container">

		<div id="content">			

			<!--  add our html table here -->

			<table>
				<tr id="headRow">
					<th><a href="/project-demo/app/employee/app/orderById">Id</a></th>
					<th><a href="/project-demo/app/employee/app/orderByFirstName">First Name</a></th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our employee -->
				<c:forEach var="tempEmployee" items="${employee}">

					<!-- construct an "edit" link with employee id -->
					<c:url var="editLink" value="/app/employee/app/showFormForUpdate">
						<c:param name="employeeId" value="${tempEmployee.id}" />
					</c:url>
					
					<!-- construct an "delete" link with employee id -->
					<c:url var="deleteLink" value="/app/employee/app/delete">
						<c:param name="employeeId" value="${tempEmployee.id}" />
					</c:url>

					<tr>
						<td>${tempEmployee.id}</td>
						<td>${tempEmployee.firstName}</td>
						<td>${tempEmployee.lastName}</td>
						<td>${tempEmployee.email}</td>
						<td><a href="${editLink}"><input type="button" value="Edit"
				class="edit-button" /></a> <a href="${deleteLink}" onclick="if(!(confirm('Delete ${tempEmployee.firstName} from the Employee List'))) return false"><input type="button" value="Delete"
				class="delete-button" /></a></td>
				
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>









