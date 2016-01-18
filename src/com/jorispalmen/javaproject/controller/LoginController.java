package com.jorispalmen.javaproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 15-1-16 17:35
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.controller
 */
public class LoginController extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Set the response content type
		response.setContentType( "text/html" );

		PrintWriter printWriter = response.getWriter();

		String title = "Using GET method to read form data";
		String doctype = "<!DOCTYPE html>";

		printWriter.println(doctype);
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{

	}

}
