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
	<header>
		<h1>Book Club</h1>
    	<h4>A place for friends to share thoughts on books.</h4>
	</header>
    <main>
    	<div class="d-flex flex-row">
	    	<form:form action="/register" method="POST" modelAttribute="newUser" class="w-50 h-auto m-2">
	    		<div class="border text-center py-2">
                    <h3>Register</h3>
                </div>
				<section class="border py-2">>
					<form:label path="name" class="border-end w-50 ps-2 me-1">Name</form:label>
					<form:input type="text" class="input" path="name" />
					<form:errors path="name" class="text-danger ps-2" />
				</section>
				<section class="border py-2">>
					<form:label path="email" class="border-end w-50 ps-2 me-1">Email</form:label>
					<form:input type="email" class="input" path="email" />
					<form:errors path="email" class="text-danger ps-2" />
				</section>
				<section class="border py-2">>
					<form:label path="password" class="border-end w-50 ps-2 me-1">Password</form:label>
					<form:input type="password" class="input" path="password" />
					<form:errors path="password" class="text-danger text-right" />
				</section>
				<section class="border py-2">>
					<form:label path="confirmPassword" class="border-end w-50 ps-2 me-1">Confirm Password</form:label>
					<form:input type="password" class="input" path="confirmPassword" />
					<form:errors path="confirmPassword" class="text-danger ps-2" />
				</section>
				<div class="border p-2">
                    <button class="btn btn-secondary my-1 w-100">Register and Login</button>
                </div>
			</form:form>
					
			<form:form action="/login" method="POST" modelAttribute="newLogin" class="w-50 m-2">
				<div class="border text-center py-2">
                    <h3>Login</h3>
                </div>
				<section class="border py-2">
					<form:label path="email" class="border-end w-50 ps-2 me-1">Email</form:label>
					<form:input type="email" class="input" path="email" />
					<form:errors path="email" class="text-danger" />
				</section>
				<section class="border py-2">
					<form:label path="password" class="border-end w-50 ps-2 me-1">Password</form:label>
					<form:input type="password" class="input" path="password" />
					<form:errors path="password" class="text-danger" />
				</section>
				<div class="border p-2">
                    <button class="btn btn-primary my-1 w-100">Login</button>
                </div>
			</form:form>
    	</div>
    </main>
    <footer>
    
    </footer>
</body>
</html>