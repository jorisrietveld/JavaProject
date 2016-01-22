<%@page import="com.jorispalmen.javaproject.Controller.AgendaController" %>

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
			<h1>Agenda</h1>
			<table class="table table-striped">
				<thead>
				<th>Datum event:</th>
				<th>Naam:</th>
				<th>Beschrijving</th>
				<th>prijs</th>
				<th>bestel</th>
				</thead>
				<tbody>
				<%
					AgendaController agendaController = new AgendaController();
					out.println(agendaController.getAgenda());
				%>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>