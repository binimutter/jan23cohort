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
	<div class="top-container">
		<h1>Safe Travels</h1>
		<table class="table">
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${allExpenses}" var="e">
		        <tr>
		            <td><a href="/expense/${ e.id }">${e.name}</a></td>
		            <td>${e.vendor}</td>
		            <td>$${e.amount}</td>
		            <td><p><a href="/expense/${e.id}/edit">edit</a> | <a href="/expense/${e.id}/delete">delete</a></p></td>
		        </tr>
		    </c:forEach>
		</table>
	</div>
	<div class="bottom-container">
		<h1>Add an expense:</h1>
		<form:form action="/expense/create" method="post" modelAttribute="expense" class="">
		
			<section>
				<label for="name">Expense Name: </label>
				<input type="text" name="name" id="" />
				<form:errors path="name" class="text-warning"/>
			</section>
			<section>
				<form:label path="vendor">Vendor: </form:label>
				<form:input path="vendor" type="text" />
				<form:errors path="vendor" class="text-warning" />
			</section>
			<section>
				<form:label path="amount">Amount: </form:label>
				<form:input path="amount" type="number" />
				<form:errors path="amount" class="text-warning" />
			</section>
			<section>
				<label for="description">Description: </label>
				<textarea name="description" id="" cols="30" rows="10"></textarea>
				<form:errors path="description" class="text-warning" />
			</section>
			<button class="btn btn-primary mt-2">Submit</button>
		</form:form>
	</div>
</body>
</html>