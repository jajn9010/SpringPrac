package ex03.nonDI;

import java.util.Scanner;

public class IRecordViewImpl implements IRecordView {
	
	private IRecordImpl record;

	//setter method 주입하기
	public void setRecord(IRecordImpl record) {
		this.record = record;
	}

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("kor : "); record.setKor(sc.nextInt());
		System.out.println("eng : "); record.setEng(sc.nextInt());
		System.out.println("com : "); record.setCom(sc.nextInt());
	}

	@Override
	public void print() {
		System.out.println("\n\nKOR ; " + record.getKor());
		System.out.println("ENG ; " + record.getEng());
		System.out.println("COM ; " + record.getCom());
		
		System.out.println("total : " + record.total() + "\navg : " + record.avg());
	}

}
