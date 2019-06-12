package at.fhv.persistencejava.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import at.fhv.persistencejava.dao.LoginDao;
import at.fhv.persistencejava.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		User userEntity = new User();
		userEntity.setUsername(userName);
		userEntity.setPassword(password);
		LoginDao loginDao = new LoginDao();
		try {
			String userValidate = loginDao.authenticateUser(userEntity);
			if (userValidate.equals("Admin")) {
				System.out.println("Admin's Home");
				HttpSession session = request.getSession(); // Creating a session
				session.setAttribute("Admin", userName); // setting session attribute
				request.setAttribute("username", userName);
				request.getRequestDispatcher("/Home.jsp").forward(request, response);
				
			} else if (userValidate.equals("Normal")) {
				System.out.println("Editor's Home");
				HttpSession session = request.getSession();
				session.setAttribute("Normal", userName);
				request.setAttribute("username", userName);
				request.getRequestDispatcher("/Home.jsp").forward(request, response);
			} else {
				System.out.println("Error message = " + userValidate);
				request.setAttribute("errMessage", userValidate);
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	} // End of doPost()
}
