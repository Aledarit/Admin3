package test.login;

import net.sourceforge.jwebunit.junit.WebTester;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.NetworkConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginPage {

	private WebTester tester;
	private Server server;

	@Before
	public void init() throws Exception {
		tester = new WebTester();
		server = new Server(0);
		server.setHandler(new WebAppContext ("WebContent", "/Admin3"));
		server.stop();
		server.start();
		
		Connector[] connectors = server.getConnectors();
//		NetworkConnector connector = (NetworkConnector)connectors[0];
	//	int localPort = connector.getLocalPort();
//		int port = localPort;
		int port = 8090;
		System.out.println(port);
		server.join();

		tester.getTestContext().setBaseUrl(
				"http://localhost:" + port + "/Admin3");
	}
	
	@Test
	public void testLogin() {
		tester.beginAt("/");
		tester.assertFormPresent("form_login");
		tester.assertFormElementPresent("username");
		tester.assertFormElementPresent("password");
		tester.assertSubmitButtonPresent("Login");
		
	}
	
	@Test
	public void testLoginSuccesfully(){
		tester.beginAt("/");
		
		tester.setTextField("username", "sasha");
		tester.setTextField("password", "apofig");
		tester.clickButtonWithText ("Login");
		
		tester.assertTextPresent("you have successfully logged in");
		tester.assertTextPresent("User name: sasha");
		tester.assertTextPresent("Password: apofig");


		
	}
	
	
	@After //dangerzone!!! caution
	public void end() throws Exception {
		server.stop();
	}
	
}
