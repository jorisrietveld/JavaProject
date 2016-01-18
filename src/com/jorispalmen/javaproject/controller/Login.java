package com.jorispalmen.javaproject.controller;

import com.jorispalmen.javaproject.bean.LoginBean;
import com.jorispalmen.javaproject.dao.DaoManager;
import com.jorispalmen.javaproject.dao.UserDaoImpl;
import com.jorispalmen.javaproject.model.User;

/**
 * Created by: Joris Rieveld
 * Contact at: jorisrietveld@gmail.com
 * Created on: 15-1-16 14:16
 * Project : JavaProject
 * At package: com.jorispalmen.javaproject.controller
 */
public class Login
{
	private DaoManager daoManager;

	public Login()
	{
//		this.daoManager = new DaoManager();
//		this.daoManager.openConnection();
	}

	public Boolean validateLogin( LoginBean loginBean )
	{
		String username = loginBean.getUsername();
		String password = loginBean.getPassword();

		//User user = daoManager.getUserDao().getUserByUsername( username );

		return true;
	}

	protected Boolean checkPassword( User user, String password )
	{
		return password.equals( user.getPassword() );
	}
}
