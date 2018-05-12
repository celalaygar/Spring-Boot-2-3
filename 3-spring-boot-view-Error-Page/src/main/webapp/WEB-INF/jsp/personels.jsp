
<%@include file="header.jsp" %>



	<div class="container">
		<div class="row">


			<div class="col-sm-12 ">

				<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item active" aria-current="page">${message }</li>
				</ol>
				</nav>
				<hr>
				<a href="/" class="btn btn-danger">Anasayfa</a>
				<hr>
				<div class="jumbotron">
				<h5> - - Personel Data - - </h5>
					<table>
						<tr>
							<th>id</th>
							<th>first name</th>
							<th>lastname</th>
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
			</div>
		</div>
	</div>

	
	
<%@include file="footer.jsp" %>

