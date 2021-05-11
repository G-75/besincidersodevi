package eTicaretSimülasyon.business.concretes;


import java.util.List;

import eTicaretSimülasyon.business.abstracts.GoogleService;
import eTicaretSimülasyon.business.abstracts.UserService;
import eTicaretSimülasyon.core.abstracts.SignUpService;
import eTicaretSimülasyon.database.abstracts.UserDao;
import eTicaretSimülasyon.entities.concretes.User;
import eTicaretSimülasyon.google.GoogleManager;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private GoogleService googleService;
	private SignUpService signUpService;

   	public UserManager(UserDao userDao, GoogleService googleService, SignUpService signUpService) {
		super();
		this.userDao = userDao;
		this.googleService = googleService;
		this.signUpService = signUpService;
	}


	@Override
	public void signUp(User user) {
		if(user.getPassword().length()<6 && user.getFirstName().length()<2 && user.getLastName().length()<2) {
			System.out.println("Length of Password must be at least 6! Length of First name and Last name must be at least 2!");
			return;
		}
		
		if(googleService.isMailUsedBefore(user.geteMail())) {
			System.out.println("Email address: "+user.geteMail() + "is already in use. Please enter another Email address.");
			return;
		}
	
		userDao.add(user);
		signUpService.signUpToSystem(user);
		System.out.println("User signed up succesfully. Email send to " + user.geteMail());
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public void update(User user) {
		if(googleService.isMailValid(user.geteMail()) && googleService.isPasswordValid(user.getPassword())){
            userDao.update(user);
            return;
		}
		
	}

	@Override
	public void logIn(String email, String password) {
		if(googleService.isMailValid(email)){
            System.out.println("User logged in.");
		}
		
	}

	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> getAllUser() {
		 return userDao.getAllUser();
	}
	
	
	
}