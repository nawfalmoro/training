<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Add Person</title>
</head>
<body>
	<h1>Add Person</h1>
	<form action="person" method="post">
	<input type="hidden" name="add">
		<ul>
			<li>name: <input type="text" name="name"></li>
			<li>street: <input type="text" name="street"></li>
			<li>city: <input type="text" name="city"></li>
			<li>zip: <input type="text" name="zip"></li>
			<li>state: <input type="text" name="state"></li>
			<li>Manager 
				<select name="manager_id">
						<option value="0"></option>
						<c:forEach items="${managers}" var="employee">
							<option value="${employee.id}">${employee.name}</option>
						</c:forEach>
				</select>
			</li>
			<li>Employer: 
				<select name="employer_id">
						<option value="0"></option>
						<c:forEach items="${employers}" var="employer">
							<option value="${employer.id}">${employer.name}</option>
						</c:forEach>
				</select>
			</li>
		</ul>
		</ul>
		<input type="submit" value="add">
	</form>
	<a href="/contacts">Back to contacts list</a>
</body>
</html>