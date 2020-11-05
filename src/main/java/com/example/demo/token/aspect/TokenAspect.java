package com.example.demo.token.aspect;


import com.example.demo.token.Annotation.TokenCheck;
import com.example.demo.token.controller.TokenController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


@Aspect
@Component
public class TokenAspect {

    @Pointcut("execution(public * com.example.demo.token.controller.TokenController.*(..))")
    public void TokenAspect() {

    }

    @Before("TokenAspect()")
    public void doBefore() {
        System.out.println("do before");
    }

    @After("TokenAspect()")
    public void doAfter() {
        System.out.println("do after");

    }

    @AfterReturning("TokenAspect()")
    public void doAfterReturn() {
        System.out.println("do after return");
    }

    @Around("TokenAspect()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("do around start");

        Object result = null;

        //session token验证
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        String token = request.getParameter("token");
        System.out.println("The token is " + token);

//        if (StringUtils.isEmpty(token)) {
//            return "Token is null";
//        }

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        TokenCheck annotation = method.getAnnotation(TokenCheck.class);

        // 添加token判断的逻辑代码
        if (annotation != null && annotation.check() == true) {
            System.out.println("do check before controller");
            return "token check fail";
        }

        result = proceedingJoinPoint.proceed();

        System.out.println("do around end");

        return result;
    }


}
