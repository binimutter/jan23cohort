<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> -->
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Ninja Gold</title>
</head>
<body>
	<header>
		<h1>Hello</h1>
	</header>
	<main>
		<div id="goldCount">
			<h2>Your Gold: <span id='count'><c:out value="${ count }" /></span></h2>
			
			<button><a href="/reset">Reset</a></button>
		</div>
	<div class="row">
		<div class='place' id="farm">
			<h2>Farm</h2>
			<p>(Earns 10-20 gold)</p>
			<form action="/gold/farm" method='post'>
				<button>Find Gold!</button>
			</form>
		</div>
		<div class='place' id="cave">
			<h2>Cave</h2>
			<p>(Earns 5-10 gold)</p>
			<form action="/gold/cave" method='post'>
				<button>Find Gold!</button>
			</form>
		</div>
		<div class='place' id="house">
			<h2>House</h2>
			<p>(Earns 2-5 gold)</p>
			<form action="/gold/house" method='post'>
				<button>Find Gold!</button>
			</form>
		</div>
		<div class='place' id="quest">
			<h2>Quest</h2>
			<p>(Earns/Takes 0-50 gold)</p>
			<form action="/gold/quest" method='post'>
				<button>Find Gold!</button>
			</form>
		</div>
	</div>
		<div id="activities">
			<h2>Activities</h2>
			<div class="activitiesLoop">
				<c:if test="${count == 0}">
					<p>No Gold Activity</p>
				</c:if>
				<c:if test = "${count != 0}">
					<c:forEach var = "i" items="${activity}">
						<c:if test="${i.contains('earned')}">
							<p style="color: green;"><c:out value = "${i}"/></p>
						</c:if>
						<c:if test="${i.contains('lost')}">
							<p style="color: red;"><c:out value = "${i}"/></p>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</main>
</body>
</html>