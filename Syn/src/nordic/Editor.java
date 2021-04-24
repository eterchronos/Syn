package nordic;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Editor extends Ui{

	private String path = "nulo";
	private Path filePath = Paths.get(path);
	private String textOpened;
	
	public Editor() {
		
	}

	public Path getFilePath() {
		return filePath;
	}

	public void setFilePath(Path filePath) {
		this.filePath = filePath;
		filePath = Paths.get(path);
	}
	
	
}
