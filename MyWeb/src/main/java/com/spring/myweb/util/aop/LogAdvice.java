package com.spring.myweb.util.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect //AOP를 적용시킬 클래스
@Component //빈 등록
public class LogAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);

	/*
	 준비한 로직(advice)을 어떤 시점(join point)에서 사용하게 할 지를 정해줄수가 있습니다. (pointCut)
	 @before, @after, @afterThrowing
	 @around는 위에 있는 세가지 pointCut을 한번에 처리할 수 있도록 해줍니다.
	 메소드 실행 권한을 가지고 타겟 메소드랑 접목시켜서 사용.
	 규칙 - 반환타입은 Object, 매개변수로 메소드의 실행 시점을 결정짓는 ProceedingJoinPoint를 선언합니다.
	 ProceedingJoinPoint는 AOP의 대상이 되는 Target이나 파라미터 등을 파악할 뿐만 아니라
	 직접 실행을 결정할수도 있습니다.
	 
	 execution(accessModi(접근제한자) package(패키지) class(클래스) method(메소드) arguments(매개변수))
	*/
	//접근제한자 상관없음
	//com.spring.myweb으로 시작하는 패키지, 중간에 뭐 들어가는 지는 상관없고
	//서비스 패키지 안에 있는 이름이 ~~~Service로 끝나는 클래스의 모든 메소드(매개변수 관계 없음)
	@Around("execution(* com.spring.myweb.*.service.*Service.*(..))")
	public Object arroundLog(ProceedingJoinPoint jp) {
		
		long start = System.currentTimeMillis();
		logger.info("실행 클래스: " + jp.getTarget()); //실행되는 클래스가 무엇인지
		logger.info("실행 메소드: " + jp.getSignature().toString()); //실행되는 메소드들이 무엇인지
		logger.info("매개값: " + Arrays.toString(jp.getArgs())); //매개변수는 무엇인지
		
		Object result = null;
		try {
			result = jp.proceed(); //타겟 메소드의 실행를 요구하는 명령 메소드.
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		logger.info("메소드 소요 시간: " + (end-start)*0.001 + "초");
		
		//위에 작성한 이 메소드의 실행 내용은 proxy 환경에서 돌아가는 중이기 때문에
		//proceed()의 결과를 반환해야 메소드의 정상 흐름으로 돌아갑니다.
		return result; 
	}
	
}
