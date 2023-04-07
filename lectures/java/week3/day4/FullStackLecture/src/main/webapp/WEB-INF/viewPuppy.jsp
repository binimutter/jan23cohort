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
<title>Full Stack Lecture</title>
</head>
<body>
	<header>
		<h1>Hello</h1>
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
    	<h1>${ thePuppy.name }</h1>
    	<h3>Breed: ${ thePuppy.breed }</h3>
    	<h3>Owner: ${ thePuppy.owner.firstName } ${ thePuppy.owner.lastName }</h3>
    	<c:if test="${ user_id == thePuppy.owner.id }">
    	<form:form action="/puppy/${ thePuppy.id }/update" method="post" modelAttribute="editPuppyForm">
    		<input type="hidden" name="_method" value="put"/>
    		<section>
    			<label for="name">Name your Puppy</label>
    			<input type="text" name="name" id="" value="${ thePuppy.name }"/>
    			<form:errors path="name" class="text-danger" />
    		</section>
    		<section>
    			<label for="breed">The Puppy's Breed</label>
    			<input type="text" name="breed" id="" value="${ thePuppy.breed }" />
    			<form:errors path="breed" class="text-danger" />
    		</section>
    		<section>
    			<input type="hidden" name="owner" value="${ user_id }" />
    		</section>
    		<button>Update Puppy</button>
    	</form:form>
    		<a href="/puppy/${ thePuppy.id }/edit">Edit Puppy Info</a>
    		<a href="/puppy/${ thePuppy.id }/delete">Remove Puppy</a>
    	</c:if>
    </main>
    <footer>
    
    </footer>
</body>
</html>