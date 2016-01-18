package com.jorispalmen.javaproject.tests;

import com.jorispalmen.javaproject.dao.DaoManager;
import com.jorispalmen.javaproject.dao.UserDaoImpl;
import com.jorispalmen.javaproject.model.User;

import java.sql.Date;
import java.util.List;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 14-1-16 20:26
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.controller
 */
public class GetUsers
{
	private static DaoManager daoManager;

	public static void main(String args[])
	{
		daoManager = new DaoManager();
		daoManager.openConnection();

		switch ( 6 )
		{
			case 1:
				testGetUserByEmail();
				break;
			case 2:
				testGetUserById();
				break;
			case 3:
				testgetUsers();
				break;
			case 4:
				testInsertUser();
				break;
			case 5:
				testUpdateUser();
				break;
			case 6:
				testDeleteUser();
				break;
		}

		daoManager.closeConnection();
	}

	public static void testGetUserByEmail()
	{
		System.err.println( "testGetUserByEmail" );
		User user = daoManager.getUserDao().getUserByEmail( "bob" );
		System.out.println( user.toString() );
	}

	public static void testGetUserById()
	{
		System.err.println( "testGetUserById" );
		User user = daoManager.getUserDao().getUserById( 1 );
		System.out.println( user.toString() );
	}

	public static void testgetUsers()
	{
		System.err.println( "testgetUsers" );
		List<User> users = daoManager.getUserDao().getUsers();

		for( User user : users )
		{
			System.out.println( user.toString() );
		}
	}

	public static void testInsertUser()
	{
		System.err.println( "testInsertUser" );
		User user = new User( "bob", "bob", "bob", "bob", "bob", new Date( System.currentTimeMillis() ).toString() );
		daoManager.getUserDao().insertUser( user );
	}

	public static void testUpdateUser()
	{
		System.err.println( "testUpdateUser" );
		User user = daoManager.getUserDao().getUserById( 2 );
		user.setEmail( "alice@nsa.gov" );
		daoManager.getUserDao().updateUser( user );

		System.out.println( daoManager.getUserDao().getUserById( 2 ).toString() );
	}

	public static void testDeleteUser()
	{
		System.err.println( "testDeleteUser" );
		User user = daoManager.getUserDao().getUserById( 3 );
		daoManager.getUserDao().deleteUser( user );

	}
}
