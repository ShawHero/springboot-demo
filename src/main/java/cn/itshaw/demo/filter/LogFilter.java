package cn.itshaw.demo.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Aspect
@Configuration
@Slf4j
public class LogFilter {

    @Around("execution(* global.hh.demo.controller..*.*(..))")
    public Object requestLog(ProceedingJoinPoint pjp){
        try {
            Signature sig = pjp.getSignature();
            MethodSignature msig = null;
            if (!(sig instanceof MethodSignature)) {
                log.error("This annotation can only be used for methods");
            }
            msig = (MethodSignature) sig;
            Object target = pjp.getTarget();
            Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());

            long startTime = System.currentTimeMillis();
            log.info("method:{} request:{}", currentMethod, pjp.getArgs() == null ? "" : JSON.toJSON(pjp.getArgs()));
            Object object = pjp.proceed ();
            long executeTime = System.currentTimeMillis() - startTime;
            log.info("method:{} response:{},executeTime :{}ms",currentMethod, object==null? "": JSON.toJSON(object),executeTime);
            return object;
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static void  main(String args[]){

    }

}