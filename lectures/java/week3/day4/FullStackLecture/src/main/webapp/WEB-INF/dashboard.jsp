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
<title>Full Stack Lecture</title>
</head>
<body>
	<header>
		<h1>Hello, ${ theUser.firstName }</h1>
		<nav>
			<a href="/">Home</a>
			<c:if test="${ user_id != null }">
				<a href="/dashboard">Dashboard</a>
				<a href="/addPuppy">Add Puppy</a>
				<a href="/logout">Logout</a>
			</c:if>
			<c:if test="${ user_id == null }">
				<a href="/logReg">Login</a>
			</c:if>
		</nav>
	</header>
    <main>
    	<div class="row">
    		<div class="column">
    			<h2>All Puppies</h2>
    			<c:forEach items="${ allPups }" var="pup">
    				<div class="column">
    					<h3><a href="/puppy/${ pup.id }/view">${ pup.name }</a></h3>
    					<p>Breed: ${ pup.breed } Owner: ${ pup.owner.firstName }</p>
    				</div>
    			</c:forEach>
    		</div>
    		<div class="column">
    			<h2>Your Puppies, ${ theUser.firstName }</h2>
    			<c:forEach items="${ allPups }" var="pup">
    				<c:if test="${ user_id == pup.owner.id }">
    					<div class="column">
	    					<h3><a href="/puppy/${ pup.id }/view">${ pup.name }</a></h3>
	    					<p>Breed: ${ pup.breed } Owner: ${ pup.owner.firstName }</p>
	    				</div>
    				</c:if>
    			</c:forEach>
    		</div>
    	</div>
    </main>
    <footer>
    
    </footer>
</body>
</html>