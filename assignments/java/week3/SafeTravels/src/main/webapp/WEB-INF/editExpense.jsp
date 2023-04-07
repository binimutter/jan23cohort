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
<title>Safe Travels</title>
</head>
<body>
	<div>
		<div class="header-container">
			<h1>Edit Expense</h1>
			<a href="/">Go back</a>
		</div>
		<form:form action="/expense/${expense.id}/update" method="post" modelAttribute="expenseEditForm">
			<!-- Input below is needed to the update form only -->
			<input type="hidden" name="_method" value="put">
			<section>
				<label for="name">Expense Name: </label>
				<input type="text" name="name" id="" value="${ expense.name }" />
				<form:errors path="name" class="text-warning"/>
			</section>
			<section>
				<form:label path="vendor">Vendor: </form:label>
				<form:input path="vendor" type="text" value="${ expense.vendor }" />
				<form:errors path="vendor" class="text-warning" />
			</section>
			<section>
				<form:label path="amount">Amount: </form:label>
				<form:input path="amount" type="number" value="${ expense.amount }" />
				<form:errors path="amount" class="text-warning" />
			</section>
			<section>
				<form:label path="description">Description: </form:label>
				<form:input path="description" type="text" value="${ expense.description }" />
				<form:errors path="description" class="text-warning" />
			</section>
			<button class="btn btn-primary mt-2">Submit</button>
		</form:form>
	</div>
</body>
</html>