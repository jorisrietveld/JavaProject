package com.jorispalmen.javaproject.Controller;

import com.jorispalmen.javaproject.dao.DaoManager;
import com.jorispalmen.javaproject.dao.EventDaoImpl;
import com.jorispalmen.javaproject.model.Event;

import java.util.List;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 20-1-16 12:16
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.Controller
 */
public class AgendaController
{
	protected EventDaoImpl eventDao;

	public AgendaController()
	{
		this.eventDao = new DaoManager().getEventDao();
	}

	public String getAgenda()
	{
		List<Event> events = eventDao.getAllEvents();
		String html = "";

		for( Event event : events )
		{
			html += "<tr>" +
					"<td>" + event.getEventDate().substring( 0, 10 ) + "</td>" +
					"<td>" + event.getName() + "</td>" +
					"<td>" + event.getDescription() + "</td>" +
					"<td>&euro; "+ event.getPrice() + "</td>" +
					"<td><a href=\"tickets.jsp?event=" + event.getId() + "\">Bestel</a></td>" +
					"</tr>";
		}
		return html;
	}
}
