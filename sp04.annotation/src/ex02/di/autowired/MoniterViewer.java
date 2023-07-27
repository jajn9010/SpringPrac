package ex02.di.autowired;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MoniterViewer {
	
	private Recorder recorder;
	
	public void userMethod(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("사용자(일반) 메소드 이용한 자동 주입");
	}
	
	public void print() {
		System.out.println("user method 주입 : " + this.recorder);
		recorder.show();
	}
}
