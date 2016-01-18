package com.jorispalmen.javaproject.bean;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 15-1-16 14:39
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.bean
 */
public class LoginBean
{
	private String username;
	private String password;

	public void setUsername( String username )
	{
		this.username = username;
	}

	public String getUsername()
	{
		return this.username;
	}

	public void setPassword( String password )
	{
		this.password = password;
	}

	public String getPassword()
	{
		return this.password;
	}
}
