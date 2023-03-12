package test;

public class FileSource implements MessageSource{

	@Override
	public String message() {
		// file I/O
		return "A message from the file";
	}

}
