<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entities.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Product product = new Product("01", "name1", 100000, 10, "images/seulbi.png");
	%>
	<h2>Product Info</h2>
	<table cellpadding="2" cellspacing="2">
		<tr>
			<td>ID</td>
			<td><%=product.getId()%></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><%=product.getName()%></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><%=product.getPrice()%></td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td><%=product.getQuantity()%></td>
		</tr>
		<tr>
			<td>Image</td>
			<td><img width="100" height="100" src="<%=product.getPhoto()%>"></td>
		</tr>
		<tr>
			<td>Total</td>
			<td><%=product.getPrice() * product.getQuantity()%></td>
		</tr>
	</table>
	<%
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("02", "name2", 200000, 20, "images/seulbi.png"));
		products.add(new Product("03", "name3", 300000, 30, "images/seulbi.png"));
		products.add(new Product("04", "name4", 400000, 5, "images/seulbi.png"));
	%>
	<h3>Product List</h3>
	<table border="1" cellpadding="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Photo</th>
			<th>Total</th>
		</tr>
		<tr>
			<%
				int thanhTien = 0;
			%>
			<%
				for (Product p : products) {
			%>
		
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getName()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getQuantity()%></td>
			<td><img width="100" height="100" src="<%=p.getPhoto()%>"></td>
			<td><%=p.getPrice() * p.getQuantity()%></td>

		</tr>
		<%
			thanhTien += p.getPrice() * p.getQuantity();
			}
		%>
		<tr>
			<td colspan="5">Thanh Tien</td>
			<td><%=thanhTien %></td>
		</tr>
		
	</table>
</body>
</html>