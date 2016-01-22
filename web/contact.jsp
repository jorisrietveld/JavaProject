<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="includes/head.jsp"%>
	<title></title>
</head>
<body>
	<% if( session.getAttribute("session") == null ){ %>
	<%@include file="includes/header.jsp"%>
	<% }else{ %>
	<%@include file="includes/header-logged-in.jsp"%>
	<% } %>

	<div class="container">
		<div class="jumbotron">
			<h3>contact</h3>
			<p></p>
		</div>
	</div>

</body>
</html>