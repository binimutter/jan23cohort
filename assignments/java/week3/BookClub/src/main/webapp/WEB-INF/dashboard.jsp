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
<title>Book Club</title>
</head>
<body class="main-container">
	<div class="header-container">
		<div>
			<h1>Welcome ${ theUser.name }</h1>
			<h4>Books from everyone's shelves</h4>
		</div>
		<div class="nav-link-container">
			<c:if test="${ user_id != null }">
				<a href="/logout">Logout</a>
				<a href="/addBook">+ Add a book to my shelf!</a>
			</c:if>
			<c:if test="${ user_id == null }">
				<a href="/logReg">Login</a>
			</c:if>
		</div>
	</div>
    <main>
    	<table class="table">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
			</tr>
			<c:forEach items="${allBooks}" var="b">
				<tr>
					<td>${ b.id }</td>
					<td> <a href="/book/${ b.id }/view">${ b.title }</a></td>
					<td>${ b.author }</td>
					<td>${ b.user.name }</td>
				</tr>
			</c:forEach>
		</table>
    </main>
    <footer>
    
    </footer>
</body>
</html>