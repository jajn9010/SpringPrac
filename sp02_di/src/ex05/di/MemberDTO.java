package ex05.di;

import lombok.Data;

@Data
public class MemberDTO { //model
	private String name, message;
	private int age;
	
	public MemberDTO() {
		System.out.println("MemberDTO default constructor");
	}

	public MemberDTO(String name, String message, int age) {
		System.out.println("MemberDTO 필드를 전부 가지는 DTO");
		this.name = name;
		this.message = message;
		this.age = age;
	}
}
