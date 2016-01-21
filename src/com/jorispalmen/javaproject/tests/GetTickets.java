package com.jorispalmen.javaproject.tests;

import com.jorispalmen.javaproject.dao.DaoManager;
import com.jorispalmen.javaproject.model.Event;
import com.jorispalmen.javaproject.model.Ticket;

import java.sql.Date;
import java.util.List;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 20-1-16 15:14
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.tests
 */
public class GetTickets
{
	protected static DaoManager daoManager;

	public static void main( String args[] )
	{
		daoManager = new DaoManager();
		switch ( 4 )
		{
			case 1:
				testGetAllTickets();
				break;
			case 2:
				testGetTicketByEvent();
				break;
			case 3:
				testGetTicketByUserId();
				break;
			case 4:
				testGetTicketById();
				break;
			case 5:
				testInsertTicket();
				break;
			case 6:
				testUpdateTicket();
				break;
			case 7:
				testDeleteTicket();
				break;
		}
	}

	public static void testGetAllTickets()
	{
		System.err.println("testGetAllTickets");
		List<Ticket> tickets = daoManager.getTicketDao().getAllTickets();

		for( Ticket ticket : tickets )
		{
			System.out.println( ticket.toString() );
		}
	}

	public static void testGetTicketByEvent()
	{
		System.err.println( "testGetTicketByEvent = 1" );
		List<Ticket> tickets = daoManager.getTicketDao().getAllTicketsByEventId( 1 );

		for( Ticket ticket : tickets )
		{
			System.out.println( ticket.toString() );
		}
	}

	public static void testGetTicketByUserId()
	{
		System.err.println( "testGetTicketByUserId = 1" );

		List<Ticket> tickets = daoManager.getTicketDao().getAllTicketsByUserId( 1 );

		for ( Ticket ticket : tickets )
		{
			System.out.println( ticket.toString() );
		}
	}

	public static void testGetTicketById()
	{
		System.err.println("testGetTicketById =1 ");

		Ticket ticket = daoManager.getTicketDao().getTicketById( 1 );
		System.out.println( ticket.toString() );
	}

	public static void testInsertTicket()
	{
		Ticket ticket = daoManager.getTicketDao().getTicketById( 2 );
		ticket.setBoughtAt( new Date( System.currentTimeMillis() ).toString() );
	}

	public static void testUpdateTicket()
	{
		Ticket ticket = daoManager.getTicketDao().getTicketById( 1 );
		ticket.setUserId( 2 );
		daoManager.getTicketDao().updateTicket( ticket );
	}

	public static void testDeleteTicket()
	{
		Ticket ticket = daoManager.getTicketDao().getTicketById( 1 );
		daoManager.getTicketDao().deleteTicket( ticket );
	}
}
