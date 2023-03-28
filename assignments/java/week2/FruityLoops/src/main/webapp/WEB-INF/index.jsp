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
<title>Fruity Loops</title>
</head>
<body>
	<main>
		<h1>Fruit Store</h1>
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${allFruits}" var="item">
		        <tr>
		            <td>${item.name}</td>
		            <td>${item.price}</td>
		        </tr>
		    </c:forEach>
		</table>
	</main>
</body>
</html>