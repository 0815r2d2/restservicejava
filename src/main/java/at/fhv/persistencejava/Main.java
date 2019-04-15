/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 10.04.2019
 */
package at.fhv.persistencejava;

import at.fhv.persistencejava.entities.Role;
import at.fhv.persistencejava.entities.User;
import at.fhv.persistencejava.facade.Facade;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Facade fac = new Facade();
		Role role1 = new Role();
		role1.setName("Admin");
		Role role2 = new Role();
		role2.setName("Normal");
		
		fac.saveEntity(role1);
		fac.saveEntity(role2);
		
		User user1 = new User();
		user1.setUsername("Bianca");
		user1.setPassword("123");
		user1.setRole(role1);
		
		User user2 = new User();
		user2.setUsername("Michael");
		user2.setPassword("123");
		user2.setRole(role2);
		
		fac.saveEntity(user1);
		fac.saveEntity(user2);
	}
}
