<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
			<tr>
				<th> EmpID </th>
				<th> Name </th>
				<th> Salary </th>
				
			</tr>
			
			
			<c:forEach items="${requestScope.empList}" var="emp">
				<tr>
					<td>${emp.empNo}</td>
					<td>${emp.empNm}</td>
					<td>${emp.empSal}</td>
					
<%-- 					<td><a href="getEmpDetails.do?eid=${emp.empNo}">Details</a></td>
 --%>			
 	</tr>
			</c:forEach>
	
		</table>
</body>
</html>