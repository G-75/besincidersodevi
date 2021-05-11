package eTicaretSimülasyon.database.concretes;


import java.util.ArrayList;
import java.util.List;

import eTicaretSimülasyon.database.abstracts.UserDao;
import eTicaretSimülasyon.entities.concretes.User;

public class TestUserDao implements UserDao{
	
	private List<User> users;

	public TestUserDao() {
	super();
	this.users = new ArrayList<User>();
	}

	@Override
	public void add(User user) {
		users.add(user);
	
	}

	@Override
	public void delete(User user) {
		User userForDeletion=users.stream().filter(u-> u.getId() == user.getId()).findFirst().get();
		users.remove(userForDeletion);
		System.out.println("User deleted: " + user.getFirstName() + user.getLastName());
	
	}

	@Override
	public void update(User user) {
		User userForUpdate=users.stream().filter(u-> u.getId() == user.getId()).findFirst().get();
		userForUpdate.setId(user.getId());
		userForUpdate.setFirstName(user.getFirstName());
		userForUpdate.setLastName(user.getLastName());
		user.seteMail(user.geteMail());
		user.setPassword(user.getPassword());
		System.out.println("User updated: " + user.getFirstName() + user.getLastName());
	
	}

	@Override
	public User getUser(int id) {
		return users.stream().filter(u -> u.getId() == id).findFirst().get();
	
	}

	@Override
	public List<User> getAllUser() {
		return users;
	}

	@Override
	public List<String> getAllEmails() {
		List<String> eMails=new ArrayList<String>();
		for(User user:users) {
			eMails.add(user.geteMail());
		}
		return eMails;
	}

	@Override
	public List<String> getAllPasswords() {
		List<String> passwords=new ArrayList<String>();
		for(User user:users) {
			passwords.add(user.getPassword());
		}
		return passwords;
	}
}