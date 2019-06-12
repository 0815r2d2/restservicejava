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
public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddFilmServlet() {
		super();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDao filmdao = new FilmDao();
		String film = request.getParameter("title");
		filmdao.addFilm(film);
		request.getRequestDispatcher("/ListFilmServlet").forward(request, response);
	}
}
