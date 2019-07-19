<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="java.util.List ,com.lnt.*, com.lnt.core.entities.Employee" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	</head>
<body>
		
		<jsp:include page="Head.jsp"/>
		<h3>List all employees</h3>
		<a href="MainMenu.do">Main Menu</a>
		<table border="1">
			<tr>
				<th>Emp id</th>
				<th>Name</th>
			</tr>
			<% List<Employee> empList=(List<Employee>)request.getAttribute("List");
			for(Employee emp:empList){
			%>
			<tr>
				<td><%= emp.getEmpNo() %></td>
				<td><%= emp.getEmpNm() %></td>
			</tr>
			<% } %>
		                                                                       
		
		</table>
		
</body>
</html>