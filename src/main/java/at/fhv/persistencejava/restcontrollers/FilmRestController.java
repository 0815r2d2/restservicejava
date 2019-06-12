/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 12.06.2019
 */
package at.fhv.persistencejava.restcontrollers;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import at.fhv.persistencejava.entities.Film;
import at.fhv.persistencejava.facade.Facade;
import io.swagger.annotations.Api;

@Path("/film")
@Produces("application/json")
@Api(tags = { "film" })
public class FilmRestController {
	

	private Facade _facade = new Facade();

	@GET
	public List<Film> findAll() {
		return _facade.loadAllFilms();
	}

	@GET
	@Path("{id}")
	public Film findById(@PathParam("id") Integer id) {
		return _facade.loadFilm(id);
	}

	@POST
	public void create(Film film) {
		_facade.saveEntity(film);
	}

	@PUT
	@Path("{id}")
    public void update(@PathParam("id") Integer id, Film film) {
        _facade.saveEntity(film);
    }

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		_facade.removeFilm(id);
	}


}
