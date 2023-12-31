package ex05.aop;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

public class LogPrintAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("AfterReturningAdvice Start");
		Log log = LogFactory.getLog(this.getClass());
		log.info("[AfterReturningAdvice] 주업무 실행되고 돌아와서 바로 실행");
		System.out.println("[AfterReturning Method] :" + method.getModifiers());
		System.out.println("[Return Value] :" + returnValue);
		System.out.println("[args Value] :" + args.toString());
	}

}
