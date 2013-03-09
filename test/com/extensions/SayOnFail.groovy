package com.extensions

import org.spockframework.runtime.extension.ExtensionAnnotation

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * Example "borrowed" from Zan Thrash... too good not to share
 *
 * @author kensipe
 */
@Retention(RetentionPolicy.RUNTIME)
@Target([ElementType.TYPE, ElementType.METHOD])
@ExtensionAnnotation(SayOnFailExtension)

public @interface SayOnFail {
    String value() default 'Failure is not an option'
    String voice() default "Alex"
}