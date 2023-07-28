package ex03.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogPrintHandlerImpl implements MethodInterceptor {

	private Object target;
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		System.out.println("invoke method start ..............................");
		
		//보조 업무 구현
		Log log = LogFactory.getLog(this.getClass());

		StopWatch sw = new StopWatch();
		sw.start(); // 시간 측정 시작
		log.info("타이머 시작");
		
		///////// main 관심 실행 /////////
		Object result = invocation.proceed();
		//////////////////////////////////
		
		sw.stop(); // 시간 측정 종료
		log.info("타이머 종료");

		log.info("[TimerLOG] Method : " + invocation.getMethod().getName());
		log.info("[TimerLOG] proecess Time : " + sw.getTotalTimeMillis()); // 작업이 걸린 총 시간
		
		return result;
	}

}
