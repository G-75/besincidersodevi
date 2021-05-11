package eTicaretSim�lasyon.core.entities;

import eTicaretSim�lasyon.core.abstracts.SignUpService;
import eTicaretSim�lasyon.entities.concretes.User;
import eTicaretSim�lasyon.google.GoogleManager;

public class GoogleAdapter implements SignUpService{

	@Override
	public void signUpToSystem(User user) {
		GoogleManager googleManager = new GoogleManager();
		googleManager.signUp(user);
	}

}
