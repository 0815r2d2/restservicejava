/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 09.04.2019
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
import javax.ws.rs.core.MediaType;

import at.fhv.persistencejava.entities.Actor;
import at.fhv.persistencejava.facade.Facade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/actor")
@Produces("application/json")
@Api(tags = { "actor" })
public class ActorRestController {

	private Facade _facade = new Facade();

	@GET
	public List<Actor> findAll() {
		return _facade.loadAllActors();
	}

	@GET
	@Path("{id}")
	public Actor findById(@PathParam("id") Integer id) {
		return _facade.loadActor(id);
	}

	@POST
	public void create(Actor actor) {
		_facade.saveEntity(actor);
	}

	@PUT
	@Path("{id}")
    public void update(@PathParam("id") Integer id, Actor actor) {
        _facade.saveEntity(actor);
    }

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		_facade.removeActor(id);
	}

}
