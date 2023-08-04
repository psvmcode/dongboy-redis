package com.dongboy.annotation;

import com.dongboy.enums.IpLimitType;

import java.lang.annotation.*;

/**
 * @Author dongboy
 * @what time    2023/1/12 18:48
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface IpLimit {

    String name() default "";

    String key() default "";

    String prefix() default "";

    int period();

    int count();

    IpLimitType limitType() default IpLimitType.CUSTOMER;

}
