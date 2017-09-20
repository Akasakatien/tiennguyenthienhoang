<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Orders?action=search" method="post">
		<a href="Orders?action=add">Add Order</a> 
		<br> 
		<input type="date" name="dateCreation"><input type="submit" value="search">
		<br>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Date Creation</th>
				<th>Payment</th>
				<th>Status</th>
				<th>Option</th>
			</tr>
			<c:forEach var="o" items="${orders }" varStatus="i">
				<tr>
					<td>${o.id }</td>
					<td>${o.name }</td>
					<td>${o.dateCreation }</td>
					<td>${o.payment }</td>
					<td>${o.status }</td>
					<td><a href="Orders?action=edit&id=${o.id }">Edit</a> | <a
						href="Orders?action=delete&id=${o.id }">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>