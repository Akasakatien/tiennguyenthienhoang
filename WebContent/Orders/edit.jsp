<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${error }
	<form action="Orders?action=edit" method="post">
		<table>
			<tr>
				<td>id</td>
				<td><input type="hidden" name="id" value="${order.id }" ></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" value="${order.name }" ></td>
			</tr>
			<tr>
				<td>Date Creation</td>
				<td><input type="date" name="dateCreation" value="${order.dateCreation }"></td>
			</tr>
			<tr>
					<th>Status</th>
					<td><input type="checkbox" name="status"
						${order.status == true ? 'checked' : '' }></td>
			</tr>		
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="save"></td>
			</tr>
		</table>
	</form>
</body>
</html>