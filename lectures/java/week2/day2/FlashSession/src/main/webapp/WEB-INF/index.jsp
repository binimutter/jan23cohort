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
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>Hello</h1>
		<h4 style="color: red;"><c:out value="${ session }" /></h4>
	</header>
	<main>
		<h2>Pet Name: <c:out value="${ petName }"/></h2>
		<h2>Pet Age: <c:out value="${ petAge }" /></h2>
		<form action="/submit" method='post'>
			<label for="petName">Pet Name</label>
			<input type="text" name="petName" id="" />
			<label for="petAge">PetAge</label>
			<input type="number" name="petAge" id="" />
			<button>Submit</button>
		</form>
	</main>
</body>
</html>