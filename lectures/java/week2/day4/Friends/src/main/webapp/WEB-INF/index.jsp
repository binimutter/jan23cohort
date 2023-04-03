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
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> -->
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS -->
<!-- <script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->
<title>Friends</title>
</head>
<body>
	<header>
		<h1>Friends</h1>
		<nav>
			<a href="/">Home</a>
		</nav>
	</header>
	<main>
		<h2>My Friend list</h2>
		<div class="row">
			<ul>
				<c:forEach var="i" items="${viewFriends}">
					<li>${ i.name }
						<ul>
							<li>${ i.favColor }</li>
							<li><a href="${ i.linkedIn }">LinkedIn</a></li>
							<li><a href="mailto:${ i.email }">Email</a></li>
							<li><a href="tel${ i.phone }">Phone</a></li>
						</ul>
					</li>
				</c:forEach>
			</ul>
			<form:form action="/addFriend" method="post" modelAttribute="friend">
				<section>
					<label for="name">Friend Name</label>
					<input type="text" name="name">
					<form:errors path="name" />
				</section>
				<section>
					<label for="favColor">Favorite Color</label>
					<input type="text" name="favColor">
					<form:errors path="favColor" />
				</section>
				<section>
					<label for="linkedIn">LinkedIn URL</label>
					<input type="text" name="linkedIn">
					<form:errors path="linkedIn" />
				</section>
				<section>
					<label for="email">Email</label>
					<input type="email" name="email">
					<form:errors path="email" />
				</section>
				<section>
					<label for="phone">Phone</label>
					<input type="text" name="phone">
					<form:errors path="phone" />
				</section>
				<button>Add Friend</button>
			</form:form>
		</div>
	</main>
	<footer>
	
	</footer>
</body>
</html>