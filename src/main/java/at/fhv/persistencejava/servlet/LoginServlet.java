package at.fhv.persistencejava.servlet;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.fhv.persistencejava.dao.FilmDao;
import at.fhv.persistencejava.entities.Film;
import at.fhv.persistencejava.entities.User;
import at.fhv.persistencejava.facade.Facade;

@WebServlet("/private/users")
@RequestScoped
@ServletSecurity(httpMethodConstraints = {
	@HttpMethodConstraint(value = "GET", rolesAllowed = {"USER", "ADMIN"}),
	@HttpMethodConstraint(value = "POST", rolesAllowed = {"ADMIN"})
})
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static final String FORM_VIEW = "/WEB-INF/view/users/Login.jsp";
	private static final String LIST_VIEW = "/WEB-INF/view/users/film-list.jsp";
	
	@Inject
	private Facade _facade = new Facade();;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("add") != null) {
			form(request, response);
		} else {
			list(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object id = request.getParameter("id");
	//	Object login = request.getParameter("login");
		Object password = request.getParameter("password");
		
		User user = new User();
		
		if (id != null)
			user.setId((Integer) id);
		
		//user.setLogin((String) login);
		user.setPassword((String) password);
		_facade.saveEntity(user);
		list(request, response);
	}
	
	private void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(FORM_VIEW).forward(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDao filmdao = new FilmDao();
		List<Film> films = filmdao.getAllFilms();
		request.setAttribute("users", films);
		request.getRequestDispatcher(LIST_VIEW).forward(request, response);
	}
	
}