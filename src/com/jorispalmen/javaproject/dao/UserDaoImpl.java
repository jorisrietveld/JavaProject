package com.jorispalmen.javaproject.dao;

import com.jorispalmen.javaproject.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 14-1-16 17:50
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.dao
 */
public class UserDaoImpl implements UserDao
{
	protected Connection connection = null;

	public UserDaoImpl( Connection connection )
	{
		this.connection = connection;
	}

	public List<User> getUsers()
	{
		String sql = "SELECT * FROM `JavaProject`.`users`";

		return this.getUsers( sql );
	}

	public User getUserById(long id)
	{
		String sql = "SELECT `id`,`username`,`password`,`firstName`,`lastName`,`email`,`createdAt` FROM `JavaProject`.`users` WHERE id = " + id;
		return this.getUser( sql );
	}

	public User getUserByEmail(String email)
	{
		String sql = "SELECT `id`,`username`,`password`,`firstName`,`lastName`,`email`,`createdAt` FROM `JavaProject`.`users` WHERE email = '" + email + "'";
		return this.getUser( sql );
	}

	public User getUserByUsername(String username)
	{
		String sql = "SELECT `id`,`username`,`password`,`firstName`,`lastName`,`email`,`createdAt` FROM `JavaProject`.`users` WHERE username = '" + username + "'";
		return this.getUser( sql );
	}

	public void insertUser(User user)
	{
		String sql = "INSERT INTO `JavaProject`.`users`( `username`,`password`,`firstName`,`lastName`,`email`,`createdAt`) VALUES( ?, ?, ?, ?, ?, ?) ";
		try{
			PreparedStatement statement = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );

			statement.setString( 1, user.getUsername() );
			statement.setString( 2, user.getPassword() );
			statement.setString( 3, user.getFirstName() );
			statement.setString( 4, user.getLastName() );
			statement.setString( 5, user.getEmail() );
			statement.setString( 6, user.getCreatedAt() );

			statement.execute();

			ResultSet generatedKeys = statement.getGeneratedKeys();

			if( generatedKeys.next() )
			{
				user.setId( generatedKeys.getLong( 1 ) );
			}
		}
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}
	}

	public void deleteUser( User user )
	{
		String sql = "DELETE FROM `JavaProject`.`users` WHERE id =" + user.getId();

		try{
			PreparedStatement statement = connection.prepareStatement( sql );
			statement.execute();
		}
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}
	}

	public void updateUser( User user )
	{
		String sql = "UPDATE `JavaProject`.`users` SET "
				+ "username =\"" + user.getUsername()
				+ "\", password=\"" + user.getPassword()
				+ "\", firstName=\"" + user.getFirstName()
				+ "\", lastName=\"" + user.getLastName()
				+ "\", email=\"" + user.getEmail() + "\" WHERE id = " + user.getId();

		PreparedStatement statement = null;

		try{
			statement = connection.prepareStatement( sql );
			statement.execute();
		}
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}
	}

	private List<User> getUsers( String sql )
	{
		List<User> users = new ArrayList<>(  );
		PreparedStatement statement = null;

		try{
			statement = this.connection.prepareStatement( sql );
			ResultSet resultSet = statement.executeQuery();

			while ( resultSet.next() )
			{
				User user = new User();

				user.setId( resultSet.getLong( "id" ) );
				user.setUsername( resultSet.getString( "username" ) );
				user.setPassword( resultSet.getString( "password" ) );
				user.setFirstName( resultSet.getString( "firstName" ) );
				user.setLastName( resultSet.getString( "lastName" ) );
				user.setEmail( resultSet.getString( "email" ) );
				user.setCreatedAt( resultSet.getString( "createdAt" ) );

				users.add( user );
			}
		}
		catch ( SQLException exception )
		{
			exception.printStackTrace();
		}
		return users;
	}

	private User getUser( String sql )
	{
		User user = new User();


		try{
			PreparedStatement statement = connection.prepareStatement( sql );
			ResultSet resultSet = statement.executeQuery();

			if( resultSet.next() )
			{
				user.setId( resultSet.getLong( "id" ) );
				user.setUsername( resultSet.getString( "username" ) );
				user.setPassword( resultSet.getString( "password" ) );
				user.setFirstName( resultSet.getString( "firstName" ) );
				user.setLastName( resultSet.getString( "lastName" ) );
				user.setEmail( resultSet.getString( "email" ) );
				user.setCreatedAt( resultSet.getString( "createdAt" ) );
			}
			else
			{
				user.setId( 0 );
			}
		}
		catch ( SQLException exception )
		{
			exception.printStackTrace();
		}
		return user;
	}
}
