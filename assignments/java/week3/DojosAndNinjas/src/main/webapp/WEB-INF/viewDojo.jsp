<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- for validation -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>${ oneDojo.name }Location Ninjas</h1>
		<nav>
			<a href="/">Home</a>
			<a href="/dojos/new">Add Dojo</a>
			<a href="/ninjas/new">Add Ninja</a>
		</nav>
	</header>
    <main>
    	<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
			<c:forEach items="${oneDojo.ninjas}" var="n">
				<tr>
					<td>${ n.firstName }</td>
					<td> ${ n.lastName }</td>
					<td>${ n.age }</td>
				</tr>
			</c:forEach>
		</table>
    </main>
    <footer>
    
    </footer>
</body>
</html>