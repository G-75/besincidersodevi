package eTicaretSimülasyon.database.abstracts;

import java.util.List;


import eTicaretSimülasyon.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void delete(User user);
	void update(User user);
	User getUser(int id);
	
	List<User> getAllUser();
	List<String> getAllEmails();
	List<String> getAllPasswords();
}
