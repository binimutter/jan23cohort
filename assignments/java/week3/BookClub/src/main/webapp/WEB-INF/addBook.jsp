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
		<h1>Add a Book to Your Shelf!</h1>
		<nav>
			<a href="/dashboard">back to the shelves</a>
		</nav>
	</header>
    <main class="m-2 w-75">
    	<form:form action="/saveBook" method="post" modelAttribute="saveBookForm" class="d-flex flex-column">  
            <input type="text" name="user" value="${userID}" hidden> 

            <!-- Validation Error -->
            <form:errors path="title" class="text-warning"/>
                <!-- Attribute Information -->
                <div class="d-flex flex-row justify-content-between my-2">
                    <label for="title">Title:</label>
                    <input type="text" name="title" class="w-75">
                </div>

            <!-- Validation Error -->
            <form:errors path="author" class="text-warning"/>
                <!-- Attribute Information -->
                <div class="d-flex flex-row justify-content-between my-2">
                    <label for="author">Author:</label>
                    <input type="text" name="author" class="w-75">
                </div>

            <!-- Validation Error -->
            <form:errors path="thoughts" class="text-warning"/>
                <!-- Attribute Information -->
                <div class="d-flex flex-row justify-content-between my-2">
                    <label for="thoughts">My Thoughts:</label>
                    <textarea name="thoughts" class="w-75" ></textarea>
                </div>

            <div class="d-flex justify-content-end">
                <button class="btn btn-secondary w-25">Submit</button>
            </div>
        </form:form>
    </main>
    <footer>
    
    </footer>
</body>
</html>