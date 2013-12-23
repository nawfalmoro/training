<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>View Contact</title>
</head>
<body>
	<h1>View Contact : ${contact.name}</h1>
		<ul>
			<li>name: ${contact.name}</li>
			<c:set var="address" value="${contact.address}"></c:set>
			<li>street: ${address.street}</li>
			<li>city:${address.city}</li>
			<li>zip: ${address.zip}</li>
			<li>state: ${address.state}</li>
		
		</ul>
	</form>
	<a href="/contact?edit=1&id=${contact.id}">Edit Contact</a>
	<a href="/contacts">Back to contacts list</a>
</body>
</html>