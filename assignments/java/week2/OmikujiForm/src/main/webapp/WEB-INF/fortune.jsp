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
<title>Omikuji Fortune</title>
</head>
<body>
	<div class="form-container">
		<header>
			<h1>Here's Your Omikuji</h1>
		</header>
		<main class="fortune">
			<p class="col-4 fs-4">In <c:out value="${year}"></c:out> years, you will live in <c:out value="${city}"></c:out> with <c:out value="${person}"></c:out> as your roommate, <c:out value="${hobby}"></c:out> as a living. The next time you see a <c:out value="${animal}"></c:out>, you will have good luck. Also, <c:out value="${compliment}"></c:out>.</p>
			<a href="/omikuji" class="btn btn-primary mt-2 float-end">Go Back</a>
		</main>
	</div>
</body>
</html>