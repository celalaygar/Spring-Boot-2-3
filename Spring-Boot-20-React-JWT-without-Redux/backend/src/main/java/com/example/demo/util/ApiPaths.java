package com.example.demo.util;

public class ApiPaths {
	private static final String BASE_PATH = "/api";
	private static final String LOGIN_PATH = "/login";
	private static final String USER_PATH = "/user";
	private static final String BUILDING_PATH = "/building";
	
	public static final class UserCtrl {
		public static final String CTRL = BASE_PATH + USER_PATH;
	}
	public static final class LoginCtrl {
		public static final String CTRL = BASE_PATH + LOGIN_PATH;
	}
	public static final class BuildingCtrl {
		public static final String CTRL = BASE_PATH + BUILDING_PATH;
	}
}
