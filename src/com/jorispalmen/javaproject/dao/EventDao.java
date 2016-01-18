package com.jorispalmen.javaproject.dao;

import com.jorispalmen.javaproject.model.Event;

import java.util.List;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 14-1-16 17:25
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.dao
 */
public interface EventDao
{
	List<Event> getAllEvents();
	Event getEventById(long id);
	Event getEventByName( String name );

	void updateEvent( Event event );
	void deleteEvent( Event event );
	Event insertEvent( Event event );

}
