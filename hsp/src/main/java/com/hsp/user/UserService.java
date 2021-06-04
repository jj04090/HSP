package com.hsp.user;

public interface UserService {
	public boolean login(User user);
	public void logout();
	public void registUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public User viewUser(User user);
	public void findID(User user);
	public void findPW(User user);
	public String encryptPW(String password);
}
