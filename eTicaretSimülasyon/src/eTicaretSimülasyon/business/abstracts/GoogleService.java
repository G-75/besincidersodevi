package eTicaretSim�lasyon.business.abstracts;

public interface GoogleService {
	boolean isMailValid(String email);
	boolean isPasswordValid(String password);
	boolean isMailUsedBefore(String email);

}
