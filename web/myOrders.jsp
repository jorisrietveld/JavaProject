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
		<h3>Bestelde tickets</h3>
		<table class="table table-striped">
			<thead>
			<th>Naam:</th>
			<th>Beschrijving:</th>
			<th>Datum evenement:</th>
			<th>Ticket gekocht op:</th>
			</thead>
			<tbody>
				<%
					OrderdTicketsController orderdTicketController1 = new OrderdTicketsController();
					Long userId1 = Long.parseLong( request.getSession().getAttribute("userId").toString() );
					out.println(orderdTicketController1.getTicketTable( userId1 ));
				%>
			</tbody>
		</table>
	</div>
</div>

</body>
</html>