package com.bree.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义hibernate validator z注解
 */
@Target({ElementType.METHOD,ElementType.FIELD})//表示该注解可是标注在方法上和字段上
@Retention(RetentionPolicy.RUNTIME)//表示该注解是一个运行时的一个注解
@Constraint(validatedBy = MyConstraintValidator.class)//表示这个注解需要实现一个什么样的类去进行校验，指向类
public @interface MyConstraint {
//    这三个属性实现hibernate validator必须要写的
    String message() default "{org.hibernate.validator.constraints.NotBlank.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
