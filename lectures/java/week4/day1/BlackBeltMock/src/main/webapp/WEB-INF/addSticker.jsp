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
		<h1>Hello ${ theUser.firstName }</h1>
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
        <form:form action="/createSticker" method="post" modelAttribute="${ stickFrom }">
            <section>
                <label for="title">Title</label>
                <input type="text" name="title" id="">
                <form:errors path="title" class="text-danger"/>
            </section>
            <section>
                <label for="link">Link to URL</label>
                <input type="text" name="link" id="">
                <form:errors path="link" class="text-danger"/>
            </section>
            <section>
                <input type="hidden" name="owner" value="${ user_id }">
            </section>
            <button>Add Sticker</button>
        </form:form>
    </main>
    <footer>
    
    </footer>
</body>
</html>