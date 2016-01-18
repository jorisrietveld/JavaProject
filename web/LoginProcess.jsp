<%@page import="com.jorispalmen.javaproject.controller.Login"%>
<jsp:useBean id="LoginObj" class="com.jorispalmen.javaproject.bean.LoginBean"/>
<jsp:setProperty property="*" name="obj"/>
<%
	String password =  LoginObj.getPassword();
	String username = LoginObj.getUsername();

    Boolean status = new Login().validateLogin( LoginObj );

	if( status )
	{
		out.println( "Your successfully logged in!" );
	//	session.setAttribute( "session", "true" );
	}
	else
	{
		out.println( "There is no account matching your login credentials" );
	}
%>