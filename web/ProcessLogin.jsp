<%@page import="com.jorispalmen.javaproject.Controller.LoginController" %>
<%@ page import="com.jorispalmen.javaproject.model.User" %>
<jsp:useBean id="loginObj" class="com.jorispalmen.javaproject.bean.LoginBean"/>
<jsp:setProperty name="loginObj" property="*"/>
<%
	LoginController controller = new LoginController();
	Boolean result = controller.validateLogin( loginObj );
	if(result)
	{
		User user = controller.getLogedInUser();

		session.setAttribute("session","TRUE");
		session.setAttribute( "userId", user.getId() );
		session.setAttribute( "firstName", user.getFirstName() );
		session.setAttribute( "lastName", user.getLastName() );
		session.setAttribute( "username", user.getUsername() );
	}
	out.println(result);
%>