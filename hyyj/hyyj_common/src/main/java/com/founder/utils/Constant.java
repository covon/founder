package com.founder.utils;

import java.util.ResourceBundle;

public interface Constant {

	static final String DB_driver = ResourceBundle.getBundle("jdbc").getString("driver");
	static final String DB_url = ResourceBundle.getBundle("jdbc").getString("url");
	static final String DB_dbuser = ResourceBundle.getBundle("jdbc").getString("username");
	static final String DB_dbpwd = ResourceBundle.getBundle("jdbc").getString("password");
	
	static final String EZ_driver = ResourceBundle.getBundle("jdbc").getString("dbdriver");
	static final String EZ_url = ResourceBundle.getBundle("jdbc").getString("dburl");
	static final String EZ_user = ResourceBundle.getBundle("jdbc").getString("dbuser");
	static final String EZ_pwd = ResourceBundle.getBundle("jdbc").getString("dbpwd");
 
	static final String mqlog = ResourceBundle.getBundle("parameters").getString("mqlogfile");
	
	static final String EZ_MANAGER_LOCATION = ResourceBundle.getBundle("parameters").getString("ez_manager_location");
	static final String EC_SYSTEM_NAME = ResourceBundle.getBundle("parameters").getString("ec_system_name");
	static final String AHTUURL = ResourceBundle.getBundle("parameters").getString("AHTUURL");
	static final String URLSTR = ResourceBundle.getBundle("parameters").getString("URLSTR");

}

