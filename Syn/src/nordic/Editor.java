package nordic;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Editor {

	private String path = "";
	private Path filePath = Paths.get(path);
	private String textOpened="";
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
		filePath = Paths.get(path);
	}
	
	
	public String getOpenedFile() {
		try {
			
		byte[] text = Files.readAllBytes(filePath);
		this.textOpened = new String(text);
			
		}catch(Exception erro) {}
		return this.textOpened;
		
	}
	
	public void writeFile(String text) {
		try {
			
				Files.write(filePath,textOpened.getBytes());
				System.out.println("Caminho teste: "+path);

		
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
	};
}
