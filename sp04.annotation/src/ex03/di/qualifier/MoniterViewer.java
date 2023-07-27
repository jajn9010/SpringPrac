package ex03.di.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MoniterViewer {
	private Recorder recorder;

	/*
	 * //@Inject
	 * 
	 * @Autowired(required = false) public MoniterViewer(@Qualifier("cord") Recorder
	 * recorder) { this.recorder = recorder; System.out.println("@Autowired 자동 주입");
	 * }
	 */
	
	/*
	 * @Autowired
	 * 
	 * @Qualifier("key") public void setRecorder(Recorder recorder) { this.recorder
	 * = recorder; }
	 */
	
	@Autowired
	public void setRecorder(@Qualifier("cord") Recorder recorder) {
		this.recorder = recorder;
	}
	
	public void show() {
		recorder.show();
		System.out.println("MonitherViewer class show method call~~~");
		System.out.println("setter method MoniterViewer class show method call~~~");
	}
}
