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
	<a href="/company?edit=1&id=${company.id}">Edit Company</a>
	<a href="/contacts">Back to contacts list</a>
</body>
</html>