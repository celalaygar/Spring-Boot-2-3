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

				<hr>
				<div class="col-sm-12">
					<h5>${title }</h5>
					<div class="alert alert-warning alert-dismissible fade show"
						role="alert">
						<strong>Perfect !</strong> ${message }
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</div>
				<hr>
				<a href="/" class="btn btn-success">Anasayfa</a> <a href="/saveAll"
					class="btn btn-info">Çoklu Örnek Kayıt</a> <a
					href="/insertCustomerPanel" class="btn btn-warning">Customer
					Ekle</a>
				<hr>
			</div>
			<div class="col-sm-8">
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
							<th>id</th>
							<th>first name</th>
							<th>lastname</th>
							<th>İşlemler</th>
						</tr>
					</thead>
					<c:forEach items="${customers }" var="customer">
						<tr>
							<td>${customer.id }</td>
							<td>${customer.firstName }</td>
							<td>${customer.lastName }</td>
							<td><a href="/viewCustomer/${customer.id }"
								class="btn btn-mini btn-info">Göster</a> <a
								href="/updateCustomerPanel/${customer.id }"
								class="btn btn-mini btn-warning">Güncelle</a> <a
								href="/deleteCustomer/${customer.id }"
								class="btn btn-mini btn-danger">Sil</a></td>
						</tr>
					</c:forEach>
				</table>
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