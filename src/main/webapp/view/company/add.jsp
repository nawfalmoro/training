<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Add Company</title>
</head>
<body>
	<h1>Add Company</h1>
	<form action="company" method="post">
	<input type="hidden" name="add">
		<ul>
			<li>name: <input type="text" name="name"></li>		
		</ul>
		<input type="submit" value="add">
	</form>
	<a href="/contacts">Back to contacts list</a>
</body>
</html>