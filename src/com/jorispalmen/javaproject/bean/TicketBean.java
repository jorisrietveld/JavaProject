package com.jorispalmen.javaproject.bean;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 21-1-16 13:09
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.bean
 */
public class TicketBean
{
	private long userId;
	private long eventId;
	private int amountOfTickets;

	public long getUserId()
	{
		return userId;
	}

	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	public long getEventId()
	{
		return eventId;
	}

	public void setEventId(long eventId)
	{
		this.eventId = eventId;
	}

	public int getAmountOfTickets()
	{
		return amountOfTickets;
	}

	public void setAmountOfTickets(int amountOfTickets)
	{
		this.amountOfTickets = amountOfTickets;
	}

	@Override
	public String toString()
	{
		return "TicketBean{" +
				"userId=" + userId +
				", eventId=" + eventId +
				", amountOfTickets=" + amountOfTickets +
				'}';
	}
}
