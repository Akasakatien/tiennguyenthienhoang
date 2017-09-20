<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>    
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	//code java
	int a = 123;
	String username = "Tien";
	out.print("gia tri a: "+a);
	out.print("<br>");
	out.print("username: "+username);
	String fullname = "Nguyen";
%>
<br>Full Name: <%=fullname %>
<%
	String src = "images/seulbi.png";
	int width = 120;
	int height = 120;
%>
<br>
<img height="<%=height %>" width="<%=width %>" src="<%=src %>">
<br>
<%
	Date date = new Date();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
	out.print(date);
	out.print("<br>");
	out.print(simpleDateFormat.format(date)); 
%>

</body>
</html>