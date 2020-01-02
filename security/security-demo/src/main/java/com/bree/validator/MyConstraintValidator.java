package com.bree.validator;

import com.bree.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * 验证的实现
 *需实现ConstraintValidator<A,T>  第一个繁星表示需要验证的注解，第二个泛型表示验证的参数的类型
 * 由于该类实现了ConstraintValidator接口 所以该类已经是一个Bean
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println(" my validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        helloService.greeting("tom");
        System.out.println(value);
        return false;
    }
}
