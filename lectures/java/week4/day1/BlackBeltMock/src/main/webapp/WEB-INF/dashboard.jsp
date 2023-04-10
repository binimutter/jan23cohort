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
		<h1>Hello ${theUser.firstName}</h1>
        <nav>
            <a href="/">Home</a>
			<c:if test="${ user_id != null }">
				<a href="/dashboard">Dashboard</a>
				<a href="/addSticker">Add Sticker</a>
                <a href="/addCategory">Add Category</a>
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
   				<h2>All the Stickers</h2>
   				<table>
   					<tr>
   						<th>ID</th>
   						<th>Title</th>
   						<th>View</th>
   					</tr>
   					<c:forEach items="${ allSticks }" var="stick">
   						<tr>
   							<td>${ stick.id }</td>
   							<td>${ stick.title }</td>
   							<td><a href="/sticker/${ stick.id }/view">View</a></td>
   						</tr>
   					</c:forEach>
   				</table>
   			</div>
   			<div class="column">
   				<h2>All the Categories</h2>
   				<table>
   					<tr>
   						<th>ID</th>
   						<th>Name</th>
   						<th>View</th>
   					</tr>
   					<c:forEach items="${ allCats }" var="cats">
   						<tr>
   							<td>${ cats.id }</td>
   							<td>${ cats.name }</td>
   							<td><a href="/category/${ cats.id }/view">View</a></td>
   						</tr>
   					</c:forEach>
   				</table>
   			</div>
   		</div>
    </main>
    <footer>
    
    </footer>
</body>
</html>