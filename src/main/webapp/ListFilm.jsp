<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>List Films</h2>
	</center>
	Welcome
	
 	<%-- <table>
		<tr>
			<%List<Film> result = request.getAttribute("films");
            for (Film film : result) {%>
			<td>
				<%out.println(film.getName());%>
			</td>
			<%}%>
		</tr>
	</table>  --%>

<c:forEach items="${films}" var="film">
   	Film = <c:out value="${film._title}" />
</c:forEach> 

</body>
</html>