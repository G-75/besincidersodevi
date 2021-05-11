package eTicaretSim�lasyon;

import eTicaretSim�lasyon.business.abstracts.UserService;
import eTicaretSim�lasyon.business.concretes.GoogleManager;
import eTicaretSim�lasyon.business.concretes.UserManager;
import eTicaretSim�lasyon.core.entities.GoogleAdapter;
import eTicaretSim�lasyon.database.concretes.TestUserDao;
import eTicaretSim�lasyon.entities.concretes.User;


public class Main {

	public static void main(String[] args) {
		User gulsevim=new User(3,"G�lsevim","�ener","gsener@gmail.com","159753");
		UserService userService = new UserManager(new TestUserDao(), new GoogleManager(new TestUserDao()), 
				new GoogleAdapter());
		
		userService.signUp(gulsevim);
		
		userService.logIn(gulsevim.geteMail(), gulsevim.getPassword());

	}

}
