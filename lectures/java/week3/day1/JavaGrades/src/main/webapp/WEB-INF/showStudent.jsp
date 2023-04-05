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
<title>Java Grades</title>
</head>
<body>
	<header>
		<h1>Hello</h1>
		<nav>
			<a href="/">Home</a>
			<a href="/addStudent">Add New Student</a>
		</nav>
	</header>
	<main>
		<h2>${ student.firstName } ${ student.lastName }</h2>
		<!-- Because of the way we set up our models we just need call the student then the class then the attribute to display -->
		<p>${ student.bio.bio }</p>
		<%-- <p>${ student.grades.score }</p> --%>
		<table>
			<tr>
				<th>Grades</th>
			</tr>
			<c:forEach var="g" items="${ student.grades }">
				<tr>
					<td>${ g.score }</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>