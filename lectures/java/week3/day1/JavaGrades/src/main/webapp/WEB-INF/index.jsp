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
		<h1>Java Grades</h1>
		<nav>
			<a href="/">Home</a>
			<a href="/addStudent">Add New Student</a>
			<a href="/addGrade">Add Grades</a>
		</nav>
	</header>
	<main>
		<table>
			<tr>
				<th>Student</th>
				<th>Bio</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${allStudents}" var="s">
				<tr>
					<td>${ s.firstName } ${ s.lastName }</td>
					<td>${ s.bio.bio }</td>
					<td><a href="/student/${s.id}/edit">Edit</a> | <a href="/student/${s.id}/addBio">Add Bio</a> | <a href="/student/${ s.id }/show">Show Student</a> | <a href="/student/${ s.id }/addGrade">Add Grade</a></td>
				</tr>
			</c:forEach>
		</table>
	
	</main>
</body>
</html>