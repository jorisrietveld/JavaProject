package com.jorispalmen.javaproject.Controller;

import com.jorispalmen.javaproject.bean.TicketBean;
import com.jorispalmen.javaproject.dao.DaoManager;
import com.jorispalmen.javaproject.dao.EventDaoImpl;
import com.jorispalmen.javaproject.dao.TicketDao;
import com.jorispalmen.javaproject.dao.TicketDaoImpl;
import com.jorispalmen.javaproject.model.Event;
import com.jorispalmen.javaproject.model.Ticket;

import java.sql.Date;
import java.util.List;
import java.util.jar.Pack200;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 20-1-16 14:08
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.Controller
 */
public class TicketController
{
	protected TicketDaoImpl ticketDao;
	protected EventDaoImpl eventDao;
	protected int maxTicktets = 100;
	protected String debugMessages = "";
	
	public TicketController()
	{
		DaoManager daoManager = new DaoManager();
		this.ticketDao = daoManager.getTicketDao();
		this.eventDao = daoManager.getEventDao();
	}

	public String getTicketInfo( long eventId )
	{
		Event event = eventDao.getEventById( eventId );

		return "<table class=\"table\">" +
				"<thead><form id=\"order-tickets-form\">" +
				"<tr>" +
				"<th colspan=\"2\">U heeft gekozen voor: " + event.getName() + "</th>" +
				"<th style=\"text-align: right\"> Aantal kaarten: <input value=\"1\" id=\"input-ticket-amount\" min=\"0\" max=\""+ ticketsAvailable( eventId )+"\" type=\"number\"/><input type=\"hidden\" id=\"input-eventId\" value=\""+ eventId + "\"/> <button class=\"btn btn-info\" type=\"submit\">Bestel</button> </th>" +
				"</tr></form></thead><tbody><tr>" +
				"<td>datum: " +	event.getEventDate().substring( 0, 10 ) + "</td>" +
				"<td>" + event.getDescription() + "</td>" +
				"<th style=\"text-align:right;\"> prijs: <span id=\"total-price\"> &euro; " + event.getPrice() + "</span>" +
				"<input type=\"hidden\" id=\"ticketPrice\" value=\"" + event.getPrice() + "\"/>" +
				"</th></tr></tbody></table>";
	}

	public int ticketsAvailable( long eventId )
	{
		List<Ticket> tickets = ticketDao.getAllTicketsByEventId( eventId );

		return maxTicktets - tickets.size();
	}

	public void orderTicket(TicketBean ticketBean)
	{
		String boughtAt = new Date( System.currentTimeMillis()).toString();
		int ticketsBought = 0;

		while( ticketBean.getAmountOfTickets() == ticketsBought )
		{
			buyTicket( ticketBean.getUserId(), ticketBean.getEventId(), boughtAt );
			ticketsBought++;
		}
	}

	public void buyTicket( long userId, long eventId, String boughtAt )
	{
		Ticket ticket = new Ticket();
		ticket.setUserId( userId );
		ticket.setEventId( eventId );
		ticket.setBoughtAt( boughtAt );
		ticketDao.insertTicket( ticket );
		setDebugMessages( "[debug][java] buyTicket() call" );
	}

	public String getDebugMessages()
	{
		return this.debugMessages;
	}

	protected void setDebugMessages( String messages )
	{
		this.debugMessages += messages;
	}

}
