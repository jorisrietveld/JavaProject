package com.jorispalmen.javaproject.model;

import javax.jws.soap.SOAPBinding;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.util.Date;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 14-1-16 17:08
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.model
 */
public class User
{
	private long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String createdAt;

	public User(String username, String password, String firstName, String lastName, String email, String createdAt )
	{
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.createdAt = createdAt;
	}

	public User()
	{

	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getCreatedAt()
	{
		return this.createdAt;
	}

	public void setCreatedAt( String date )
	{
		this.createdAt = date;
	}

	@Override
	public String toString()
	{
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", createdAt=" + createdAt +
				'}';
	}
}
