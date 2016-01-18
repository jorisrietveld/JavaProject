package com.jorispalmen.javaproject.model;

import java.util.Date;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 14-1-16 17:17
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.model
 */
public class Event
{
	private long id;
	private String name;
	private String description;
	private String createdAt;
	private String eventDate;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
	}

	public String getEventDate()
	{
		return eventDate;
	}

	public void setEventDate(String eventDate)
	{
		this.eventDate = eventDate;
	}

	@Override
	public String toString()
	{
		return "Event{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", createdAt=" + createdAt +
				", eventDate=" + eventDate +
				'}';
	}
}
