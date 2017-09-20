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
	<form action="Orders?action=add" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Date Creation</td>
				<td><input type="date" name="dateCreation"></td>
			</tr>
			<tr>
				<td>Payment</td>
				<td>
					<select name="payment">
						<option value="paypal">PayPal</option>
						<option value="cash">Cash</option>
						<option value="creditCards">Credit Cards</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="save"></td>
			</tr>
		</table>
	</form>
</body>
</html>