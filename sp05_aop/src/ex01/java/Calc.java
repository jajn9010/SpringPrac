package ex01.java;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class Calc { // 사칙연산 프로그램 - 덧셈, 뺄셈, 곱셈, 나눗셈

	public int add(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());

		StopWatch sw = new StopWatch();
		sw.start(); // 시간 측정 시작
		log.info("타이머 시작");

		int result = x + y; // 중점이 되는 코드

		sw.stop(); // 시간 측정 종료
		log.info("타이머 종료");

		log.info("[TimerLOG] Method : add");
		log.info("[TimerLOG] proecess Time : " + sw.getTotalTimeMillis()); // 작업이 걸린 총 시간

		return result;
	}

	public int mul(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());

		StopWatch sw = new StopWatch();
		sw.start(); // 시간 측정 시작
		log.info("타이머 시작");

		int result = x * y; // 중점이 되는 코드

		sw.stop(); // 시간 측정 종료
		log.info("타이머 종료");

		log.info("[TimerLOG] Method : mul");
		log.info("[TimerLOG] proecess Time : " + sw.getTotalTimeMillis()); // 작업이 걸린 총 시간

		return result;
	}
	
	public int mul(int x, int y, int z) {
		Log log = LogFactory.getLog(this.getClass());

		StopWatch sw = new StopWatch();
		sw.start(); // 시간 측정 시작
		log.info("타이머 시작");

		int result = x * y * z; // 중점이 되는 코드

		sw.stop(); // 시간 측정 종료
		log.info("타이머 종료");

		log.info("[TimerLOG] Method : mul");
		log.info("[TimerLOG] proecess Time : " + sw.getTotalTimeMillis()); // 작업이 걸린 총 시간

		return result;
	}
}
