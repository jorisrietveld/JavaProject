package com.jorispalmen.javaproject.model;

import java.util.Date;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 14-1-16 17:07
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.model
 */
public class Ticket
{
	private long id;
	private long eventId;
	private long userId;
	private Date boughtAt;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public long getEventId()
	{
		return eventId;
	}

	public void setEventId(long eventId)
	{
		this.eventId = eventId;
	}

	public long getUserId()
	{
		return userId;
	}

	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	public Date getBoughtAt()
	{
		return boughtAt;
	}

	public void setBoughtAt(Date boughtAt)
	{
		this.boughtAt = boughtAt;
	}
}
