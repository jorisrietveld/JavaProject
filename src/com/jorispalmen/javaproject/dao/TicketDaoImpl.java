package com.jorispalmen.javaproject.dao;

import com.jorispalmen.javaproject.model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 14-1-16 17:51
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.dao
 */
public class TicketDaoImpl implements TicketDao
{
	protected Connection connection = null;

	public TicketDaoImpl( Connection connection )
	{
		this.connection = connection;
	}

	public List<Ticket> getAllTickets()
	{
		String sql = "SELECT `tickets`.`id`,`tickets`.`eventId`,`tickets`.`userId`,`tickets`.`boughtAt` FROM `JavaProject`.`tickets`";
		return this.getTickets( sql );
	}

	public List<Ticket> getAllTicketsByEventId( long eventId )
	{
		String sql = "SELECT `tickets`.`id`,`tickets`.`eventId`,`tickets`.`userId`,`tickets`.`boughtAt` FROM `JavaProject`.`tickets` WHERE `tickets`.`eventId`= " + eventId;
		return this.getTickets( sql );
	}

	public List<Ticket> getAllTicketsByUserId( long userId )
	{
		String sql = "SELECT `tickets`.`id`,`tickets`.`eventId`,`tickets`.`userId`,`tickets`.`boughtAt` FROM `JavaProject`.`tickets` WHERE `tickets`.`userId`= " + userId;
		return this.getTickets( sql );
	}

	public Ticket getTicketById( long id )
	{
		Ticket ticket = new Ticket();
		try
		{
			String sql = "SELECT `tickets`.`id`,`tickets`.`eventId`,`tickets`.`userId`,`tickets`.`boughtAt` FROM `JavaProject`.`tickets` WHERE id=" + id;
			PreparedStatement statement = connection.prepareStatement( sql );
			ResultSet resultSet = statement.executeQuery();

			if( resultSet.next() )
			{
				ticket.setUserId( resultSet.getLong( "userId" ) );
				ticket.setId( resultSet.getLong( "id" ) );
				ticket.setBoughtAt( resultSet.getString( "boughtAt" ) );
				ticket.setEventId( resultSet.getLong( "eventId" ) );
			}
			else
			{
				ticket.setId( 0 );
			}
		}
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}
		return ticket;
	}

	public void updateTicket( Ticket ticket )
	{
		try{
			String sql = "UPDATE `JavaProject`.`tickets` SET eventId=?, userId=?, boughtAt=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement( sql );

			statement.setLong( 1, ticket.getEventId() );
			statement.setLong( 2, ticket.getUserId() );
			statement.setString( 3, ticket.getBoughtAt() );
			statement.setLong( 4, ticket.getId() );

			statement.execute();
		}
		catch ( SQLException exception )
		{
			exception.printStackTrace();
		}
	}

	public void deleteTicket( Ticket ticket )
	{
		try{
			String sql = "DELETE FROM `JavaProject`.`tickets` WHERE id=" + ticket.getId();
			PreparedStatement statement = connection.prepareStatement( sql );
			statement.execute();
		}
		catch ( SQLException ex )
		{
			ex.printStackTrace();
		}
	}

	public Ticket insertTicket( Ticket ticket )
	{
		try{
			String sql = "INSERT INTO `JavaProject`.`tickets`( `id`,`eventId`,`userId`,`boughtAt` ) VALUES ( ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement( sql, PreparedStatement.RETURN_GENERATED_KEYS );

			statement.setLong( 1, ticket.getId() );
			statement.setLong( 2, ticket.getEventId() );
			statement.setLong( 3, ticket.getUserId() );
			statement.setString( 4, ticket.getBoughtAt() );

			statement.execute();

			ResultSet generatedKeys = statement.getGeneratedKeys();
			if( generatedKeys.next() )
			{
				ticket.setId( generatedKeys.getLong( 1 ) );
			}
		}
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}
		return ticket;
	}

	protected List<Ticket> getTickets( String sql )
	{
		List<Ticket> tickets = new ArrayList<>(  );

		try
		{
			PreparedStatement statement = connection.prepareStatement( sql );
			ResultSet resultSet = statement.executeQuery();

			while ( resultSet.next() )
			{
				Ticket ticket = new Ticket();

				ticket.setId( resultSet.getLong( "id" ) );
				ticket.setBoughtAt( resultSet.getString( "boughtAt" ) );
				ticket.setEventId( resultSet.getLong( "eventId" ) );
				ticket.setUserId( resultSet.getLong( "userId" ) );

				tickets.add( ticket );
			}
		}
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}
		return tickets;
	}
}
