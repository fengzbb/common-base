package com.zbb.common.base.utils.copyproperties;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueMap {

    String value() default "";

    String sourceName() default "";

    String targetName() default "";
}
