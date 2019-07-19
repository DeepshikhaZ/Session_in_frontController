<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.lnt.core.entities.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
Employee emp=(Employee)request.getAttribute("emp");
%>
<table border="1">
<tr>
<th>Employee no</th>
<td>
<%= emp.getEmpNo() %></td></tr>
<tr>
<th>Employee name</th>

<td><%= emp.getEmpNm() %></td>
</tr>
<tr>
<th>Employee Salary</th>
<td>
<%= emp.getEmpSal() %></td>
</tr>
</table>
</body>
</html>