package com.jorispalmen.javaproject.Controller;

import com.jorispalmen.javaproject.bean.RegisterBean;
import com.jorispalmen.javaproject.dao.DaoManager;
import com.jorispalmen.javaproject.dao.UserDaoImpl;
import com.jorispalmen.javaproject.model.User;
import com.jorispalmen.javaproject.security.PasswordHash;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 18-1-16 21:02
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.Controller
 */
public class RegisterController
{
	private UserDaoImpl userDao;
	private String feedback = "";

	public RegisterController()
	{
		userDao = new DaoManager().getUserDao();
	}

	public Boolean RegisterUser( RegisterBean registerBean )
	{
		if(!usernameIsUnique( registerBean.getUsername()) || !emailIsUnique( registerBean.getEmail() ))
		{
			return false;
		}

		try
		{
			User newUser = new User(  );

			newUser.setUsername( registerBean.getUsername() );
			newUser.setPassword( hashPassword( registerBean.getPassword() ) );
			newUser.setFirstName( registerBean.getFirstName() );
			newUser.setLastName( registerBean.getLastName() );
			newUser.setEmail( registerBean.getEmail() );
			newUser.setCreatedAt( new Date( System.currentTimeMillis() ).toString() );

			userDao.insertUser( newUser );
			return true;
		}
		catch ( Exception exception )
		{
			setFeedback( exception.getMessage() );
			return false;
		}
	}

	public String getFeedback()
	{
		return this.feedback;
	}

	protected void setFeedback( String feedback )
	{
		this.feedback = feedback;
	}

	private String hashPassword( String password ) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		return PasswordHash.createHash( password );
	}

	private Boolean usernameIsUnique( String username )
	{
		User user = userDao.getUserByUsername( username );

		if( user.getId()<1 )
		{
			return true;
		}
		else
		{
			this.feedback = "De gebruikersnaam bestaat al.";
			return false;
		}
	}

	private Boolean emailIsUnique( String email )
	{
		User user = userDao.getUserByEmail( email );

		if( user.getId()<1 )
		{
			return true;
		}
		else
		{
			this.feedback = "Er is al een acount geregistreert met dit email address.";
			return false;
		}
	}
}
