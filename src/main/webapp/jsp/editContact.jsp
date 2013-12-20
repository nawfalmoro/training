<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Edit Contact</title>
</head>
<body>
	<h1>Edit Contact : ${contact.name}</h1>
	<form action="contact" method="post">
	<input type="hidden" name="save">
	<input type="hidden" name="id" value="${contact.id}">
	<input type="hidden" name="adresseId" value="${contact.adresseId}">
		<ul>
			<li>name: <input type="text" name="name" value="${contact.name}"></li>
			<li>street: <input type="text" name="street" value="${address.street}"></li>
			<li>city: <input type="text" name="city" value="${address.city}"></li>
			<li>zip: <input type="text" name="zip" value="${address.zip}"></li>
			<li>state: <input type="text" name="state" value="${address.state}"></li>
		
		</ul>
		<input type="submit" value="save">
	</form>
	<form action="contact" method="post">
		<input type="hidden" name="delete">
		<input type="hidden" name="id" value="${contact.id}">
		<input type="submit" value="Delete">
	</form>
	<a href="/contact?id=${contact.id}">Back to contacts View</a>
</body>
</html>