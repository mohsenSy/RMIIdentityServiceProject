package server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileStorage extends Storage {

	private String path;
	
	public FileStorage(String p) {
		// TODO Auto-generated constructor stub
		path = p;
	}
	
	@Override
	public Boolean add(String username, String password) throws IOException {
		// TODO Auto-generated method stub
		String filePath = String.format("%s/%s", path, username);
		File file = new File(filePath);
		FileWriter fw = new FileWriter(file);
		fw.write(password);
		fw.close();
		return true;
	}

	@Override
	public String get(String username) throws IOException {
		// TODO Auto-generated method stub
		return new String(Files.readAllBytes(Paths.get(username)));
	}

}
