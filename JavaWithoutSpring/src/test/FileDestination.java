package test;

public class FileDestination implements MessageDestination{

	private MessageSource messageSource;

	public FileDestination(MessageSource messageSource) {
		this.messageSource = messageSource;// = new FileSource();
	}
	@Override
	public MessageSource getMessageSource() {
		// TODO Auto-generated method stub
		return this.messageSource;
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;	
	}
	@Override
	public void render() {
		// file I?O
		System.out.println("Send data to the file");
		System.out.println(this.messageSource.message());
		
	}

	
}
