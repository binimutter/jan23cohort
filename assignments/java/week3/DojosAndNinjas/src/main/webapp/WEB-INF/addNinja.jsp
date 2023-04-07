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
		<h1>New Ninja</h1>
		<nav>
			<a href="/">Home</a>
			<a href="/dojos/new">Add Dojo</a>
			<a href="/ninjas/new">Add Ninja</a>
		</nav>
	</header>
    <main>
    	<form:form action="/ninjas/add" method="post" modelAttribute="ninjaForm">
			<section>
				<label for="firstName">First Name</label>
				<input type="text" name="firstName" />
				<form:errors path="firstName" class="text-warning"/>
			</section>
			<section>
				<label for="lastName">Last Name</label>
				<input type="text" name="lastName" />
				<form:errors path="lastName" class="text-warning"/>
			</section>
			<section>
				<label for="age">Age</label>
				<input type="number" name="age" />
				<form:errors path="age" class="text-warning"/>
			</section>
			<section>
				<label for="dojo">Dojo</label>
				<select name="dojo">
					<c:forEach var="d" items="${ allDojos }">
						<option value="${ d.id }">${ d.name }</option>
					</c:forEach>
				</select>
			</section>
			<button>Submit</button>
		</form:form>
    </main>
    <footer>
    
    </footer>
</body>
</html>