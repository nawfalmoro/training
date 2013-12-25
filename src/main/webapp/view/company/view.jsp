<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>View Company</title>
</head>
<body>
	<h1>View Company : ${company.name}</h1>
		<ul>
			<li>name: ${company.name}</li>
		</ul>
			<table border="1">
		<c:forEach var="office" items="${company.offices}">
			<tr> 
				<td><a href="${office.url}">${office.id}</a></td>
				<td>${office.name}</td>
				<td><a href="${office.url}&edit=1">Edit Office</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/office?add=1&company_id=${company.id}">Add Office</a>
	<a href="${company.url}&edit=1">Edit Company</a>
	<a href="/contacts">Back to contacts list</a>
</body>
</html>