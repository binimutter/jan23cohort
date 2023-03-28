<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>Hello</h1>
	</header>
	<main>
		<h1>${name}</h1>
		<h1><c:out value="${ flavor }" /></h1>
		
		<ul>
			<c:forEach var="loc" items="${ allCities }">
				<li>${ loc }</li>
			</c:forEach>
		</ul>
		
		<h1><c:out value="${ name }" /></h1>
	</main>
</body>
</html>