<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Edit Person</title>
</head>
<body>
	<h1>Edit Person : ${person.name}</h1>
	<form action="person" method="post">
	<input type="hidden" name="edit">
	<input type="hidden" name="id" value="${person.id}">
	<c:set var="address" value="${person.address}"></c:set>
	<input type="hidden" name="adresseId" value="${address.id}">
		<ul>
			<li>name: <input type="text" name="name" value="${person.name}"></li>
			<li>street: <input type="text" name="street" value="${address.street}"></li>
			<li>city: <input type="text" name="city" value="${address.city}"></li>
			<li>zip: <input type="text" name="zip" value="${address.zip}"></li>
			<li>state: <input type="text" name="state" value="${address.state}"></li>
		
		</ul>
		<input type="submit" value="edit">
	</form>
	<form action="person" method="post">
		<input type="hidden" name="delete">
		<input type="hidden" name="id" value="${person.id}">
		<input type="submit" value="Delete">
	</form>
	<a href="/person?id=${person.id}">Back to Persons View</a>
</body>
</html>