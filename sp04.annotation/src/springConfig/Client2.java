package springConfig;

import lombok.Setter;

@Setter
public class Client2 {
	private String host;
	
	public void connect() throws Exception {
		System.out.println("Client2.connetct() 실행 - 초기화 메소드");
	}
	
	public void send() {
		System.out.println("Client2.send() call : " + host);
	}
	
	public void close() throws Exception {
		System.out.println("Client2.close() call - 소멸 메소드");
	}
}
