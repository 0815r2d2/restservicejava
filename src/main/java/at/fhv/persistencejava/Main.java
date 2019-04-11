/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 10.04.2019
 */
package at.fhv.persistencejava;

import java.util.List;

import at.fhv.persistencejava.entities.Actor;
import at.fhv.persistencejava.facade.Facade;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Facade fac = new Facade();
		List<Actor> actors = fac.loadAllActors();
		for(Actor act : actors) {
			System.out.println(act);
		}
	}

}
