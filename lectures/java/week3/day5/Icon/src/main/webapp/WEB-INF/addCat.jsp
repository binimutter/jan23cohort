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
		<nav>
			<a href="/">Home</a>
			<a href="/dash">Dashboard</a>
			<a href="/addIcon">Add Icon</a>
			<a href="/addCat">Add Category</a>
			<a href="/logout">Logout</a>
		</nav>
	</header>
    <main>
    	<form:form action="/createCat" method="post" modelAttribute="${ catForm }">
    		<section>
    			<label for="name">Name</label>
    			<input type="text" name="name" id="" />
    			<form:errors path="name" class="text-danger" />
    		</section>
    		<button>AddCat</button>
    	</form:form>
    </main>
    <footer>
    
    </footer>
</body>
</html>