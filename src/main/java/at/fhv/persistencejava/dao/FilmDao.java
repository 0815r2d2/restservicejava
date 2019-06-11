/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 15.04.2019
 */
package at.fhv.persistencejava.dao;

import java.util.List;

import at.fhv.persistencejava.entities.Film;
import at.fhv.persistencejava.facade.Facade;

public class FilmDao {

	/**
	 * @return
	 */
	public List<Film> getAllFilms() {
		Facade facade = new Facade();
		return facade.loadAllFilms();
	}

}
