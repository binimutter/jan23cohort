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
			<a href="/addGrade">Add Grades</a>
		</nav>
	</header>
	<main>
		<h1>Add Grades</h1>
		<form:form action="/createGrade" method="post" modelAttribute="gradeForm">
			<section>
				<label for="score">Grade</label>
				<input type="number" name="score" />
				<form:errors path="score" class="text-warning"/>
			</section>
			<section>
				<label for="theStudent">Student</label>
				<select name="theStudent">
					<c:forEach var="s" items="${ allStudents }">
						<option value="${ s.id }">${ s.firstName } ${ s.lastName }</option>
					</c:forEach>
				</select>
			</section>
			<button>Add Grade</button>
		</form:form>
	</main>
</body>
</html>