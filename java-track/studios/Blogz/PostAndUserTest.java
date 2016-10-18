package Blogz;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class PostAndUserTest {

	// USER TESTS
	@Test
	public void createUserTest() {
		User u = new User("newUser", "pass1234");
		assertEquals("Did not setup new user", "Username: newUser / Password: 2n55>?@A", u.toString());
	}

	@Test
	public void userListTest() {
		User u = new User("newUser", "pass1234");
		User u2 = new User("newUser2", "pass12345");
		User u3 = new User("newUser3", "pass123456");

		assertEquals("Not all users in userList", 3, User.getUserList().size(), 0);
		assertEquals("Incorrect user called", "Username: newUser / Password: 2n55>?@A", User.getUserList().get(0).toString());
		assertEquals("Incorrect user called", "Username: newUser2 / Password: 2n55>?@AB", User.getUserList().get(1).toString());
		assertEquals("Incorrect user called", "Username: newUser3 / Password: 2n55>?@ABC", User.getUserList().get(2).toString());
	}

	@Test
	public void passHashTest() {
		assertEquals("Password does not hash correctly", true, User.isValidPassword("pass1234", "2n55>?@A"));
	}

	@Test
	public void validUsernameTest() {
		assertEquals("Allows too short username", false, User.isValidUsername("me"));
		assertEquals("Allows too long username", false, User.isValidUsername("qwertyuiopasd"));
		assertEquals("Allows illegal characters", false, User.isValidUsername("!@#$%^"));

		assertEquals("Invalidates valid username", true, User.isValidUsername("aZ-_1234"));
	}

	//POST TESTS
	@Test
	public void createPostTest() {
		Date date = new Date();
		Post p = new Post("title", "body");
		assertEquals("Did not setup new post", "Title: title\nBody:\nbody\nCreated: " + date + "\nModified: " + date, p.toString());
	}

	@Test
	public void postListTest() {
		Date date = new Date();
		Post p = new Post("title", "body");
		Post p2 = new Post("title2", "body2");
		Post p3 = new Post("title3", "body3");

		assertEquals("Not all posts in postList", 3, Post.getPostList().size(), 0);
		assertEquals("Incorrect post called", "Title: title\nBody:\nbody\nCreated: " + date + "\nModified: " + date, Post.getPostList().get(0).toString());
		assertEquals("Incorrect post called", "Title: title2\nBody:\nbody2\nCreated: " + date + "\nModified: " + date, Post.getPostList().get(1).toString());
		assertEquals("Incorrect post called", "Title: title3\nBody:\nbody3\nCreated: " + date + "\nModified: " + date, Post.getPostList().get(2).toString());
	}
	
	@Test
	public void modifyTitleBodyTest() {
		Date date = new Date();
		Post p = new Post("title", "body");
		p.modifyTitleBody(p, "title2", "body2");
		assertFalse("Post was not modified", "Title: title\nBody:\nbody\nCreated: " + date + "\nModified: " + date == p.toString());
		assertEquals("New title is incorrect", "title2", p.getTitle());
		assertEquals("New body is incorrect", "body2", p.getBody());
		assertFalse("Created date has been modified", date == p.getCreated());
		assertEquals("Modified date is incorrect", date, p.getModified());
	}

	@Test
	public void modifyTitleTest() {
		Date date = new Date();
		Post p = new Post("title", "body");
		p.modifyTitle(p, "title2");
		assertFalse("Post was not modified", "Title: title\nBody:\nbody\nCreated: " + date + "\nModified: " + date == p.toString());
		assertEquals("New title is incorrect", "title2", p.getTitle());
		assertFalse("Created date has been modified", date == p.getCreated());
		assertEquals("Modified date is incorrect", date, p.getModified());
	}

	@Test
	public void modifyBodyTest() {
		Date date = new Date();
		Post p = new Post("title", "body");
		p.modifyBody(p, "body2");
		assertFalse("Post was not modified", "Title: title\nBody:\nbody\nCreated: " + date + "\nModified: " + date == p.toString());
		assertEquals("New body is incorrect", "body2", p.getBody());
		assertFalse("Created date has been modified", date == p.getCreated());
		assertEquals("Modified date is incorrect", date, p.getModified());
	}

}
