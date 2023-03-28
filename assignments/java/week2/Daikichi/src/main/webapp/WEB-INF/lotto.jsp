<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Daikichi</title>
</head>
<body>
	<header>
		<h1>
		<c:choose>
    		<c:when test="${num % 2 == 0}">
        		You will take a grand journey in the near future, but be weary of tempting offers.
       			<br />
    		</c:when>    
    		<c:otherwise>
        		You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends. 
        		<br />
    		</c:otherwise>
		</c:choose>
		</h1>
	</header>
</body>
</html>