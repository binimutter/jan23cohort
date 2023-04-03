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
	<div class="top-container">
		<h1>Burger Tracker</h1>
		<table class="table">
			<tr>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Rating (out of 5)</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${allBurgers}" var="b">
		        <tr>
		            <td>${b.name}</td>
		            <td>${b.restaurant}</td>
		            <td>${b.rating}</td>
		            <td><p><a href="/burger/${b.id}/edit">edit</a> | <a href="/burger/${b.id}/delete">delete</a></p></td>
		        </tr>
		    </c:forEach>
		</table>
	</div>
	<div class="bottom-container">
		<h1>Add a Burger:</h1>
		<form:form action="/burger/create" method="post" modelAttribute="burger" class="">
		
			<section>
				<label for="name">Burger Name</label>
				<input type="text" name="name" id="" />
				<form:errors path="name" class="text-warning"/>
			</section>
			<section>
				<form:label path="restaurant">Restaurant Name</form:label>
				<form:input path="restaurant" type="text" />
				<form:errors path="restaurant" class="text-warning" />
			</section>
			<section>
				<form:label path="rating">Rating</form:label>
				<form:input path="rating" type="number" />
				<form:errors path="rating" class="text-warning" />
			</section>
			<section>
				<form:label path="notes">Notes</form:label>
				<form:input path="notes" type="text" />
				<form:errors path="notes" class="text-warning" />
			</section>
			<button class="btn btn-primary mt-2">Submit</button>
		</form:form>
	</div>
</body>
</html>