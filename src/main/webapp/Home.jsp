<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<%-- <%if((request.getSession(false).getAttribute("Admin") == null || request.getSession(false).getAttribute("Normal") == null) ){%>
<jsp:forward page="/Login.jsp"></jsp:forward>
<%} %> --%>
<body>
	<center>
		<h2>Home</h2>
	</center>
	Welcome
	<%=request.getAttribute("username")%>


	<%if (request.getSession(false).getAttribute("Admin") != null
				&& request.getSession(false)
							.getAttribute("Admin")
							.equals(request.getAttribute("username"))) {%>
	<div style="text-align: right">
		You will see this only if you are ADMIN <a
			href="<%=request.getContextPath()%>/AddFilm.jsp">Add Film</a>
	</div>
	<%}%>
	
	
	<div style="text-align: right">
		<a href="<%=request.getContextPath()%>/ListFilmServlet">List Films</a>
	</div>

</body>
</html>