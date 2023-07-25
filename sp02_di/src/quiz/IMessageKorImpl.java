package quiz;

public class IMessageKorImpl implements IMessage {
	
	private String hello;
	
	IMessageKorImpl() {};
	
	IMessageKorImpl(String hello) {
		this.hello = hello;
	}
	
	@Override
	public void sayHello() {
		System.out.println(this.hello);
	}
}
