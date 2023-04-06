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
<!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> -->
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Stickers and Categories</title>
</head>
<body>
	<header>
		<h1>Our Stickers and Categories</h1>
		<nav>
			<a href="/">Home</a>
			<a href="/dashboard">Dashboard</a>
			<a href="/addCategory">Add Category</a>
			<a href="/addSticker">Add Sticker</a>
			<form:form action="/chooseCat" method="post" modelAttribute="sessionForm">
				<section>
					<label for="cat">Choose Category</label>
					<select name="cat" id="">
						<c:forEach var="c" items="${ allCats }">
							<option value="${ c.id }">${ c.name }</option>
						</c:forEach>
					</select>
				</section>
				<button>Choose Category</button>
			</form:form>
		</nav>
	</header>
	<main>
		<div class="row">
			<div class="column">
				<h2>The Stickers</h2>
				<table>
					<tr>
						<th>Sticker Id</th>
						<th>Sticker Category</th>
						<th>Sticker Image</th>
						<th>Actions</th>
					</tr>
					<c:forEach items="${ allStickers }" var="s">
						<tr>
							<td>${ s.id }</td>
							<td>${ s.cat.name }</td>
							<td><img src="${ s.url }" alt="${ s.name }" /></td>
							<td><a href="/sticker/${ s.id }/view">View</a> | <a href="/sticker/${ s.id }/edit">Edit</a> | <a href="/sticker/${ s.id }/delete">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="column">
				<h2>The Categories</h2>
				<table>
					<tr>
						<th>Category Id</th>
						<th>Category Name</th>
						<th>Sticker Count</th>
						<th>Actions</th>
					</tr>
					<c:forEach items="${ allCats }" var="c">
						<tr>
							<td>${ c.id }</td>
							<td>${ c.name }</td>
							<td></td>
							<td></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</main>
	<footer>
		<h3>Stickers and Categories</h3>
	</footer>
</body>
</html>