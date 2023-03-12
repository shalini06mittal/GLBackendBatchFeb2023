package test;

public class SystemDestination implements MessageDestination{

	private MessageSource messageSource;

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
		System.out.println("On the system's console");
		System.out.println(this.messageSource.message());
		
	}

	
}
