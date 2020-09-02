<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Users</title>
</head>
<body>
	<table>
		<tr>
			<td>List Users</td>
		</tr>
		<%! int i = 0;  %>
		<c:forEach items="${list}" var="val">
			<tr>
				<td><%= ++i  %></td>
				<td> ${val.username}</td>
				<td> ${val.email}</td>
				<td>
					<form action="users/${val.id}/delete" method="post">
						<button type="submit">Delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>
		<% i = 0;  %>
	</table>
</body>
</html>