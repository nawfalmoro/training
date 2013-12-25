<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>View an Office</title>
</head>
<body>
	<h1>View Office : ${office.name}</h1>
		<ul>
			<li>name: ${pffice.name}</li>
			<c:set var="address" value="${office.address}"></c:set>
			<li>street: ${address.street}</li>
			<li>city:${address.city}</li>
			<li>zip: ${address.zip}</li>
			<li>state: ${address.state}</li>
		
		</ul>
	</form>
	<a href="${office.url}&edit=1">Edit Office</a>
	<a href="${office.company.url }">Back to Company view</a>
</body>
</html>