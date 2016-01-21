<%@ page import="com.jorispalmen.javaproject.Controller.TicketController" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="includes/head.jsp"%>
	<title></title>
</head>
<body>

<div class="modal fade order-modal" id="order-modal" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">Geslaagt</h4>
			</div>
			<div class="modal-body" id="">
				De tickets zijn besteld!
			</div>
		</div>
	</div>
</div>

	<% if( session.getAttribute("session") == null ){ %>
	<%@include file="includes/header.jsp"%>
	<% }else{ %>
	<%@include file="includes/header-logged-in.jsp"%>
	<% } %>
	<div class="container">
		<div class="jumbotron">

		<% if ( request.getParameter("event") == null) { %>
		<%-- if there is no event choosen --%>
			<a href="agenda.jsp"><h3>Kies eerst een event</h3></a>

		<% }else{ %>
		<%-- if there is an event choosen --%>

			<% if( session.getAttribute( "session" ) == null ){ %>
				<h3>Login of registreer om ticktets te bestellen</h3>
				<button type="button" class="btn btn-info" data-toggle="modal" data-target=".register-modal">Register</button>
			<% }else{ %>
				<div>
					<%
						try
						{
							TicketController ticketController = new TicketController();
							String ticketInfo = ticketController.getTicketInfo( Long.parseLong( request.getParameter( "event" ) ) );
							out.println(ticketInfo);
							out.println("<input type=\"hidden\" id=\"userId\" value=\"" + session.getAttribute( "userId" ) + "\"/>");
						}
						catch ( Exception ex )
						{
							//ex.printStackTrace();
						}
					%>

				</div>
			<% } %>

		<% } %>
		</div>
	</div>s
</body>
</html>