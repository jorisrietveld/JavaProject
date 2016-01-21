package com.jorispalmen.javaproject.tests;

import com.jorispalmen.javaproject.dao.DaoManager;
import com.jorispalmen.javaproject.model.Event;

import java.sql.Date;
import java.util.List;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 15-1-16 13:35
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.controller
 */
public class GetEvents
{
	public static DaoManager daoManager = new DaoManager();

	public static void main( String args[] )
	{
		daoManager.openConnection();
		switch( 6 )
		{
			case 1:
				testGetAllEvents();
				break;
			case 2:
				testGetEventById();
				break;
			case 3:
				testGetEventByName();
				break;
			case 4:
				testUpdateEvent();
				break;
			case 5:
				testInsertEvent();
				break;
			case 6:
				testDeleteEvent();
				break;
		}
		daoManager.closeConnection();
	}

	public static void testGetAllEvents()
	{
		System.err.println("testGetAllEvents");
		List<Event> events = daoManager.getEventDao().getAllEvents();

		for( Event event : events )
		{
			System.out.println( event.toString() );
		}
	}

	public static void testGetEventById()
	{
		System.err.println( "testGetEventById" );
		System.out.println( daoManager.getEventDao().getEventById( 1 ).toString() );
	}

	public static void testGetEventByName()
	{
		System.err.println( "testGetEventByName" );
		System.out.println( daoManager.getEventDao().getEventByName( "joris" ).toString() );
	}

	public static void testUpdateEvent()
	{
		System.err.println( "testUpdateEvent" );
		Event event = daoManager.getEventDao().getEventById( 2 );
		event.setDescription( "update event description" );
		event.setName( "joris" );
		daoManager.getEventDao().updateEvent( event );
		System.out.println( daoManager.getEventDao().getEventById( 2 ).toString() );
	}

	public static void testInsertEvent()
	{
		System.err.println( "testInsertEvent" );

		Event event = new Event();
		event.setName( "Slipknot" );
		event.setDescription( "Leuk consert enzo..." );
		event.setCreatedAt( new Date( System.currentTimeMillis()).toString() );
		event.setEventDate( new Date( System.currentTimeMillis()).toString() );

		event = daoManager.getEventDao().insertEvent( event );
		System.out.println( event.toString() );
	}

	public static void testDeleteEvent()
	{
		System.err.println( "testDeleteEvent" );
		Event event = daoManager.getEventDao().getEventById( 1 );
		daoManager.getEventDao().deleteEvent( event );
	}
}
