package server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import common.UserInt;

public class User extends UnicastRemoteObject implements UserInt {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1123518265015014074L;
	
	private Storage storage;
	
	public User(Storage s) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		storage = s;
	}

	@Override
	public void register(String username, String password) throws IOException, RemoteException {
		// TODO Auto-generated method stub
		password = hashPassword(password);
		storage.add(username, password);
	}

	@Override
	public Boolean login(String username, String password) throws RemoteException, IOException {
		// TODO Auto-generated method stub
		password = hashPassword(password);
		String storedPassword = storage.get(username);
		return storedPassword.equals(password);
	}
	
	private String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			return Base64.getEncoder().encodeToString(bytes);
		}
		catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			return null;
		}
		
	}


}
