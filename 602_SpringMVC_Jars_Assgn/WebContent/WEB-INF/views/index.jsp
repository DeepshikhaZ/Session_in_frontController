<%@page isELIgnored="false" %>

<body bgcolor="#c9c9c9">
	<h1>Index Page</h1>
	<hr>
	<h3>${title}</h3>
	<br/>
	<a href="${pageContext.request.contextPath}/home/showHome">Home</a> <br/>
	<a href="${pageContext.request.contextPath}/user/userList">UserList</a>
</body>