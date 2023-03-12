package test;

public interface MessageDestination {

	public MessageSource getMessageSource();
	public void setMessageSource(MessageSource messageSource);
	public void render();
}
