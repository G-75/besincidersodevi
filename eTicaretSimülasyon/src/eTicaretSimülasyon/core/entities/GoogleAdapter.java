package eTicaretSimülasyon.core.entities;

import eTicaretSimülasyon.core.abstracts.SignUpService;
import eTicaretSimülasyon.entities.concretes.User;
import eTicaretSimülasyon.google.GoogleManager;

public class GoogleAdapter implements SignUpService{

	@Override
	public void signUpToSystem(User user) {
		GoogleManager googleManager = new GoogleManager();
		googleManager.signUp(user);
	}

}
