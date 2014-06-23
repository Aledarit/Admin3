package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.UserService;

import java.io.IOException;
import java.io.PrintWriter;


public class AdminController extends HttpServlet {

	//private UserService users = UserFactory.createUserService();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		final String mode = request.getParameter ("mode");
		if ("add_user".equals(mode)) {
		//	users.addUser(request.getParameter("user_name"), request.getParameter("password"));
		} else {
			//in process
		}
		request.getRequestDispatcher("addUser.jsp").forward(request, response);
	}
	
}
