package Blogz;

import java.util.ArrayList;
import java.util.Date;

public class Post {
	private String title;
	private String body;
	private final Date created;
	private Date modified;
	private static ArrayList<Post> postList = new ArrayList<Post>();

	public Post(String title, String body) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.body = body;
		this.created = new Date();
		this.modified = created;
		Post.postList.add(this);
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getBody() {
		return this.body;
	}
	
	public Date getCreated() {
		return this.created;
	}
	
	public Date getModified() {
		return this.modified;
	}
		
	public void modifyTitleBody(Post p, String title, String body) {
		p.title = title;
		p.body = body;
		p.modified = new Date();
	}

	public void modifyTitle(Post p, String title) {
		p.title = title;
		p.modified = new Date();
	}

	public void modifyBody(Post p, String body) {
		p.body = body;
		p.modified = new Date();
	}

	public String toString() {
		return "Title: " + this.title + "\nBody:\n" + this.body + "\nCreated: " + this.created + "\nModified: " + this.modified;
	}
	
	public static ArrayList<Post> getPostList() {
		return postList;
	}
}
