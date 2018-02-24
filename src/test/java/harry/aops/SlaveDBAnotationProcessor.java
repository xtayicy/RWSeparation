package harry.aops;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import harry.annotations.SlaveDB;
import harry.datasource.DataSourceType;

/**
 * 
 * @author harry
 *
 */
@Component
@Aspect
public class SlaveDBAnotationProcessor {
	private static Logger logger = LoggerFactory.getLogger(SlaveDBAnotationProcessor.class);

	@Around("execution(* harry.service..*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		logger.info("method = " + method.getName());
		
		if(method.isAnnotationPresent(SlaveDB.class)){
			DataSourceType.setReadOperation();
		}else{
			DataSourceType.setWriteOperation();
		}

		return pjp.proceed();
	}
}
