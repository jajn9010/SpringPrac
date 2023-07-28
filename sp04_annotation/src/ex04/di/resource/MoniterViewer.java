package ex04.di.resource;

import javax.annotation.Resource;

public class MoniterViewer {
	
	private Recorder recorder; //has - a;

	@Resource(name = "r3")
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		
		boolean record = Resource.class.getName().equals("r3");
		System.out.println(record);
		
		recorder.show();
		System.out.println(recorder);
		System.out.println("@Resource Injection");
	}
}
