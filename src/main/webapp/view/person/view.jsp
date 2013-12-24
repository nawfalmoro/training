<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>View Person</title>
</head>
<body>
	<h1>View Person : ${person.name}</h1>
		<ul>
			<li>name: ${person.name}</li>
			<c:set var="address" value="${person.address}"></c:set>
			<li>street: ${address.street}</li>
			<li>city:${address.city}</li>
			<li>zip: ${address.zip}</li>
			<li>state: ${address.state}</li>
		
		</ul>
	</form>
	<a href="/person?edit=1&id=${person.id}">Edit Person</a>
	<a href="/contacts">Back to contacts list</a>
</body>
</html>