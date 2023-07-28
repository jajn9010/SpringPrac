package ex01.java;

public class MainEntry {
	public static void main(String[] args) {
		Calc c = new Calc();
		
		System.out.println(c.add(1, 2));
		System.out.println(c.add(10, 20));
		System.out.println();
		System.out.println(c.mul(5, 7));
		System.out.println(c.mul(10, 8, 6));
	}
}
