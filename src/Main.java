import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import server.FileStorage;
import server.MemoryStorage;
import server.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String objectName = null;
		try {
			objectName = args[0];
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Please supply service name");
			System.exit(1);
		}
		try {
			FileStorage fs = new FileStorage("users");
			User user = new User(fs);
			Naming.rebind("rmi://localhost:1099/" + objectName, user);
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
