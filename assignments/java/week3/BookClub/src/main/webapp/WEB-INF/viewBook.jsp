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
	<header class="header-container">
		<h1>${ theBook.title }</h1>
		<nav>
			<a href="/dashboard">back to the shelves</a>
		</nav>
	</header>
    <main>
	    <c:if test="${ user_id == theBook.user.id }">
	    	<h4>${ theBook.user.name } read ${ theBook.title } by ${ theBook.author }.</h4>
	    </c:if>
	    <h4>Here are ${ theBook.user.name }'s thoughts:</h4>
	    <p>${ theBook.thoughts }</p>
	     <c:if test="${ user_id == theBook.user.id }">
		    <a href="/book/${ theBook.id }/edit">edit</a>
		    <a href="/book/${ theBook.id }/delete">delete</a>
	    </c:if>
    </main>
    <footer>
    
    </footer>
</body>
</html>