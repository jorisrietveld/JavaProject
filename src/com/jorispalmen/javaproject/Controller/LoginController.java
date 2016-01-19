package com.jorispalmen.javaproject.Controller;

import com.jorispalmen.javaproject.bean.LoginBean;
import com.jorispalmen.javaproject.dao.DaoManager;
import com.jorispalmen.javaproject.dao.UserDaoImpl;
import com.jorispalmen.javaproject.model.User;
import com.jorispalmen.javaproject.security.PasswordHash;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 18-1-16 18:46
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.Controller
 */
public class LoginController
{
	private UserDaoImpl userDao;
	private User loggedInUser;

	public LoginController()
	{
		this.userDao = new DaoManager().getUserDao();
	}

	public Boolean validateLogin( LoginBean loginBean )
	{
		String username = loginBean.getUsername();
		String password = loginBean.getPassword();

		User user = this.getUser( username );

		if( user.getId() < 1 )
		{
			return false;
		}

		if( checkPassword( user, password ) )
		{
			this.setLoggedInUser( user );
			return true;
		}
		return false;
	}

	protected Boolean checkPassword( User user, String password )
	{
		try{
			return PasswordHash.validatePassword( password, user.getPassword() );
		}
		catch ( Exception ex )
		{
			ex.printStackTrace();
		}
		return false;
	}

	protected User getUser( String username )
	{
		return this.userDao.getUserByUsername( username.trim() );
	}

	public User getLogedInUser()
	{
		return this.loggedInUser;
	}

	public void setLoggedInUser( User user )
	{
		this.loggedInUser = user;
	}
}
