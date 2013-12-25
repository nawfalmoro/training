<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Add an Office</title>
</head>
<body>
	<h1>Add an Office</h1>
	<form action="office" method="post">
	<input type="hidden" name="add">
	<input type="hidden" name="company_id" value="${company.id}">
		<ul>
			<li>Office name: <input type="text" name="name"></li>
			<li>street: <input type="text" name="street"></li>
			<li>city: <input type="text" name="city"></li>
			<li>zip: <input type="text" name="zip"></li>
			<li>state: <input type="text" name="state"></li>
		
		</ul>
		<input type="submit" value="add">
	</form>
	<a href="${company.url}">Back to ${company.name}</a>
</body>
</html>