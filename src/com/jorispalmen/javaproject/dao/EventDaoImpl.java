package com.jorispalmen.javaproject.dao;

import com.jorispalmen.javaproject.model.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 14-1-16 17:51
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.dao
 */
public class EventDaoImpl implements EventDao
{
	protected Connection connection = null;

	EventDaoImpl( Connection connection )
	{
		this.connection = connection;
	}

	public List<Event> getAllEvents()
	{
		String sql = "SELECT `id`,`name`,`description`,`createdAt`,`eventDate` FROM `JavaProject`.`events`";
		return getEvents( sql );
	}

	public Event getEventById(long id)
	{
		String sql = "SELECT `id`,`name`,`description`,`createdAt`,`eventDate` FROM `JavaProject`.`events` WHERE id="+id;
		return getEvent( sql );
	}

	public Event getEventByName( String name )
	{
		String sql = "SELECT `id`,`name`,`description`,`createdAt`,`eventDate` FROM `JavaProject`.`events` WHERE name='"+name+"'";
		return getEvent( sql );
	}

	public void updateEvent( Event event )
	{
		String sql = "UPDATE `JavaProject`.`events` SET name=?, description=?, createdAt=?, eventDate=? WHERE id=?";
		try{
			PreparedStatement statement = connection.prepareStatement( sql );
			statement.setString( 1, event.getName() );
			statement.setString( 2, event.getDescription() );
			statement.setString( 3, event.getCreatedAt() );
			statement.setString( 4, event.getEventDate() );
			statement.setLong( 5, event.getId() );

			statement.execute();

		}
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}
	}

	public void deleteEvent( Event event )
	{
		String sql = "DELETE FROM `JavaProject`.`events` WHERE id=?";
		try{
			PreparedStatement statement = connection.prepareStatement( sql );
			statement.setLong( 1, event.getId() );
			statement.execute();
		}
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}
	}

	public Event insertEvent( Event event )
	{
		String sql = "INSERT INTO `JavaProject`.`events`( `name`,`description`,`createdAt`,`eventDate` ) VALUES( ?, ?, ?, ? )";

		try{
			PreparedStatement statement = connection.prepareStatement( sql, PreparedStatement.RETURN_GENERATED_KEYS );
			statement.setString( 1, event.getName() );
			statement.setString( 2, event.getDescription() );
			statement.setString( 3, event.getCreatedAt() );
			statement.setString( 4, event.getEventDate() );
			statement.execute();

			ResultSet generatedKeys = statement.getGeneratedKeys();
			if( generatedKeys.next() )
			{
				event.setId( generatedKeys.getLong( 1 ) );
			}
		}
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}
		return event;
	}

	protected List<Event> getEvents( String sql )
	{
		List<Event> events = new ArrayList<>(  );

		try{
			PreparedStatement statement = connection.prepareStatement( sql );
			ResultSet resultSet = statement.executeQuery();

			while ( resultSet.next() )
			{
				Event event = new Event();
				event.setId( resultSet.getLong( "id" ) );
				event.setName( resultSet.getString( "name" ) );
				event.setDescription( resultSet.getString( "description" ) );
				event.setEventDate( resultSet.getString( "eventDate" ) );
				event.setCreatedAt( resultSet.getString( "createdAt" ) );
				events.add( event );
			}
		}
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}
		return events;
	}

	protected Event getEvent( String sql )
	{
		Event event = new Event();

		try{
			PreparedStatement statement = connection.prepareStatement( sql );
			ResultSet resultSet = statement.executeQuery();

			if( resultSet.next() )
			{
				event.setId( resultSet.getLong( "id" ) );
				event.setName( resultSet.getString( "name" ) );
				event.setDescription( resultSet.getString( "description" ) );
				event.setEventDate( resultSet.getString( "eventDate" ) );
				event.setCreatedAt( resultSet.getString( "createdAt" ) );
			}
		}
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}
		return event;
	}
}
