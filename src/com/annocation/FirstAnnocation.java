package com.annocation;

import java.lang.annotation.*;

/**
 * @author ng
 * @date 2019/12/5-18:16
 */
@Documented
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstAnnocation {

    String first() default "";
}
