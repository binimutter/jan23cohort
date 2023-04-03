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
		<h1>Hello</h1>
	</header>
	<main>
	<form:form action="/createImg" method="post" modelAttribute="image">
		<section>
			<label for="name">Image Name</label>
			<input type="text" name="name">
			<form:errors path="name" />
		</section>
		<section>
			<label for="url">Link to Image</label>
			<input type="text" name="url">
			<form:errors path="url" />
		</section>
		<section>
			<label for="category">Category</label>
			<input type="text" name="category">
			<form:errors path="category" />
		</section>
		<button>Add Image</button>
	</form:form>
		<c:forEach var="i" items="${ viewImages }">
			<div>
				<h3>${ i.name }</h3>
				<img src="${ i.url }" alt="${ i.name }" />
				<h3>Category ${ i.category }</h3>
			</div>
		</c:forEach>
	</main>
</body>
</html>