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
<title>View Expense</title>
</head>
<body>
	<header>
		<h1>Expense Details</h1>
	</header>
    <main>
    	<h4>Expense Name: ${ oneExpense.name }</h4>
    	<h4>Expense Description: ${ oneExpense.description }</h4>
    	<h4>Vendor: ${ oneExpense.vendor }</h4>
    	<h4>Amount Spent: $${ oneExpense.amount }</h4>
    </main>
    <footer>
    
    </footer>
</body>
</html>