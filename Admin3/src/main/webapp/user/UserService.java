package user;

public interface UserService {
	
	boolean checkUser(String parametr, String paremetr2);
	
	void saveExamResultFor(String string, boolean isPassed);
	
	void addUser(String string, String password);

}
