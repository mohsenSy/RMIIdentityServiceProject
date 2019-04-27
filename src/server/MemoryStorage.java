package server;

import java.io.IOException;
import java.util.LinkedList;

public class MemoryStorage extends Storage {
	
	private LinkedList<String> users;
	private LinkedList<String> passwords;
	
	public MemoryStorage() {
		// TODO Auto-generated constructor stub
		users = new LinkedList<String>();
		passwords = new LinkedList<String>();
	}

	@Override
	public Boolean add(String username, String password) throws IOException {
		// TODO Auto-generated method stub
		synchronized (this) {
			users.add(username);
			passwords.add(password);	
		}
		return true;
	}

	@Override
	public String get(String username) throws IOException {
		// TODO Auto-generated method stub
		int passwordIndex = users.indexOf(username);
		if (passwordIndex == -1) {
			return null;
		}
		return passwords.get(passwordIndex);
	}

}
