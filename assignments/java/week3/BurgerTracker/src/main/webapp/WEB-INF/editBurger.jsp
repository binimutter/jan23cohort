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
<title>Burger Tracker</title>
</head>
<body>
	<div>
		<div class="header-container">
			<h1>Edit Burger</h1>
			<a href="/">Go back</a>
		</div>
		<form:form action="/burger/${burger.id}/update" method="post" modelAttribute="burgerEditForm">
			<!-- Input below is needed to the update form only -->
			<input type="hidden" name="_method" value="put">
			<section>
				<label for="name">Burger Name</label>
				<input type="text" name="name" id="" value="${ burger.name }" />
				<form:errors path="name" class="text-warning"/>
			</section>
			<section>
				<form:label path="restaurant">Restaurant Name</form:label>
				<form:input path="restaurant" type="text" value="${ burger.restaurant }" />
				<form:errors path="restaurant" class="text-warning" />
			</section>
			<section>
				<form:label path="rating">Rating</form:label>
				<form:input path="rating" type="number" value="${ burger.rating }" />
				<form:errors path="rating" class="text-warning" />
			</section>
			<section>
				<form:label path="notes">Notes</form:label>
				<form:input path="notes" type="text" value="${ burger.notes }" />
				<form:errors path="notes" class="text-warning" />
			</section>
			<button class="btn btn-primary mt-2">Submit</button>
		</form:form>
	</div>
</body>
</html>