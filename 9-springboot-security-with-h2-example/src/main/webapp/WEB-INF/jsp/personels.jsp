
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.javaegitimleri.app.model.Personel"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">

</head>
<body>



	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<h3>Personel Page</h3>
				<hr>
				<a href="/" class="btn btn-info">Main Page </a> <a href="/welcome"
					class="btn btn-success">welcome Page </a>
				<hr>
				<table>

					<tr>
						<th>id</th>
						<th>first name</th>
						<th>last name</th>
					</tr>
					<c:forEach items="${personels }" var="personel">
						<tr>
							<td>${personel.id }</td>
							<td>${personel.firstname }</td>
							<td>${personel.lastname }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-sm-6">
				<hr>
				<form action="logout" method="post">
					<input type="hidden" name="${_csrf.parameterName }"
						value="${_csrf.token }" /> <input type="submit"
						class="btn btn-danger" value="Log Out" />

				</form>
				<hr>
			</div>
		</div>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>

</body>
</html>