<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Contacts</title>
</head>
<body>
	<h1>Contacts</h1>
	<table border="1">
		<c:forEach var="contact" items="${contacts}">
			<tr> 
				<td><a href="/contact?id=${contact.id}">${contact.id}</a></td>
				<td>${contact.name}</td>
				<td><a href="/contact?edit=1&id=${contact.id}">Edit Contact</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/contact?add">Add contact</a>
</body>
</html>