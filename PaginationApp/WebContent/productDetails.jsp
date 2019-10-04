<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.lti.model.Product"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr: {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<h2>Product Table Details</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<%
			ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("list");
			for (Product product : list) {
		%>

		<%-- Arranging data in tabular form 
        --%>
		<tr>
			<td><%=product.getId()%></td>
			<td><%=product.getName()%></td>
			<td><%=product.getPrice()%></td>
			<td><%=product.getQuantity()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<form action="CursorServlet">
		<button type="submit" name="pointer" value='-1'>Previous</button>
		<nbsp>
		<nbsp>
		<button type="submit" name="pointer" value='1'>Next</button><br>
	</form>
	<form action="addProduct.jsp">
		<button type="submit" >Add Product</button>
	</form>
</body>
</html>