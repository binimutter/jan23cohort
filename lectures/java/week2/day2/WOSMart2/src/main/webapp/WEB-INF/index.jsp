<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>WOS Mart</title>
</head>
<body>
	<header>
		<h1>Welcome to WOS Mart</h1>
		<nav>
			<a href="/">Home</a>
			<a href="/results">Results</a>
			<a href="/logout">Logout</a>
		</nav>
	</header>
	<main>
		<h2>User Name: <c:out value="${name}"/></h2>
		<h2>Pet Name: <c:out value="${pet}"/></h2>
		<form action="/updateSession" method='post'>
			<label for="name">Name</label>
			<input type="text" name="name" id="" />
			<label for="pet">Pet Name</label>
			<input type="text" name="pet" id="" />
			<button>Change Session Value</button>
		</form>
	</main>
	<footer></footer>
</body>
</html>