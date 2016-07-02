package pl.edu.pk.shop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.edu.pk.shop.elements.user.Admin;
import pl.edu.pk.shop.elements.user.Client;
import pl.edu.pk.shop.elements.user.User;

public class LoginTest {
	
	User admin;
	User user;
	
	@Before
	public void getUser(){
		admin = new Admin(3);
		user = new Client(35);
	}
	
	@Test
	public void adminLoginTest() {
		String login = "tomekek@g.pl";
		String password = "pass";
		int id = User.authentication(login, password);
		
		User u = new Admin(id);
		assertSame("Login failed!", admin.data.id, id);
	}
	
	@Test
	public void clientLoginTest() {
		String login = "kkl@g.pl";
		String password = "pass";
		int id = User.authentication(login, password);
		
		User u = new Client(id);
		assertSame("Login failed!", user.data.id, id);
	}

}
