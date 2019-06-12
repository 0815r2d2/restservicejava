package at.fhv.persistencejava.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.fhv.persistencejava.dao.FilmDao;
import at.fhv.persistencejava.entities.Film;

/**
 * Servlet implementation class ListFilmServlet
 */
public class ListFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListFilmServlet() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDao filmdao = new FilmDao();
		List<Film> films = filmdao.getAllFilms();
		request.setAttribute("films", films);
		request.getRequestDispatcher("/ListFilm.jsp").forward(request, response);
	}
}
