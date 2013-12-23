<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Add Contact</title>
</head>
<body>
	<h1>Add Contact</h1>
	<form action="contact" method="post">
	<input type="hidden" name="add">
		<ul>
			<li>name: <input type="text" name="name"></li>
			<li>street: <input type="text" name="street"></li>
			<li>city: <input type="text" name="city"></li>
			<li>zip: <input type="text" name="zip"></li>
			<li>state: <input type="text" name="state"></li>
		
		</ul>
		<input type="submit" value="add">
	</form>
	<a href="/contacts">Back to contacts list</a>
</body>
</html>