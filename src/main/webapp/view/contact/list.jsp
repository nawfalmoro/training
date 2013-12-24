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
				<td><a href="/person?id=${contact.id}">${contact.id}</a></td>
				<td>${contact.name}</td>
				<td><a href="/person?edit=1&id=${contact.id}">Edit Contact</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/person?add">Add Person</a>
</body>
</html>