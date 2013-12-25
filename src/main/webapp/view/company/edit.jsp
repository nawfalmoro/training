<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Edit Company</title>
</head>
<body>
	<h1>Edit Company : ${company.name}</h1>
	<table>
		<tr>
			<td>
				<form action="company" method="post">
					<input type="hidden" name="edit"> <input type="hidden"
						name="id" value="${company.id}">
					<ul>
						<li>name: <input type="text" name="name"
							value="${company.name}"></li>
					</ul>
					<input type="submit" value="edit">
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="company" method="post">
					<input type="hidden" name="delete"> <input type="hidden"
						name="id" value="${company.id}"> <input type="submit"
						value="Delete">
				</form>
			</td>
			<td><input type="button" value="Back to Company view"
				onclick="location.href='/company?id=${company.id}';"></td>

		</tr>
	</table>



</body>
</html>