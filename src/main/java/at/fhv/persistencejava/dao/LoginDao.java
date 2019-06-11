/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 14.04.2019
 */
package at.fhv.persistencejava.dao;

import java.util.List;

import at.fhv.persistencejava.entities.User;
import at.fhv.persistencejava.facade.Facade;

public class LoginDao {

	public String authenticateUser(User userEntity) {
		String userName = userEntity.getUsername();
		String password = userEntity.getPassword();

		Facade facade = new Facade();

		List<User> users = facade.loadAllUsers();

		for (User user : users) {
			String userNameDB = user.getUsername();
			String passwordDB = user.getPassword();

			String roleDB = user.getRole().getName();

			if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
				return "Admin";
			else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Normal"))
				return "Normal";
		}
		return "Invalid user credentials";
	}
}
