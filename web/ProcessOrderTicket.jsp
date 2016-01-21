<%@page import="com.jorispalmen.javaproject.Controller.TicketController" %>
<jsp:useBean id="ticketBean" class="com.jorispalmen.javaproject.bean.TicketBean"/>
<jsp:setProperty name="ticketBean" property="*"/>
<%
	try
	{
		TicketController ticketController = new TicketController();
		ticketController.orderTicket( ticketBean );
	}catch ( Exception e )
	{
		e.printStackTrace();
	}

%>