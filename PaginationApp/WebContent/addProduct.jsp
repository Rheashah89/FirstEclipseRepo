<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<h1>Add Product</h1>
	<form action="AddProduct">
		<label>ID</label> 
			<input type="text" name="id" /> <br>
		<label>Name</label>
			<input type="text" name="name" /> <br>
		<label>Price</label> 
			<input type="text" name="price" /> <br>
		<label>Quantity</label> 
			<input type="text" name="quantity" /><br>
		<button type="submit" name="add">Add Product</button><br>
	</form>
	<form action="DisplayTableData">
		<button type="submit" name="display">List Products</button>
	</form>
</body>
</html>