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
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>Hello, ${ theUser.firstName }</h1>
		<nav>
			<a href="/">Home</a>
			<a href="/dash">Dashboard</a>
			<a href="/addIcon">Add Icon</a>
			<a href="/addCat">Add Category</a>
			<a href="/logout">Logout</a>
		</nav>
	</header>
    <main>
    	<h3>Icons Added</h3>
    	<div class="row">
    		<div class="box">
	    		<c:forEach items="${ allIcons }" var="i">
	    			<div class="row">
	    				<div class="column">
	    					<h3>Title: ${ i.title }</h3>
	    					<h3>Categories: </h3>
	    					<h3>Added By ${ i.owner.firstName }</h3>
	    				</div>
	    				<div class="row">
	    					<a href="/icon/${ i.id }/view">View</a>
	    					<c:if test="${ i.owner.id == user_id }">
	    						 | 
	    						<a href="/icon/${ i.id }/edit">Edit</a> | 
	    						<a href="/icon/${ i.id }/delete">Delete</a>
	    					</c:if>
	    				</div>
	    			</div>
	    			<hr />
	    		</c:forEach>
	    	</div>
	    	<div class="box">
	    		<c:forEach items="${ allCats }" var="c">
	    			<a href="/cat/${ c.id }/view">${ c.name }</a>
	    		</c:forEach>
	    	</div>
    	</div>
    </main>
    <footer>
    
    </footer>
</body>
</html>