package com.jorispalmen.javaproject.dao;

import java.sql.Connection;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 14-1-16 17:51
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.dao
 */
public class TicketDaoImpl implements TicketDao
{
	protected Connection connection = null;

	public TicketDaoImpl( Connection connection )
	{
		this.connection = connection;
	}
}
