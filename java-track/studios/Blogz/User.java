package Blogz;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class User {
	
	private String username;
	private String password;
	private static ArrayList<User> userList = new ArrayList<User>();

	public User(String username, String password) {
		// TODO Auto-generated constructor stub
		if (isValidUsername(username)) {
			this.username = username;
		}
		this.password = User.hashPassword(password);
		User.userList.add(this);
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String toString() {
		return "Username: " + this.username + " / Password: " + this.password;
	}
	
	public static String hashPassword(String password) {
		int shift = 13;
		String hashPass = "";
		
		for (int i = 0; i < password.length(); i++) {
			char c = (char)(password.charAt(i) + shift);
			if (c > 'z') {
				c = (char)(password.charAt(i) - (75 - shift));
			}
			hashPass += Character.toString(c);
		}
		return hashPass;
	}
	
	public static boolean isValidPassword(String password, String hashPassword) {
		if (User.hashPassword(password).equals(hashPassword)) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidUsername(String username) {
		boolean validName = Pattern.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}", username);
		return validName;
	}
	
	public static ArrayList<User> getUserList() {
		return userList;
	}
	
}
