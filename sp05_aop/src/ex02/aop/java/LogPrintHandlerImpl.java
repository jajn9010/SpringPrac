package ex02.aop.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LogPrintHandlerImpl implements InvocationHandler {

	private Object target;
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { // 보조프로그램 구현
		
		System.out.println("invoke method start ..............................");
		
		//보조 업무 구현
		Log log = LogFactory.getLog(this.getClass());

		StopWatch sw = new StopWatch();
		sw.start(); // 시간 측정 시작
		log.info("타이머 시작");
		
		///////// main 관심 실행 /////////
		int result = (int) method.invoke(target, args);
		//////////////////////////////////
		
		sw.stop(); // 시간 측정 종료
		log.info("타이머 종료");

		log.info("[TimerLOG] Method : " + method.getName());
		log.info("[TimerLOG] proecess Time : " + sw.getTotalTimeMillis()); // 작업이 걸린 총 시간
		
		return result;
	}

}
