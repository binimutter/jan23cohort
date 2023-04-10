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
    	<h2>${ oneStick.title }</h2>
    	<img src="${ oneStick.link }" alt="${ oneStick.title }" />
    	<h3>Added by: ${ oneStick.owner.firstName }</h3>
<%--     	<c:if test="${ oneStick.likers.user_id == user_id }">
    		<button>Unlike</button>
    	</c:if>
    	<c:if test="${ oneStick.likers.user_id != user_id }">
    		<form:form>
    		<button>Like</button>
    	</form:form>
    	</c:if> --%>
    	<div class="row">
    		<div class="column">
    			<h3>Current Categories</h3>
    			<c:forEach items="${ stickCats }" var="c">
    				${ c.name }
    			</c:forEach>
    		</div>
    		<div class="column">
    			<h3>Add Category</h3>
<%--     			<form:form action="/sticker/${ oneStick.id }/addCategory" method="post" modelAttribute=${ stickCatForm }>
    				<input type="hidden" name="" />
    			</form:form> --%>
    		</div>
    	</div>
    </main>
    <footer>
    
    </footer>
</body>
</html>