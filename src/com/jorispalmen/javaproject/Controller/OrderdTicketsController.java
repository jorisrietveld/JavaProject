package com.jorispalmen.javaproject.Controller;

import com.jorispalmen.javaproject.dao.DaoManager;
import com.jorispalmen.javaproject.dao.EventDaoImpl;
import com.jorispalmen.javaproject.dao.TicketDaoImpl;
import com.jorispalmen.javaproject.model.Event;
import com.jorispalmen.javaproject.model.Ticket;

import java.util.List;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 22-1-16 13:23
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.Controller
 */
public class OrderdTicketsController
{
	protected TicketDaoImpl ticketDao;

	public OrderdTicketsController()
	{
		this.ticketDao = new DaoManager().getTicketDao();
	}

	public Boolean HasTickets(long userId )
	{
		return (getTickets( userId ).size() > 0 );
	}

	public List<Ticket> getTickets( long userId )
	{
		return ticketDao.getAllTicketsByUserId( userId );
	}

	public String getTicketTable( long userId )
	{
		String html = "";
		List<Ticket> tickets = getTickets( userId );

		for( Ticket ticket : tickets )
		{
			Event event = getEvent( ticket.getEventId() );
			html += "<tr>";
			html += "<td>" + event.getName() + "</td>";
			html += "<td>" + event.getDescription() + "</td>";
			html += "<td>" + event.getEventDate() + "</td>";
			html += "<td>" + ticket.getBoughtAt().substring( 0,10 ) + "</td>";
			html += "</tr>";
		}
		return html;
	}

	public Event getEvent( long eventId )
	{
		EventDaoImpl eventDao = new DaoManager().getEventDao();
		return eventDao.getEventById( eventId );
	}
}
