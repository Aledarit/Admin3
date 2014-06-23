package test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.easymock.EasyMock;
import servlet.LoginController;

public class LoginControllerTest {
	


@Test
public void testLogin() throws ServletException, IOException {
	LoginController controller = new LoginController();
	HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
	HttpServletResponse response = EasyMock.createMock(HttpServletResponse.class);
	RequestDispatcher requestDispatcher = EasyMock.createMock(RequestDispatcher.class);
	
	EasyMock.expect(request.getParameter("username")).andReturn("sasha");
	EasyMock.expect(request.getParameter("password")).andReturn("apofig");
	
	EasyMock.expect(request.getRequestDispatcher("succesfulLogin.jsp")).andReturn(requestDispatcher);
	
	requestDispatcher.forward(request, response);

	EasyMock.replay(request, response, requestDispatcher);
	controller.doPost(request, response);
	EasyMock.verify(request, response, requestDispatcher);
}


}