package at.fhv.persistencejava.restcontrollers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import at.fhv.persistencejava.entities.Customer;

/**
 *
 * @author Dominik Mathmann
 */
@Path("/customer")
@Produces("application/json")
@Api(tags = "customer")
public class CustomerAPI {

  @GET
  @ApiOperation(value = "Returns one random customer", notes = "Mock Implementation", response = Customer.class)
  public Customer getCustomer()
  {
    Customer customer = new Customer("C100", "Example Company", "Max Mustermann", "", "Street 23", "Bielefeld", "NRW",
        "33611", "Deutschland", "", "");

    return customer;
  }
}
