package server;

import java.io.IOException;

public abstract class Storage {
	
	public abstract Boolean add(String username, String password) throws IOException;
	public abstract String get(String username) throws IOException;

}
