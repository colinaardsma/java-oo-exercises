package Blogz;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class PostAndUserTest {

	// USER TESTS
	User u = new User("newUser", "pass1");
	User u2 = new User("newUser2", "pass12");
	User u3 = new User("newUser3", "pass123");
	User u4 = new User("newUser4", "pass1234");
	User u5 = new User("newUser5", "pass12345");
	User u6 = new User("newUser6", "pass123456");
	User u7 = new User("newUser7", "pass1234567");
	User u8 = new User("newUser8", "pass12345678");
	User u9 = new User("newUser9", "pass123456789");

	@Test
	public void createUserTest() {
		assertEquals("Did not setup new user", "Username: newUser / Password: 2n55>", u.toString());		
	}

	@Test
	public void userListTest() {
		assertEquals("Incorrect user list count", 9, User.getUserList().size(), 0);
		assertEquals("Incorrect user called", "Username: newUser2 / Password: 2n55>?", User.getUserList().get(1).toString());
		assertEquals("Incorrect user called", "Username: newUser3 / Password: 2n55>?@", User.getUserList().get(2).toString());
		assertEquals("Incorrect user called", "Username: newUser4 / Password: 2n55>?@A", User.getUserList().get(3).toString());
	}

	@Test
	public void passHashTest() {
		assertEquals("Password does not hash correctly", true, User.isValidPassword("pass1234", "2n55>?@A"));
	}

	@Test
	public void validUsernameTest() { // for some reason this adds 9 entries to userList
		assertEquals("Allows too short username", false, User.isValidUsername("me"));
		assertEquals("Allows too long username", false, User.isValidUsername("qwertyuiopasd"));
		assertEquals("Allows illegal characters", false, User.isValidUsername("!@#$%^"));
		assertEquals("Invalidates valid username", true, User.isValidUsername("aZ-_1234"));
	}
	
	@Test
	public void userUIDTest() { // for some reason this adds 9 entries to userList, postList and userList are stepping on each other, is entityList also?
		assertEquals("Incorrect UID", 6, u6.getUID(), 0);
		assertEquals("Incorrect UID", 1, u.getUID(), 0);
		assertEquals("Incorrect UID", 7, u7.getUID(), 0);
		assertEquals("Incorrect UID", 3, u3.getUID(), 0);
		assertEquals("Incorrect UID", 5, u5.getUID(), 0);
		assertEquals("Incorrect UID", 4, u4.getUID(), 0);
		assertEquals("Incorrect UID", 9, u9.getUID(), 0);
		assertEquals("Incorrect UID", 8, u8.getUID(), 0);
		assertEquals("Incorrect UID", 2, u2.getUID(), 0);
	}

	//POST TESTS
	Date date = new Date();
	Post p = new Post("title", "body");
	Post p2 = new Post("title2", "body2");
	Post p3 = new Post("title3", "body3");
	Post p4 = new Post("title4", "body4");
	Post p5 = new Post("title5", "body5");
	Post p6 = new Post("title6", "body6");
	Post p7 = new Post("title7", "body7");
	Post p8 = new Post("title8", "body8");
	Post p9 = new Post("title9", "body9");

	@Test
	public void createPostTest() {
		assertEquals("Did not setup new post", "Title: title\nBody:\nbody\nCreated: " + date + "\nModified: " + date, p.toString());
	}

	@Test
	public void postListTest() {
		assertEquals("Not all posts in postList", 9, Post.getPostList().size(), 0);
		assertEquals("Incorrect post called", "Title: title\nBody:\nbody\nCreated: " + date + "\nModified: " + date, Post.getPostList().get(0).toString());
		assertEquals("Incorrect post called", "Title: title2\nBody:\nbody2\nCreated: " + date + "\nModified: " + date, Post.getPostList().get(1).toString());
		assertEquals("Incorrect post called", "Title: title3\nBody:\nbody3\nCreated: " + date + "\nModified: " + date, Post.getPostList().get(2).toString());
	}
	
	@Test
	public void modifyTitleBodyTest() {
		p4.modifyTitleBody(p, "title10", "body10");
		assertFalse("Post was not modified", "Title: title\nBody:\nbody\nCreated: " + date + "\nModified: " + date == p.toString());
		assertEquals("New title is incorrect", "title10", p.getTitle());
		assertEquals("New body is incorrect", "body10", p.getBody());
		assertFalse("Created date has been modified", date == p.getCreated());
		assertEquals("Modified date is incorrect", date, p.getModified());
	}

	@Test
	public void modifyTitleTest() {
		p5.modifyTitle(p5, "title12");
		assertFalse("Post was not modified", "Title: title\nBody:\nbody\nCreated: " + date + "\nModified: " + date == p.toString());
		assertEquals("New title is incorrect", "title12", p.getTitle());
		assertFalse("Created date has been modified", date == p.getCreated());
		assertEquals("Modified date is incorrect", date, p.getModified());
	}

	@Test
	public void modifyBodyTest() {
		p6.modifyBody(p6, "body13");
		assertFalse("Post was not modified", "Title: title\nBody:\nbody\nCreated: " + date + "\nModified: " + date == p.toString());
		assertEquals("New body is incorrect", "body13", p.getBody());
		assertFalse("Created date has been modified", date == p.getCreated());
		assertEquals("Modified date is incorrect", date, p.getModified());
	}
	
	@Test
	public void postUIDTest() { // for some reason this adds 9 entries to userList
		assertEquals("Incorrect UID", 15, p6.getUID(), 0);
		assertEquals("Incorrect UID", 10, p.getUID(), 0);
		assertEquals("Incorrect UID", 16, p7.getUID(), 0);
		assertEquals("Incorrect UID", 12, p3.getUID(), 0);
		assertEquals("Incorrect UID", 14, p5.getUID(), 0);
		assertEquals("Incorrect UID", 13, p4.getUID(), 0);
		assertEquals("Incorrect UID", 18, p9.getUID(), 0);
		assertEquals("Incorrect UID", 17, p8.getUID(), 0);
		assertEquals("Incorrect UID", 11, p2.getUID(), 0);
	}

}
