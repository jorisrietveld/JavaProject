package com.jorispalmen.javaproject.dao;

import com.jorispalmen.javaproject.model.Ticket;

import java.util.List;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 14-1-16 17:35
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.dao
 */
public interface TicketDao
{
	public List<Ticket> getAllTickets();
	public List<Ticket> getAllTicketsByEventId( long eventId );
	public List<Ticket> getAllTicketsByUserId( long userId );

	public Ticket getTicketById( long id );

	public void updateTicket( Ticket ticket );
	public void deleteTicket( Ticket ticket );
	public Ticket insertTicket( Ticket ticket );
}
