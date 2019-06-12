package at.fhv.persistencejava;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import at.fhv.persistencejava.restcontrollers.ActorRestController;
import at.fhv.persistencejava.restcontrollers.FilmRestController;
import io.swagger.jaxrs.config.BeanConfig;

/**
 *
 * @author Dominik Mathmann
 */
@ApplicationPath("rest")
public class SwaggerApplication extends Application {

  public SwaggerApplication()
  {
    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setVersion("1.0.0");
    beanConfig.setSchemes(new String[]{"http"});
    beanConfig.setHost("localhost:8080/restservicejava-1.0-SNAPSHOT");
    beanConfig.setBasePath("/rest");
    beanConfig.setResourcePackage("at.fhv.persistencejava.restcontrollers");
    beanConfig.setScan(true);
  }

  @Override
  public Set<Class<?>> getClasses()
  {
    HashSet<Class<?>> set = new HashSet<>();
    set.add(ActorRestController.class);
    set.add(FilmRestController.class);
    set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
    set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

    return set;
  }
}
