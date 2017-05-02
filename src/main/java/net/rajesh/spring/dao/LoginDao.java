package net.rajesh.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.rajesh.spring.mvc.dto.LoginDto;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 */

@Component
public class LoginDao {

	private static List<LoginDto> users;
	{
		users = new ArrayList<>();
		users.add(new LoginDto("Rajesh", "1234567"));
		users.add(new LoginDto("mohan", "1234567"));
		users.add(new LoginDto("sajan", "1234567"));
		users.add(new LoginDto("rajan", "1234567"));
	}

	public List<LoginDto> list() {
		return users;
	}

	public boolean verifyUser(String userName, String password) {

		for (final LoginDto u : users) {
			if (u.getUserName().equals(userName) && u.getPassword().equals(password))
				return true;
		}
		return false;

	}

}