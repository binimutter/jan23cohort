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
<<<<<<< HEAD
		<h1>Hello</h1>
=======
		<h1>Java Grades</h1>
>>>>>>> eefdeb3c81961efdd10473e7b1e7869c80ea96fb
		<nav>
			<a href="/">Home</a>
			<a href="/addStudent">Add New Student</a>
		</nav>
	</header>
<<<<<<< HEAD
	<h2>Add Your Bio</h2>
	<form:form action="/student/${ s.id }/createBio" method="post" modelAttribute="bioForm">
		<label for="bio">Bio</label>
		<textarea name="bio" id="" cols="30" rows="10"></textarea>
		<form:errors path="bio" class="text-warning"/>
		<input type="hidden" name="student" value="${ s.id }" />
		<button>Add Bio</button>
	</form:form>
=======
	<main>
		<h2>Add your Bio</h2>
		<form:form action="/student/${s.id}/createBio" method="post" modelAttribute="bioForm">
			<section>
				<label for="bio">Bio</label>
				<textarea name="bio" id="" cols="30" rows="10"></textarea>
				<form:errors path="bio" class="text-warning"/>
			</section>
			<!-- The name here must match the private Class attribute NOT the join column name  -->
			<input type="hidden" name="student" value="${s.id}" />
			<button>Add Bio</button>
		</form:form>
	</main>
>>>>>>> eefdeb3c81961efdd10473e7b1e7869c80ea96fb
</body>
</html>