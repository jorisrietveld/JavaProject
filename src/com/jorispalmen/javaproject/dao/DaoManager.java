package com.jorispalmen.javaproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 14-1-16 17:44
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.dao
 */
public class DaoManager
{
	protected Connection connection = null;

	protected UserDaoImpl userDao = null;
	protected TicketDaoImpl ticketDao = null;
	protected EventDaoImpl eventDao = null;

	static {
		try{
			Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch ( ClassNotFoundException ex ){
			ex.printStackTrace();
		}
	}

	public void openConnection()
	{
		try{
			if( this.connection == null )
			{
				this.connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/JavaProject", "root", "toor" );
			}
		}
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}

	}

	public void closeConnection( )
	{
		try{
			if( this.connection != null )
			{
				this.connection.close();
			}
		}
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}

	}

	public UserDaoImpl getUserDao()
	{
		if( this.userDao == null )
		{
			this.userDao = new UserDaoImpl( this.connection );
		}

		return this.userDao;
	}

	public TicketDaoImpl getTicketDao()
	{
		if( this.ticketDao == null )
		{
			this.ticketDao = new TicketDaoImpl( this.connection );
		}
		return this.ticketDao;
	}

	public EventDaoImpl getEventDao()
	{
		if ( this.eventDao == null )
		{
			this.eventDao = new EventDaoImpl( this.connection );
		}
		return this.eventDao;
	}


}
