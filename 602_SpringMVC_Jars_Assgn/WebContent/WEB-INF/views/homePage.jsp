<%@page isELIgnored="false"%>
<body bgcolor="#c9c9c9">
	<h1>Home Page</h1>
	<hr>
	<h3>${msg}</h3>
	<hr>
	<h3>Hello ${user.userId} ${user.username}, your role is ${user.role}</h3>
	<br/>
	<a href="${pageContext.request.contextPath}/home/greet">Greeting</a>
	<br/>
	<a href="${pageContext.request.contextPath}/">Return to landing page</a>
</body>