<%@page import="com.jorispalmen.javaproject.Controller.RegisterController" %>
<jsp:useBean id="registerObj" class="com.jorispalmen.javaproject.bean.RegisterBean"/>
<jsp:setProperty name="registerObj" property="*"/>
<%
	RegisterController controller = new RegisterController();
	if(controller.RegisterUser( registerObj ))
	{
		out.println("<span class=\"feedback-success\">U bent geregistreerd</span>");
	}
	else
	{
		String errorMessage = controller.getFeedback();
		out.println("<span class=\"feedback-error\">" + errorMessage + "</span>");
	}
%>