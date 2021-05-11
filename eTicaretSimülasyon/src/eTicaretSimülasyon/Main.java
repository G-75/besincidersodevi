package eTicaretSimülasyon;

import eTicaretSimülasyon.business.abstracts.UserService;
import eTicaretSimülasyon.business.concretes.GoogleManager;
import eTicaretSimülasyon.business.concretes.UserManager;
import eTicaretSimülasyon.core.entities.GoogleAdapter;
import eTicaretSimülasyon.database.concretes.TestUserDao;
import eTicaretSimülasyon.entities.concretes.User;


public class Main {

	public static void main(String[] args) {
		User gulsevim=new User(3,"Gülsevim","Þener","gsener@gmail.com","159753");
		UserService userService = new UserManager(new TestUserDao(), new GoogleManager(new TestUserDao()), 
				new GoogleAdapter());
		
		userService.signUp(gulsevim);
		
		userService.logIn(gulsevim.geteMail(), gulsevim.getPassword());

	}

}
