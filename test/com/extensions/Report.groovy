package com.extensions

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import org.spockframework.runtime.extension.ExtensionAnnotation

/**
 * This is oen of the examples pillaged from peter n. example code from 2011 which provides
 * an example of spock extensions
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtensionAnnotation(ReportExtension)
@interface Report {}
